package org.csu.wr.web.servlets;

import org.csu.wr.domain.Account;
import org.csu.wr.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class IntoMyAccountServlet extends HttpServlet {
	public static final String MYACCOUNT_URL = "/WEB-INF/jsp/account/MyAccount.jsp";
	public static final String Error_URL = "/WEB-INF/jsp/common/Error.jsp";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("user") != null) {
			HttpSession session = req.getSession();
			Account account = (Account)session.getAttribute("user");

			if(account != null) {
				HttpServletRequest httpRequest = req;
				String strBackUrl = "http://" + req.getServerName() + ":" + req.getServerPort()
						+ httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

				LogService logService = new LogService();
//最后加入的信息“XXXXX”应当为该界面的信息以及一些商品信息
				String logInfo = logService.logInfo(" ") + strBackUrl + " XXXXX";
				logService.insertLogInfo(account.getUsername(), logInfo);
			}
			req.getRequestDispatcher(MYACCOUNT_URL).forward(req, resp);
		}
		else
		{
			req.setAttribute("message","请先登入");
			HttpSession session = req.getSession();
			Account account = (Account)session.getAttribute("user");

			if(account != null) {
				HttpServletRequest httpRequest = req;
				String strBackUrl = "http://" + req.getServerName() + ":" + req.getServerPort()
						+ httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

				LogService logService = new LogService();
//最后加入的信息“XXXXX”应当为该界面的信息以及一些商品信息
				String logInfo = logService.logInfo(" ") + strBackUrl + " 查看我的用户信息";
				logService.insertLogInfo(account.getUsername(), logInfo);
			}
			req.getRequestDispatcher(Error_URL).forward(req,resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
