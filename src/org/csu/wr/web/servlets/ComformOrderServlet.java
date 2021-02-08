package org.csu.wr.web.servlets;

import org.csu.wr.domain.Account;
import org.csu.wr.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ComformOrderServlet extends HttpServlet
{
	public static final String COMFIRM_ORDER_URL = "/WEB-INF/jsp/Order/ConfirmOrder.jsp";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().setAttribute("cardtype",req.getParameter("order.cardType"));
		req.getSession().setAttribute("cardnum",req.getParameter("order.creditCard"));
		req.getSession().setAttribute("date",req.getParameter("order.expiryDate"));
		req.getSession().setAttribute("bfirstname",req.getParameter("order.billToFirstName"));
		req.getSession().setAttribute("blastname",req.getParameter("order.billToLastName"));
		req.getSession().setAttribute("baddr1",req.getParameter("order.billAddress1"));
		req.getSession().setAttribute("baddr2",req.getParameter("order.billAddress2"));
		req.getSession().setAttribute("bcity",req.getParameter("order.billCity"));
		req.getSession().setAttribute("bstate",req.getParameter("order.billState"));
		req.getSession().setAttribute("bzip",req.getParameter("order.billZip"));
		req.getSession().setAttribute("bcountry",req.getParameter("order.billCountry"));
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
		req.getRequestDispatcher(COMFIRM_ORDER_URL).forward(req,resp);
	}
}