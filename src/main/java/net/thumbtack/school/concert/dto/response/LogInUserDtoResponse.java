package net.thumbtack.school.concert.dto.response;

public class LogInUserDtoResponse {

    private String userUUIDString;

    public LogInUserDtoResponse(String userUUIDString) {
        this.userUUIDString = userUUIDString;
    }

    public String getUserUUIDString() {
        return userUUIDString;
    }

    public void setUserUUIDString(String userUUIDString) {
        this.userUUIDString = userUUIDString;
    }
}
