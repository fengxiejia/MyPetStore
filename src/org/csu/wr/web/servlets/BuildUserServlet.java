package org.csu.wr.web.servlets;

import org.csu.wr.domain.Account;
import org.csu.wr.service.BuildAccount;
import org.csu.wr.service.LogService;
import org.csu.wr.service.loginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BuildUserServlet extends HttpServlet {
	private static final String Main_URL = "/WEB-INF/jsp/catalog/Main.jsp";
	private static final String Back_URL = "/WEB-INF/jsp/account/write_account_information.jsp";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = (String) req.getSession().getAttribute("username");
		String password = (String) req.getSession().getAttribute("password");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String address1 = req.getParameter("address1");
		String address2 = req.getParameter("address2");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		String zip = req.getParameter("zip");
		String country = req.getParameter("country");
		BuildAccount buildAccount = new BuildAccount();
		buildAccount.bulid_Account(username,password,email,firstName,lastName,address1,address2,city,state,zip,country,phone);
		Account account = new Account(username,email,firstName,lastName,"ok",address1,address2,city,state,zip,country,phone);
		req.getSession().setAttribute("user",account);
		req.getSession().setAttribute("username",account.getUsername());
		req.getSession().setAttribute("Firstname",account.getFirstName());
		req.getSession().setAttribute("Lastname",account.getLastName());
		req.getSession().setAttribute("email",account.getEmail());
		req.getSession().setAttribute("phone",account.getPhone());
		req.getSession().setAttribute("Address1",account.getAddress1());
		req.getSession().setAttribute("Address2",account.getAddress2());
		req.getSession().setAttribute("city",account.getCity());
		req.getSession().setAttribute("state",account.getState());
		req.getSession().setAttribute("zip",account.getZip());
		req.getSession().setAttribute("country",account.getCountry());
		HttpSession session = req.getSession();
		if(account != null) {
			HttpServletRequest httpRequest = req;
			String strBackUrl = "http://" + req.getServerName() + ":" + req.getServerPort()
					+ httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

			LogService logService = new LogService();
//最后加入的信息“XXXXX”应当为该界面的信息以及一些商品信息
			String logInfo = logService.logInfo(" ") + strBackUrl + " 创建账户";
			logService.insertLogInfo(account.getUsername(), logInfo);
		}

		req.getRequestDispatcher(Main_URL).forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
