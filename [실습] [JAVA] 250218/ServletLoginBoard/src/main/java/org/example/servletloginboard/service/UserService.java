package org.example.servletloginboard.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.servletloginboard.dao.UserDAO;
import org.example.servletloginboard.mybatis.MyBatisSessionFactory;
import org.example.servletloginboard.vo.UserVO;

public class UserService {
    public UserService() {}

    public UserVO getUser(String id, String password) {
        UserVO user = null;
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        try {
            UserDAO userDAO = new UserDAO(sqlSession);
            user = userDAO.selectUser(id, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return user;
    }
}
