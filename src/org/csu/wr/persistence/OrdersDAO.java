package org.csu.wr.persistence;

import org.csu.wr.domain.Orders;

import java.util.ArrayList;
import java.util.List;

public interface OrdersDAO {
    ArrayList<Orders> getOrdersByUsername(String username);//查询所有订单
    Orders getOrder(int orderId);
    void insertOrder(Orders order);
    void insertOrderStatus(Orders order);
}
