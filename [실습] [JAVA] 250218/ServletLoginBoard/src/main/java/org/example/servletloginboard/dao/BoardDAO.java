package org.example.servletloginboard.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.servletloginboard.vo.BoardVO;

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
            list = sqlSession.selectList("example.servletloginboard.Board.selectAllBoard");
            for (BoardVO board : list) {
                System.out.println("게시글 ID: " + board.getBoardId()); // 콘솔에서 확인
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public void insertBoard(BoardVO board) {
        try {
            sqlSession.insert("example.servletloginboard.Board.insertBoard", board);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public BoardVO getBoardById(int id) {
        BoardVO board = null;
        try {
            board = sqlSession.selectOne("example.servletloginboard.Board.selectBoardById", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return board;
    }
}
