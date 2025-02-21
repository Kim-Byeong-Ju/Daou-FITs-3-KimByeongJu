package org.example.boardservlet.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.boardservlet.vo.UserVO;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    private SqlSession sqlSession;
    public UserDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    public UserVO selectUser(String id, String password) {
        UserVO user = null;
        try {
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("id", id);
            paramMap.put("password", password);
            user = sqlSession.selectOne("example.BoardServlet.User.selectUser", paramMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}
