package org.example.boardservlet.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.boardservlet.dao.BoardCommentsDAO;
import org.example.boardservlet.mybatis.MyBatisSessionFactory;
import org.example.boardservlet.vo.CommentVO;

import java.util.ArrayList;
import java.util.List;

public class BoardCommentService {
    public BoardCommentService() {}

    public List<CommentVO> getCommentList(int board_id) {
        List<CommentVO> comments = null;
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        try {
            BoardCommentsDAO boardCommentsDAO = new BoardCommentsDAO(sqlSession);
            comments = boardCommentsDAO.getCommentList(board_id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return comments;
    }

    public void insertComment(int boardId, String userId, String content) {
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        try {
            BoardCommentsDAO boardCommentsDAO = new BoardCommentsDAO(sqlSession);
            boardCommentsDAO.insertComment(boardId, userId, content);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteComment(int comment_id) {
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        try {
            BoardCommentsDAO boardCommentsDAO = new BoardCommentsDAO(sqlSession);
            boardCommentsDAO.deleteComment(comment_id);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
