package org.example.boardservlet.controller;

import org.example.boardservlet.service.UserService;
import org.example.boardservlet.vo.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/login")
public class UserServlet extends HttpServlet {
    public UserServlet() {}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        UserService userService = new UserService();
        UserVO user = userService.getUser(id, password);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("loginsuccess.jsp");
        } else {
            resp.sendRedirect("loginfail.jsp");
        }
    }
}
