package net.thumbtack.school.concert.dto.request;

public class OnlineUserTokenDtoRequest {

    private String userToken;

    public OnlineUserTokenDtoRequest(String userToken) {
        this.userToken = userToken;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
