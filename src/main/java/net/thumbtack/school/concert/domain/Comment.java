package net.thumbtack.school.concert.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Comment {

    private String comment;
    private String commentAuthorLogin;
    private List<String> joinedComments; //  List<loginAuthorLike>

    public Comment(String comment, String commentAuthorLogin) {
        this.comment = comment;
        this.commentAuthorLogin = commentAuthorLogin;
        this.joinedComments = new ArrayList<>();
    }

    public Comment(String comment, String commentAuthorLogin, List<String> joinedComments) {
        this.comment = comment;
        this.commentAuthorLogin = commentAuthorLogin;
        this.joinedComments = joinedComments;
    }

    public String getComment() {
        return comment;
    }

    public String getCommentAuthorLogin() {
        return commentAuthorLogin;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCommentAuthorLogin(String commentAuthorLogin) {
        this.commentAuthorLogin = commentAuthorLogin;
    }

    public List<String> getJoinedComments() {
        return joinedComments;
    }

    public void setJoinedComments(List<String> joinedComments) {
        this.joinedComments = joinedComments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return Objects.equals(comment, comment1.comment) &&
                Objects.equals(commentAuthorLogin, comment1.commentAuthorLogin) &&
                Objects.equals(joinedComments, comment1.joinedComments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment, commentAuthorLogin, joinedComments);
    }

}
