package net.thumbtack.school.concert.dto.response;

import net.thumbtack.school.concert.domain.User;

public class UserLoginDtoResponse {

    private User user;

    public UserLoginDtoResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
