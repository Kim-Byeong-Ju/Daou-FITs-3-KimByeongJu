package org.example.boardservlet.dao;

import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

public class BoardLikeDAO {
    private SqlSession sqlSession;
    public BoardLikeDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    public String selectLikeById(int boardId, String userId) {
        String user = null;
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("boardId", boardId);
            params.put("userId", userId);
            user = sqlSession.selectOne("example.BoardServlet.Board.selectLikeById", params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void insertLike(int boardId, String userId) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("boardId", boardId);
            params.put("userId", userId);
            sqlSession.insert("example.BoardServlet.Board.insertBoardLike", params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteLike(int boardId, String userId) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("boardId", boardId);
            params.put("userId", userId);
            sqlSession.delete("example.BoardServlet.Board.deleteBoardLike", params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
