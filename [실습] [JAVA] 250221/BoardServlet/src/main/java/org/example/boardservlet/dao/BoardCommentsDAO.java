package org.example.boardservlet.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.boardservlet.vo.CommentVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardCommentsDAO {
    private SqlSession sqlSession;
    public BoardCommentsDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<CommentVO> getCommentList(int boardId) {
        List<CommentVO> comments = null;
        try {
            comments = sqlSession.selectList("example.BoardServlet.Board.getCommentList", boardId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    public void insertComment(int boardId, String userId, String content) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("boardId", boardId);
            params.put("userId", userId);
            params.put("content", content);
            sqlSession.insert("example.BoardServlet.Board.insertComment", params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteComment(int commentId) {
        try {
            sqlSession.delete("example.BoardServlet.Board.deleteComment", commentId);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}