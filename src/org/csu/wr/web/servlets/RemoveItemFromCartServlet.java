package org.csu.wr.web.servlets;

import org.csu.wr.domain.Account;
import org.csu.wr.domain.Cart;
import org.csu.wr.domain.Item;
import org.csu.wr.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by songtie on 2015/4/27.
 */
public class RemoveItemFromCartServlet extends HttpServlet {

    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    private String workingItemId;
    private Cart cart;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        workingItemId = request.getParameter("workingItemId");

        HttpSession session = request.getSession();
        cart = (Cart) session.getAttribute("cart");

        Item item = cart.removeItemById(workingItemId);

        if (item == null) {
            session.setAttribute("message", "Attempted to remove null CartItem from Cart.");
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
        } else {
            Account account = (Account)session.getAttribute("user");

            if(account != null) {
                HttpServletRequest httpRequest = request;
                String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                        + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

                LogService logService = new LogService();
//最后加入的信息“XXXXX”应当为该界面的信息以及一些商品信息
                String logInfo = logService.logInfo(" ") + strBackUrl + " 移除商品";
                logService.insertLogInfo(account.getUsername(), logInfo);
            }
            request.getRequestDispatcher(VIEW_CART).forward(request, response);
        }
    }
}
