package net.thumbtack.school.concert.dao.userDao;

import net.thumbtack.school.concert.domain.User;
import net.thumbtack.school.concert.exception.ServerException;

public interface UserDao {

    String registerUser(User user, String userToken) throws ServerException;

    String logInUser(String login, String password, String userToken) throws ServerException;

    User getOnlineUserByToken(String requestJsonString);

    User getUserByLogin(String requestJsonString);

    void logOutUser(String requestJsonString);

    void leaveServer(String userUUID) throws ServerException;

}
