package org.example.boardservlet.vo;

public class CommentVO {
    private int commentId;
    private int boardId;
    private String userId;
    private String content;
    public CommentVO() {}

    public CommentVO(int commentId, int boardId, String userId, String content) {
        this.commentId = commentId;
        this.boardId = boardId;
        this.userId = userId;
        this.content = content;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
