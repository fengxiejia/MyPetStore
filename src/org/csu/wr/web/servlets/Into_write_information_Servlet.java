package org.csu.wr.web.servlets;

import org.csu.wr.domain.Account;
import org.csu.wr.persistence.impl.SignOnDAOImpl;
import org.csu.wr.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Into_write_information_Servlet extends HttpServlet {
	public static final String WRITE_INFORMATION_URL = "/WEB-INF/jsp/account/write_account_information.jsp";
	public static final String Back_URL = "/WEB-INF/jsp/account/register.jsp";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SignOnDAOImpl signOnDAO = new SignOnDAOImpl();
		boolean b = signOnDAO.ExistUser(req.getParameter("username"));
		req.setAttribute("username",req.getParameter("username"));
		if(req.getParameter("username").equals("") || req.getParameter("password").equals("")|| req.getParameter("repeatedPassword").equals("") )
		{
			req.setAttribute("message","请确保填完信息");
			req.setAttribute("username",req.getParameter("username"));
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
			req.getRequestDispatcher(Back_URL).forward(req,resp);
		}
		else if(b)
		{
			req.setAttribute("message","用户名已被注册");
			req.setAttribute("username",null);
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
			req.getRequestDispatcher(Back_URL).forward(req,resp);
		}
		else if(!req.getParameter("password" ).equals(req.getParameter("repeatedPassword")))
		{
			req.setAttribute("message","两次密码不一致");
			req.setAttribute("username",req.getParameter("username"));
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
			req.getRequestDispatcher(Back_URL).forward(req,resp);
		}
		else
		{
			req.getSession().setAttribute("username",req.getParameter("username"));
			req.getSession().setAttribute("password",req.getParameter("password"));
			req.getRequestDispatcher(WRITE_INFORMATION_URL).forward(req,resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
