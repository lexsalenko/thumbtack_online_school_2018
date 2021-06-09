package net.thumbtack.school.concert.domain;

public class User {

    private String firstName;
    private String lastName;
    private String login;
    private String password;

    public User(String firstName, String lastName, String login, String password) {
        setFirstName(firstName);
        setLastName(lastName);
        setLogin(login);
        setPassword(password);
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

}
