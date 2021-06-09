package net.thumbtack.school.concert.dto.request;

public class LogOutUserDtoRequest {

    private String userUUIDString;

    public LogOutUserDtoRequest(String userUUIDString) {
        this.userUUIDString = userUUIDString;
    }

    public String getUserUUIDString() {
        return userUUIDString;
    }

    public void setUserUUIDString(String userUUIDString) {
        this.userUUIDString = userUUIDString;
    }
}
