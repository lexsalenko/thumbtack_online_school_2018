package net.thumbtack.school.concert.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Song {

    private String songName;
    private String composer;
    private String wordWriter;
    private String singer;
    private int lengthSong;
    private Map<String, Comment> commentMap; // Map<commentUUIDString, Comment>

    public Song(String songName, String composer, String wordWriter, String singer, int lengthSong) {
        this.songName = songName;
        this.composer = composer;
        this.wordWriter = wordWriter;
        this.singer = singer;
        this.lengthSong = lengthSong;
        this.commentMap = new HashMap<>();
    }

    public String getSongName() {
        return songName;
    }

    public String getComposer() {
        return composer;
    }

    public String getWordWriter() {
        return wordWriter;
    }

    public String getSinger() {
        return singer;
    }

    public int getLengthSong() {
        return lengthSong;
    }

    public Map<String, Comment> getCommentMap() {
        return commentMap;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public void setWordWriter(String wordWriter) {
        this.wordWriter = wordWriter;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setLengthSong(int lengthSong) {
        this.lengthSong = lengthSong;
    }

    public void setCommentMap(Map<String, Comment> commentMap) {
        this.commentMap = commentMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return lengthSong == song.lengthSong &&
                Objects.equals(songName, song.songName) &&
                Objects.equals(composer, song.composer) &&
                Objects.equals(wordWriter, song.wordWriter) &&
                Objects.equals(singer, song.singer) &&
                Objects.equals(commentMap, song.commentMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songName, composer, wordWriter, singer, lengthSong, commentMap);
    }

}
