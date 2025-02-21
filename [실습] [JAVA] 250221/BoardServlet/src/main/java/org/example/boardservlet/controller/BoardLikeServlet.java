package org.example.boardservlet.controller;

import org.example.boardservlet.service.BoardLikeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/board/like")
public class BoardLikeServlet extends HttpServlet {
    public BoardLikeServlet() {}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int boardId = Integer.parseInt(req.getParameter("boardId"));
        String userId = req.getParameter("userId");
        BoardLikeService boardLikeService = new BoardLikeService();
        boolean isLiked =  boardLikeService.selectLikeById(boardId, userId);
        resp.setContentType("application/json");
        resp.getWriter().write("{\"isLiked\": " + isLiked + "}");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int boardId = Integer.parseInt(req.getParameter("boardId"));
        String userId = req.getParameter("userId");
        BoardLikeService boardLikeService = new BoardLikeService();
        boolean isLiked =  boardLikeService.selectLikeById(boardId, userId);
        if (isLiked) {
            boardLikeService.deleteLike(boardId, userId);
        } else {
            boardLikeService.insertLike(boardId, userId);
        }
        resp.setContentType("application/json");
        resp.getWriter().write("{\"isLiked\": " + !isLiked + "}");
    }
}
