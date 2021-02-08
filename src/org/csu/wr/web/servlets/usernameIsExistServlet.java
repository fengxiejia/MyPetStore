package org.csu.wr.web.servlets;

import org.csu.wr.domain.Account;
import org.csu.wr.service.loginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class usernameIsExistServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        loginService login = new loginService();
        resp.setContentType("text/xml");
        PrintWriter out = resp.getWriter();
        if(login.isUserExist(username)){
            out.println("<msg>Exist</msg>");
        }else {
            out.println("<msg>NotExist</msg>");
        }
        out.flush();
        out.close();
    }
}
