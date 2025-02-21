package org.example.boardservlet.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.boardservlet.vo.BoardInsertVO;
import org.example.boardservlet.vo.BoardVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardDAO {
    private SqlSession sqlSession;
    public BoardDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    public List<BoardVO> selectAllBoard() {
        List<BoardVO> list = null;
        try {
            list = sqlSession.selectList("example.BoardServlet.Board.selectAllBoard");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public void insertBoard(BoardInsertVO board) {
        try {
            sqlSession.insert("example.BoardServlet.Board.insertBoard", board);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public BoardVO getBoardById(int id) {
        BoardVO board = null;
        try {
            board = sqlSession.selectOne("example.BoardServlet.Board.selectBoardById", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return board;
    }
    public void updateBoard(int boardId, String title, String content) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("boardId", boardId);
            params.put("title", title);
            params.put("content", content);
            sqlSession.update("example.BoardServlet.Board.updateBoard", params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void deleteBoard(int boardId) {
        try {
            sqlSession.delete("example.BoardServlet.Board.deleteBoard", boardId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<BoardVO> selectBoardByKeyword(String keyword) {
        List<BoardVO> list = null;
        try {
            list = sqlSession.selectList("example.BoardServlet.Board.selectBoardByKeyword", keyword);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateBoardViews(int boardId) {
        try {
            sqlSession.update("example.BoardServlet.Board.updateBoardViews", boardId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
