package net.thumbtack.school.concert.dto.response;

public class AddCommentSongDtoResponse {

    private String commentUUIDString;

    public AddCommentSongDtoResponse(String commentUUIDString) {
        this.commentUUIDString = commentUUIDString;
    }

    public String getCommentUUIDString() {
        return commentUUIDString;
    }

    public void setCommentUUIDString(String commentUUIDString) {
        this.commentUUIDString = commentUUIDString;
    }
}
