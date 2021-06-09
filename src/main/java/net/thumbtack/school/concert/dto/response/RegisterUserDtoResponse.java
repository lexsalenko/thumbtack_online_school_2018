package net.thumbtack.school.concert.dto.response;

public class RegisterUserDtoResponse {

    private String userUUIDString;

    public RegisterUserDtoResponse(String userUUIDString) {
        this.userUUIDString = userUUIDString;
    }

    public String getUserUUIDString() {
        return userUUIDString;
    }

    public void setUserUUIDString(String userUUIDString) {
        this.userUUIDString = userUUIDString;
    }
}
