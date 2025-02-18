package org.example.servletloginboard.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.servletloginboard.dao.BoardDAO;
import org.example.servletloginboard.mybatis.MyBatisSessionFactory;
import org.example.servletloginboard.vo.BoardVO;

import java.util.List;

public class BoardService {
    public BoardService() {}

    public List<BoardVO> getBoardList() {
        List<BoardVO> boardList = null;
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        try {
            BoardDAO boardDAO = new BoardDAO(sqlSession);
            boardList = boardDAO.selectAllBoard();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return boardList;
    }

    public void insertBoard(BoardVO boardVO) {
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        try {
            BoardDAO boardDAO = new BoardDAO(sqlSession);
            boardDAO.insertBoard(boardVO);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
    public BoardVO getBoardById(int id) {
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        BoardVO board = null;
        try {
            BoardDAO boardDAO = new BoardDAO(sqlSession);
            board = boardDAO.getBoardById(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return board;
    }

}
