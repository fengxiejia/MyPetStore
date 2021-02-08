package org.csu.wr.web.servlets;

import org.csu.wr.domain.Account;
import org.csu.wr.service.ChangeInformation;
import org.csu.wr.service.LogService;
import org.csu.wr.service.loginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class InformationChangeServlet extends HttpServlet {
    public static final String URL_BACK = "/WEB-INF/jsp/account/MyAccount.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username =(String) req.getSession().getAttribute("username");
        String password = req.getParameter("password");;
        String repassword = req.getParameter("repeatedPassword");
        String value1=req.getParameter("vCode");
        String value2=(String)req.getSession().getAttribute("checkcode");
        Boolean isSame = false;
        if(value2.equalsIgnoreCase(value1)){
            isSame = true;
        }
        if(req.getParameter("password")!="") {
            if(!password.equals(repassword))
            {
                req.setAttribute("message","两次密码不一致");
                req.getRequestDispatcher(URL_BACK).forward(req,resp);
            }
            else if (!isSame)
            {
                req.setAttribute("message","验证码错误");
                req.getRequestDispatcher(URL_BACK).forward(req,resp);
            }
            else
            {
                password = req.getParameter("password");
            }

        }
        else
        {
            password = (String)req.getSession().getAttribute("password");
        }

        String firstname = req.getParameter("account.firstName");
        String lastname = req.getParameter("account.lastName");
        String email = req.getParameter("account.email");
        String phone = req.getParameter("account.phone");
        String address1 = req.getParameter("account.address1");
        String address2 = req.getParameter("account.address2");
        String city = req.getParameter("account.city");
        String state = req.getParameter("account.state");
        String zip = req.getParameter("account.zip");
        String country = req.getParameter("account.country");
        ChangeInformation changeInformation = new ChangeInformation();
        changeInformation.change_Account(username,password,email,firstname,lastname,address1,address2,city,state,zip,country,phone);
        loginService login = new loginService();
        Account account = login.existAccount(username,password);
        req.getSession().setAttribute("user",account);
        req.getSession().setAttribute("password",password);
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
        if(account != null) {
            HttpServletRequest httpRequest = req;
            String strBackUrl = "http://" + req.getServerName() + ":" + req.getServerPort()
                    + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

            LogService logService = new LogService();
//最后加入的信息“XXXXX”应当为该界面的信息以及一些商品信息
            String logInfo = logService.logInfo(" ") + strBackUrl + " 修改账户信息";
            logService.insertLogInfo(account.getUsername(), logInfo);
        }
        req.getRequestDispatcher(URL_BACK).forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
