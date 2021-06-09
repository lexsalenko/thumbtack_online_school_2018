package net.thumbtack.school.concert.dto.request;

import net.thumbtack.school.concert.domain.Comment;

public class ChangeCommentDtoRequest {

    private String songUUIDString;
    private String oldCommentUUIDString;
    private String newCommentUUIDString;
    private Comment newComment;

    public ChangeCommentDtoRequest(String songUUIDString, String oldCommentUUIDString, Comment newComment) {
        this.songUUIDString = songUUIDString;
        this.oldCommentUUIDString = oldCommentUUIDString;
        this.newComment = newComment;
    }

    public void setSongUUIDString(String songUUIDString) {
        this.songUUIDString = songUUIDString;
    }

    public void setOldCommentUUIDString(String oldCommentUUIDString) {
        this.oldCommentUUIDString = oldCommentUUIDString;
    }

    public void setNewCommentUUIDString(String newCommentUUIDString) {
        this.newCommentUUIDString = newCommentUUIDString;
    }

    public void setNewComment(Comment newComment) {
        this.newComment = newComment;
    }

    public String getSongUUIDString() {
        return songUUIDString;
    }

    public String getOldCommentUUIDString() {
        return oldCommentUUIDString;
    }

    public String getNewCommentUUIDString() {
        return newCommentUUIDString;
    }

    public Comment getNewComment() {
        return newComment;
    }
}
