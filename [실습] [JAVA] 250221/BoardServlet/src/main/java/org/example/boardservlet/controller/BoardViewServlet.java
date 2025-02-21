package org.example.boardservlet.controller;

import org.example.boardservlet.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/board/views")
public class BoardViewServlet extends HttpServlet {
    public BoardViewServlet() {}

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int boardId = Integer.parseInt(req.getParameter("boardId"));
        BoardService boardService = new BoardService();
        boardService.updateBoardViews(boardId);
    }
}
