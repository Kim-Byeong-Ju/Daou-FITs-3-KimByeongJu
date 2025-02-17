package org.example.servletsearchbook.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.servletsearchbook.dao.BookDAO;
import org.example.servletsearchbook.mybatis.MyBatisSessionFactory;
import org.example.servletsearchbook.vo.BookVO;

import java.util.List;

public class BookService {

    // Database 처리는 DAO를 이용
    // Transaction 처리 때문에 DAO에는 SqlSession 갹체를 injection 해서 처리해야 함
    public List<BookVO> getBooks(String keyword, int price) {
    SqlSessionFactory sqlSessionFactory = MyBatisSessionFactory.getSqlSessionFactory();
    SqlSession sqlSession = sqlSessionFactory.openSession();
    List<BookVO> bookList = null;
    try {
        BookDAO dao = new BookDAO(sqlSession);
        bookList = dao.selectByKeywordPrice(keyword, price);
    } catch(Exception e) {
        e.printStackTrace();
    } finally {
        sqlSession.close();
        }
    return bookList;
    }

    public BookVO getBook(String bisbn) {
        SqlSessionFactory sqlSessionFactory = MyBatisSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookVO book = null;
        try {
            BookDAO dao = new BookDAO(sqlSession);
            book = dao.selectByIsbn(bisbn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return book;
    }
}
