package org.example.servletsearchbook.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.servletsearchbook.vo.BookVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDAO {

    private SqlSession sqlSession;
    public BookDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    public List<BookVO> selectByKeywordPrice(String keyword, int price) {
        List<BookVO> list = null;
        try {
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("keyword", keyword);
            paramMap.put("price", price);
            list = sqlSession.selectList("example.servletsearchbook.MyBook.selectByKeywordPrice", paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public BookVO selectByIsbn(String bisbn) {
        BookVO book = null;
        try {
            book = sqlSession.selectOne("example.servletsearchbook.MyBook.selectByIsbn", bisbn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    return book;
    }
}
