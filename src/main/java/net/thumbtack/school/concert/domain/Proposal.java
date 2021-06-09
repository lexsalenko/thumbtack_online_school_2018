package net.thumbtack.school.concert.domain;

public class Proposal {

    private String songAuthorLogin;
    private Song song;

    public Proposal(String songAuthorLogin, Song song) {
        this.songAuthorLogin = songAuthorLogin;
        this.song = song;
    }

    public void setSongAuthorLogin(String songAuthorUUID) {
        this.songAuthorLogin = songAuthorUUID;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public String getSongAuthorLogin() {
        return songAuthorLogin;
    }

    public Song getSong() {
        return song;
    }

}
