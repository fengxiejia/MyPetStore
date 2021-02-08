package org.csu.wr.web.servlets;

import org.csu.wr.domain.Account;
import org.csu.wr.service.LogService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by songtie on 2015/4/21.
 */
public class MainServlet extends javax.servlet.http.HttpServlet {

    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account)session.getAttribute("user");

        if(account != null) {
            HttpServletRequest httpRequest = request;
            String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                    + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

            LogService logService = new LogService();
//最后加入的信息“XXXXX”应当为该界面的信息以及一些商品信息
            String logInfo = logService.logInfo(" ") + strBackUrl + " 返回主界面";
            logService.insertLogInfo(account.getUsername(), logInfo);
        }
        request.getRequestDispatcher(MAIN).forward(request,response);
    }
}
