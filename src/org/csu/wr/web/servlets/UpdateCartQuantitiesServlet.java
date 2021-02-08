package org.csu.wr.web.servlets;

import org.csu.wr.domain.Account;
import org.csu.wr.domain.Cart;
import org.csu.wr.domain.CartItem;
import org.csu.wr.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by songtie on 2015/4/27.
 */
public class UpdateCartQuantitiesServlet extends HttpServlet {

    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    private Cart cart;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        cart = (Cart) session.getAttribute("cart");

        Iterator<CartItem> cartItems = cart.getAllCartItems();
        while (cartItems.hasNext()) {
            CartItem cartItem = cartItems.next();
            String itemId = cartItem.getItem().getItemId();
            try {
                int quantity = Integer.parseInt(request.getParameter(itemId));
                cart.setQuantityByItemId(itemId, quantity);
                if (quantity < 1) {
                    cartItems.remove();
                }
            } catch (Exception e) {
                session.setAttribute("message", "The Quantities of Item must be Integer!");
                Account account = (Account)session.getAttribute("user");

                if(account != null) {
                    HttpServletRequest httpRequest = request;
                    String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                            + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

                    LogService logService = new LogService();
//最后加入的信息“XXXXX”应当为该界面的信息以及一些商品信息
                    String logInfo = logService.logInfo(" ") + strBackUrl + " XXXXX";
                    logService.insertLogInfo(account.getUsername(), logInfo);
                }
                request.getRequestDispatcher(ERROR).forward(request, response);
            }
        }
        Account account = (Account)session.getAttribute("user");

        if(account != null) {
            HttpServletRequest httpRequest = request;
            String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                    + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

            LogService logService = new LogService();
//最后加入的信息“XXXXX”应当为该界面的信息以及一些商品信息
            String logInfo = logService.logInfo(" ") + strBackUrl + " 更新购物车价格";
            logService.insertLogInfo(account.getUsername(), logInfo);
        }
        request.getRequestDispatcher(VIEW_CART).forward(request, response);
    }
}
