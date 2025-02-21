package org.example.boardservlet.controller;

import org.example.boardservlet.service.BoardService;
import org.example.boardservlet.vo.BoardVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/keyword")
public class SearchKeywordServlet extends HttpServlet {
    public SearchKeywordServlet() {}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String keyword = req.getParameter("keyword");
        BoardService boardService = new BoardService();
        List<BoardVO> list;
        list = boardService.getBoardByKeyword(keyword);
        req.setAttribute("boardList", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("board.jsp");
        dispatcher.forward(req, resp);
    }
}
