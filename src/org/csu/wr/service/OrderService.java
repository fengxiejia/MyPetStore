package org.csu.wr.service;

import org.csu.wr.domain.Item;
import org.csu.wr.domain.LineItem;
import org.csu.wr.domain.Orders;
import org.csu.wr.persistence.ItemDAO;
import org.csu.wr.persistence.LineItemDAO;
import org.csu.wr.persistence.OrdersDAO;
import org.csu.wr.persistence.SequenceDAO;
import org.csu.wr.persistence.impl.ItemDAOImpl;
import org.csu.wr.persistence.impl.LineItemDAOImpl;
import org.csu.wr.persistence.impl.OrdersDAOImpl;
import org.csu.wr.persistence.impl.SequenceDAOImpl;

import org.csu.wr.domain.Sequence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    private ItemDAO itemDAO;
    private OrdersDAO orderDAO;
    private SequenceDAO sequenceDAO;
    private LineItemDAO lineItemDAO;

    public OrderService(){
        itemDAO = new ItemDAOImpl();
        orderDAO = new OrdersDAOImpl();
        sequenceDAO = new SequenceDAOImpl();
        lineItemDAO = new LineItemDAOImpl();
    }

    public void insertOrder(Orders order) {
        order.setOrderId(getNextId("ordernum"));
        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = (LineItem) order.getLineItems().get(i);
            String itemId = lineItem.getItemId();
            Integer increment = new Integer(lineItem.getQuantity());
            Map<String, Object> param = new HashMap<String, Object>(2);
            param.put("itemId", itemId);
            param.put("increment", increment);
            itemDAO.updateInventoryQuantity(param);
        }

        orderDAO.insertOrder(order);
        orderDAO.insertOrderStatus(order);
        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = (LineItem) order.getLineItems().get(i);
            lineItem.setOrderId(order.getOrderId());
            lineItemDAO.insertLineItem(lineItem);
        }
    }

    public Orders getOrder(int orderId) {
        Orders order = orderDAO.getOrder(orderId);
        order.setLineItems(lineItemDAO.getLineItemsByOrderId(orderId));

        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = (LineItem) order.getLineItems().get(i);
            Item item = itemDAO.getItem(lineItem.getItemId());
            item.setQuantity(itemDAO.getInventoryQuantity(lineItem.getItemId()));
            lineItem.setItem(item);
        }

        return order;
    }

    public List<Orders> getOrdersByUsername(String username) {
        return orderDAO.getOrdersByUsername(username);
    }

    public int getNextId(String name) {
        Sequence sequence = new Sequence(name, -1);
        sequence = sequenceDAO.getSequence(sequence);
        if (sequence == null) {
            throw new RuntimeException("Error: A null sequence was returned from the database (could not get next " + name
                    + " sequence).");
        }
        Sequence parameterObject = new Sequence(name, sequence.getNextId() + 1);
        sequenceDAO.updateSequence(parameterObject);
        return sequence.getNextId();
    }
}
