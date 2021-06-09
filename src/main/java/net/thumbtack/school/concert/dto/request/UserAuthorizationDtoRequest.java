package net.thumbtack.school.concert.dto.request;

public class UserAuthorizationDtoRequest {
    private String login;
    private String password;

    public UserAuthorizationDtoRequest(String login, String password) {
        setLogin(login);
        setPassword(password);
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
