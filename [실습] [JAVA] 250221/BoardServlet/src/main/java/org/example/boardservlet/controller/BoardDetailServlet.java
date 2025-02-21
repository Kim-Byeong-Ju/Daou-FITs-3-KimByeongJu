package org.example.boardservlet.controller;

import org.example.boardservlet.service.BoardService;
import org.example.boardservlet.vo.BoardVO;
import org.example.boardservlet.vo.CommentVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/boarddetail")
public class BoardDetailServlet extends HttpServlet {
    public BoardDetailServlet() {}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int boardId = Integer.parseInt(req.getParameter("boardId"));
        BoardService boardService = new BoardService();
        BoardVO board = boardService.getBoardById(boardId);
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        // Convert each field of BoardVO to JSON format
        jsonBuilder.append("\"boardId\":").append(board.getBoardId()).append(",");
        jsonBuilder.append("\"title\":\"").append(board.getTitle()).append("\",");
        jsonBuilder.append("\"content\":\"").append(board.getContent()).append("\",");
        jsonBuilder.append("\"writer\":\"").append(board.getWriter()).append("\",");
        jsonBuilder.append("\"userId\":\"").append(board.getUserId()).append("\",");
        jsonBuilder.append("\"createdAt\":\"").append(board.getCreatedAt()).append("\",");
        jsonBuilder.append("\"commentCount\":").append(board.getCommentCount()).append(",");
        jsonBuilder.append("\"likeCount\":").append(board.getLikeCount()).append(",");
        jsonBuilder.append("\"views\":").append(board.getViews());
        // Close the JSON object
        jsonBuilder.append("}");
        // Send the response
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonBuilder.toString());
    }

}
