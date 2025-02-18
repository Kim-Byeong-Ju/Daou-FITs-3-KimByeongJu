package org.example.servletloginboard.controller;

import org.example.servletloginboard.service.BoardService;
import org.example.servletloginboard.vo.BoardVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/board")
public class BoardServlet extends HttpServlet {
    public BoardServlet() {}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BoardService boardService = new BoardService();
        List<BoardVO> list = new ArrayList<>();
        list = boardService.getBoardList();
        req.setAttribute("boardList", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("board.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String userId = req.getParameter("userId");
        BoardService boardService = new BoardService();
        boardService.insertBoard(new BoardVO(0, title, content, userId)); // ID는 자동 증가
        resp.sendRedirect("board");
    }
}