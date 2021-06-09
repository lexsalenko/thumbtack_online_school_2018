package net.thumbtack.school.concert.dto.request;

public class LoginsConnoisseursCommentUUIDDtoRequest {

    private String songUUIDString;
    private String commentUUIDString;

    public LoginsConnoisseursCommentUUIDDtoRequest(String songUUIDString, String commentUUIDString) {
        this.songUUIDString = songUUIDString;
        this.commentUUIDString = commentUUIDString;
    }

    public String getSongUUIDString() {
        return songUUIDString;
    }

    public void setSongUUIDString(String songUUIDString) {
        this.songUUIDString = songUUIDString;
    }

    public String getCommentUUIDString() {
        return commentUUIDString;
    }

    public void setCommentUUIDString(String commentUUIDString) {
        this.commentUUIDString = commentUUIDString;
    }
}
