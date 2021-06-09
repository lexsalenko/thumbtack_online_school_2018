package net.thumbtack.school.concert.dto.request;

public class LeaveServerDtoRequest {

    private String userUUIDString;

    public LeaveServerDtoRequest(String userUUIDString) {
        this.userUUIDString = userUUIDString;
    }

    public String getUserUUIDString() {
        return userUUIDString;
    }

    public void setUserUUIDString(String userUUIDString) {
        this.userUUIDString = userUUIDString;
    }
}
