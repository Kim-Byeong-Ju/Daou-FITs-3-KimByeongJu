package org.example.boardservlet.vo;

public class BoardInsertVO {
    private String title;
    private String content;
    private String userId;

    public BoardInsertVO() {}
    public BoardInsertVO(String title, String content, String userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }


    public String getTitle() {
        return title;
    }
    public String getUserId() {
        return userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
