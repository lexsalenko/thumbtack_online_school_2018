package net.thumbtack.school.concert.dto.request;

public class UserLoginDtoRequest {

    private String userLogin;

    public UserLoginDtoRequest(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
}
