package net.thumbtack.school.concert.dto.request;

import net.thumbtack.school.concert.domain.Comment;

public class AddCommentSongDtoRequest {

    private String songUUIDString;
    private Comment comment;

    public AddCommentSongDtoRequest(String songUUIDString, Comment comment) {
        this.songUUIDString = songUUIDString;
        this.comment = comment;
    }

    public void setSongUUIDString(String songUUIDString) {
        this.songUUIDString = songUUIDString;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getSongUUIDString() {
        return songUUIDString;
    }

    public Comment getComment() {
        return comment;
    }
}
