package org.example.boardservlet.controller;

import org.example.boardservlet.service.BoardService;
import org.example.boardservlet.vo.BoardInsertVO;
import org.example.boardservlet.vo.BoardVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/board")
public class BoardServlet extends HttpServlet {
    public BoardServlet() {}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BoardService boardService = new BoardService();
        List<BoardVO> list;
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
        boardService.insertBoard(new BoardInsertVO(title, content, userId)); // ID는 자동 증가
        resp.sendRedirect("board");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int boardId = Integer.parseInt(req.getParameter("boardId"));
        BoardService boardService = new BoardService();
        System.out.println("delete board id: " + boardId);
        boardService.deleteBoard(boardId);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("{\"message\": \"success\"}");  // JSON 응답
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 쿼리스트링에서 파라미터 읽기
        int boardId = Integer.parseInt(req.getParameter("boardId"));
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        // 서비스 호출하여 게시글 수정
        BoardService boardService = new BoardService();
        boardService.updateBoard(boardId, title, content);
        // 성공 응답
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}