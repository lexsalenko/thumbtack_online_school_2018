package net.thumbtack.school.concert.dto.request;

public class CancelProposedSongDtoRequest {

    private String songAuthorLogin;
    private String songUUIDString;

    public CancelProposedSongDtoRequest(String songAuthorLogin, String songUUIDString) {
        this.songAuthorLogin = songAuthorLogin;
        this.songUUIDString = songUUIDString;
    }

    public String getSongAuthorLogin() {
        return songAuthorLogin;
    }

    public String getSongUUIDString() {
        return songUUIDString;
    }

    public void setSongAuthorLogin(String songAuthorLogin) {
        this.songAuthorLogin = songAuthorLogin;
    }

    public void setSongUUIDString(String songUUIDString) {
        this.songUUIDString = songUUIDString;
    }
}
