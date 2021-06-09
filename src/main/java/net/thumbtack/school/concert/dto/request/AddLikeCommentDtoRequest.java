package net.thumbtack.school.concert.dto.request;

public class AddLikeCommentDtoRequest {

    private String songUUIDString;
    private String commentUUIDString;
    private String loginAuthorLike;

    public AddLikeCommentDtoRequest(String songUUIDString, String commentUUIDString, String loginAuthorLike) {
        this.songUUIDString = songUUIDString;
        this.commentUUIDString = commentUUIDString;
        this.loginAuthorLike = loginAuthorLike;
    }

    public void setSongUUIDString(String songUUIDString) {
        this.songUUIDString = songUUIDString;
    }

    public void setCommentUUIDString(String commentUUIDString) {
        this.commentUUIDString = commentUUIDString;
    }

    public void setLoginAuthorLike(String loginAuthorLike) {
        this.loginAuthorLike = loginAuthorLike;
    }

    public String getSongUUIDString() {
        return songUUIDString;
    }

    public String getCommentUUIDString() {
        return commentUUIDString;
    }

    public String getLoginAuthorLike() {
        return loginAuthorLike;
    }
}
