package org.example.servletloginboard.vo;

public class BoardVO {
    private int boardId;
    private String title;
    private String content;
    private String userId;

    public BoardVO() {}

    public BoardVO(int boardId, String title, String content, String userId) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getTitle() {
        return title;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
