package org.csu.wr.web.servlets;

import org.csu.wr.domain.Account;
import org.csu.wr.persistence.DBUtil;
import org.csu.wr.service.loginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class LoginServlet extends HttpServlet {
	public static final String URL_RETURN = "/WEB-INF/jsp/catalog/Main.jsp";
	public static final String URL_BACK = "/WEB-INF/jsp/account/log_in.jsp";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String value1=req.getParameter("vCode");
			/*获取图片的值*/
			String value2=(String)req.getSession().getAttribute("checkcode");
			Boolean isSame = false;
			/*对比两个值（字母不区分大小写）*/
			if(value2.equalsIgnoreCase(value1)){
				isSame = true;
			}
			loginService login = new loginService();
			Account account = login.existAccount(req.getParameter("username"),req.getParameter("password"));
			if (req.getParameter("username") == "")
			{
				req.setAttribute("message","请输入账号");
				req.getRequestDispatcher(URL_BACK).forward(req,resp);
			}
			else if(req.getParameter("password") == "")
			{
				req.setAttribute("message","请输入密码");
				req.getRequestDispatcher(URL_BACK).forward(req,resp);
			}
			else if(!isSame){
				req.setAttribute("message","验证码错误");
				req.getRequestDispatcher(URL_BACK).forward(req,resp);
			}
			else if(account != null)
			{
				req.getSession().setAttribute("user",account);
				req.getSession().setAttribute("password",req.getParameter("password"));
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
				req.getRequestDispatcher(URL_RETURN).forward(req,resp);

			}
			else
			{
				req.setAttribute("message","账号不存在");
				req.getRequestDispatcher(URL_BACK).forward(req,resp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
