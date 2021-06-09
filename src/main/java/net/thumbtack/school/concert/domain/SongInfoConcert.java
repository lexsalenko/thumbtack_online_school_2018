package net.thumbtack.school.concert.domain;

import java.util.List;
import java.util.Objects;

public class SongInfoConcert {

    private String songName;
    private String composer;
    private String wordWriter;
    private String singer;
    private String firstName;
    private String lastName;
    private String login;
    private Double averageRatingSongs;
    private List<Comment> commentList;

    public SongInfoConcert(String songName, String composer, String wordWriter, String singer, String firstName, String lastName, String login, Double averageRatingSongs, List<Comment> commentList) {
        this.songName = songName;
        this.composer = composer;
        this.wordWriter = wordWriter;
        this.singer = singer;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.averageRatingSongs = averageRatingSongs;
        this.commentList = commentList;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getWordWriter() {
        return wordWriter;
    }

    public void setWordWriter(String wordWriter) {
        this.wordWriter = wordWriter;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Double getAverageRatingSongs() {
        return averageRatingSongs;
    }

    public void setAverageRatingSongs(Double averageRatingSongs) {
        this.averageRatingSongs = averageRatingSongs;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongInfoConcert that = (SongInfoConcert) o;
        return Objects.equals(songName, that.songName) &&
                Objects.equals(composer, that.composer) &&
                Objects.equals(wordWriter, that.wordWriter) &&
                Objects.equals(singer, that.singer) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(login, that.login) &&
                Objects.equals(averageRatingSongs, that.averageRatingSongs) &&
                Objects.equals(commentList, that.commentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songName, composer, wordWriter, singer, firstName, lastName, login, averageRatingSongs, commentList);
    }

}
