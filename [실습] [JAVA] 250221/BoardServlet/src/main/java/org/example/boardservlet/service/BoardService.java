package org.example.boardservlet.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.boardservlet.dao.BoardDAO;
import org.example.boardservlet.mybatis.MyBatisSessionFactory;
import org.example.boardservlet.vo.BoardInsertVO;
import org.example.boardservlet.vo.BoardVO;

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
    public void insertBoard(BoardInsertVO boardInsertVO) {
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        try {
            BoardDAO boardDAO = new BoardDAO(sqlSession);
            boardDAO.insertBoard(boardInsertVO);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
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
    public List<BoardVO> getBoardByKeyword(String keyword) {
        List<BoardVO> boardList = null;
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        try {
            BoardDAO boardDAO = new BoardDAO(sqlSession);
            boardList = boardDAO.selectBoardByKeyword(keyword);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return boardList;
    }
    public void updateBoard(int boardId, String title, String content) {
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        try {
            BoardDAO boardDAO = new BoardDAO(sqlSession);
            boardDAO.updateBoard(boardId, title, content);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
    public void deleteBoard(int boardId) {
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        try {
            BoardDAO boardDAO = new BoardDAO(sqlSession);
            boardDAO.deleteBoard(boardId);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
    public void updateBoardViews(int boardId) {
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        try {
            BoardDAO boardDAO = new BoardDAO(sqlSession);
            boardDAO.updateBoardViews(boardId);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
