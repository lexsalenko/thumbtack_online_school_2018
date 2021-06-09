package net.thumbtack.school.concert.dto.request;

public class AllSongsByAuthorLoginDtoRequest {

    private String userLogin;

    public AllSongsByAuthorLoginDtoRequest(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
}
