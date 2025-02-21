package org.example.boardservlet.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.boardservlet.dao.BoardLikeDAO;
import org.example.boardservlet.mybatis.MyBatisSessionFactory;

public class BoardLikeService {
    public BoardLikeService() {}
    public boolean selectLikeById(int boardId, String userId) {
        boolean isLiked = false;
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        try {
            BoardLikeDAO boardLikeDAO = new BoardLikeDAO(sqlSession);
            String user = boardLikeDAO.selectLikeById(boardId, userId);
            if (user != null) {
                isLiked = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return isLiked;
    }

    public void insertLike(int boardId, String userId) {
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        System.out.println("insert!!");
        try {
            BoardLikeDAO boardLikeDAO = new BoardLikeDAO(sqlSession);
            boardLikeDAO.insertLike(boardId, userId);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
    public void deleteLike(int boardId, String userId) {
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        System.out.println("delete!!");
        try {
            BoardLikeDAO boardLikeDAO = new BoardLikeDAO(sqlSession);
            boardLikeDAO.deleteLike(boardId, userId);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
