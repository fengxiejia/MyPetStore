package org.csu.wr.web.servlets;

import org.csu.wr.domain.Account;
import org.csu.wr.domain.Item;
import org.csu.wr.service.CatalogService;
import org.csu.wr.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by songtie on 2015/4/21.
 */
public class ViewItemServlet extends HttpServlet {
    private static final String VIEW_ITEM = "/WEB-INF/jsp/catalog/Item.jsp";
    private String itemId;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        itemId = request.getParameter("itemId");
        CatalogService service = new CatalogService();
        Item item = service.getItem(itemId);
        HttpSession session = request.getSession();
        session.setAttribute("item",item);
        Account account = (Account)session.getAttribute("user");

        if(account != null) {
            HttpServletRequest httpRequest = request;
            String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                    + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

            LogService logService = new LogService();
//最后加入的信息“XXXXX”应当为该界面的信息以及一些商品信息
            String logInfo = logService.logInfo(" ") + strBackUrl + " 查看物品";
            logService.insertLogInfo(account.getUsername(), logInfo);
        }
        request.getRequestDispatcher(VIEW_ITEM).forward(request,response);
    }
}
