package org.csu.wr.web.servlets;

import org.csu.wr.domain.Account;
import org.csu.wr.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOutServlet extends HttpServlet {
	private static final String URL_MAIN = "/WEB-INF/jsp/catalog/Main.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		HttpSession session = req.getSession();
		Account account = (Account)session.getAttribute("user");

		if(account != null) {
			HttpServletRequest httpRequest = req;
			String strBackUrl = "http://" + req.getServerName() + ":" + req.getServerPort()
					+ httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

			LogService logService = new LogService();
//最后加入的信息“XXXXX”应当为该界面的信息以及一些商品信息
			String logInfo = logService.logInfo(" ") + strBackUrl + " 登出";
			logService.insertLogInfo(account.getUsername(), logInfo);
		}
		req.getRequestDispatcher(URL_MAIN).forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
