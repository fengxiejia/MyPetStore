package org.csu.wr.web.servlets;

import org.csu.wr.domain.Account;
import org.csu.wr.domain.Category;
import org.csu.wr.domain.Product;
import org.csu.wr.service.CatalogService;
import org.csu.wr.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by songtie on 2015/4/21.
 */
public class ViewCategoryServlet extends HttpServlet {

    private static final String VIEW_CATEGORY = "/WEB-INF/jsp/catalog/Category.jsp";

    private String categoryId;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        categoryId = request.getParameter("categoryId");
        CatalogService service = new CatalogService();
        Category category = service.getCategory(categoryId);
        List<Product> productList = service.getProductListByCategory(categoryId);

        HttpSession session = request.getSession();
        session.setAttribute("category" , category);
        session.setAttribute("productList" , productList);
        Account account = (Account)session.getAttribute("user");

        if(account != null) {
            HttpServletRequest httpRequest = request;
            String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                    + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

            LogService logService = new LogService();
//最后加入的信息“XXXXX”应当为该界面的信息以及一些商品信息
            String logInfo = logService.logInfo(" ") + strBackUrl + " 查看目录";
            logService.insertLogInfo(account.getUsername(), logInfo);
        }
        request.getRequestDispatcher(VIEW_CATEGORY).forward(request,response);
    }
}
