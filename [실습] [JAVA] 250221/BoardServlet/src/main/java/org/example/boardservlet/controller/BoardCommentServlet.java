package org.example.boardservlet.controller;

import org.example.boardservlet.service.BoardCommentService;
import org.example.boardservlet.vo.CommentVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/board/comment")
public class BoardCommentServlet extends HttpServlet {
    public BoardCommentServlet() {}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int boardId = Integer.parseInt(req.getParameter("boardId"));
        BoardCommentService boardCommentService = new BoardCommentService();
        List<CommentVO> commentList = boardCommentService.getCommentList(boardId);

        // JSON 문자열 직접 생성
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\"commentList\":[");
        for (int i = 0; i < commentList.size(); i++) {
            CommentVO comment = commentList.get(i);
            jsonBuilder.append("{")
                    .append("\"commentId\":").append(comment.getCommentId()).append(",")
                    .append("\"boardId\":").append(comment.getBoardId()).append(",")
                    .append("\"userId\":").append("\"").append(comment.getUserId()).append("\",")
                    .append("\"content\":").append("\"").append(comment.getContent()).append("\"")
                    .append("}");

            if (i < commentList.size() - 1) {
                jsonBuilder.append(",");
            }
        }
        jsonBuilder.append("]}");
        // 응답 설정
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonBuilder.toString());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int boardId = Integer.parseInt(req.getParameter("boardId"));
        String userId = req.getParameter("userId");
        String content = req.getParameter("content");
        BoardCommentService boardCommentService = new BoardCommentService();
        boardCommentService.insertComment(boardId, userId, content);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int commentId = Integer.parseInt(req.getParameter("commentId"));
        BoardCommentService boardCommentService = new BoardCommentService();
        boardCommentService.deleteComment(commentId);
    }
}