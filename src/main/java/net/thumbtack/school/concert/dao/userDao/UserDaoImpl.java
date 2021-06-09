package net.thumbtack.school.concert.dao.userDao;

import net.thumbtack.school.concert.dataBase.DataBase;
import net.thumbtack.school.concert.domain.User;
import net.thumbtack.school.concert.exception.ServerException;

public class UserDaoImpl implements UserDao {

    private DataBase dataBase = DataBase.getInstance();

    @Override
    public String registerUser(User user, String userToken) throws ServerException {
        return dataBase.registerUser(user, userToken);
    }

    @Override
    public User getUserByLogin(String UserLogin) {
        return dataBase.getUserByLogin(UserLogin);
    }

    @Override
    public String logInUser(String login, String password, String userToken) throws ServerException {
        return dataBase.logInUser(login, password, userToken);
    }

    @Override
    public void logOutUser(String userToken) {
        dataBase.logOutUser(userToken);
    }

    @Override
    public User getOnlineUserByToken(String UserToken) {
        return dataBase.getOnlineUserByToken(UserToken);
    }

    @Override
    public void leaveServer(String userUUID) throws ServerException {
        dataBase.leaveServer(userUUID);
    }

}
