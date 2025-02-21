package org.example.boardservlet.vo;

public class UserVO {
    private String userId;
    private String name;
    private String password;

    public UserVO() {
    }

    public UserVO(String id, String name, String password) {
        this.userId = id;
        this.name = name;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String id) {
        this.userId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
