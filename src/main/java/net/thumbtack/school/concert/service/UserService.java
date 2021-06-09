package net.thumbtack.school.concert.service;

import com.google.gson.Gson;
import net.thumbtack.school.concert.dao.userDao.UserDao;
import net.thumbtack.school.concert.dao.userDao.UserDaoImpl;
import net.thumbtack.school.concert.domain.User;
import net.thumbtack.school.concert.dto.request.*;
import net.thumbtack.school.concert.dto.response.*;
import net.thumbtack.school.concert.exception.ServerException;
import net.thumbtack.school.concert.validators.Validator;

import java.util.UUID;

public class UserService {

    private UserDao userDao = new UserDaoImpl();
    private Gson gson = new Gson();

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String registerUser(String requestJsonString) {
        try {
            RegisterUserDtoRequest registerUserDtoRequest = gson.fromJson(requestJsonString, RegisterUserDtoRequest.class);
            Validator.validateRegisterUser(registerUserDtoRequest);
            User user = new User(
                    registerUserDtoRequest.getFirstName(),
                    registerUserDtoRequest.getLastName(),
                    registerUserDtoRequest.getLogin(),
                    registerUserDtoRequest.getPassword());
            UUID uuid = UUID.randomUUID();
            String userUUIDString = userDao.registerUser(user, uuid.toString());
            RegisterUserDtoResponse registerUserDtoResponse = new RegisterUserDtoResponse(userUUIDString);
            return gson.toJson(registerUserDtoResponse);
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    public String getUserByLogin(String requestJsonString) {
        try {
            UserLoginDtoRequest userLoginDtoRequest = gson.fromJson(requestJsonString, UserLoginDtoRequest.class);
            Validator.validateUserLogin(userLoginDtoRequest.getUserLogin());
            User user = userDao.getUserByLogin(userLoginDtoRequest.getUserLogin());
            UserLoginDtoResponse userLoginDtoResponse = new UserLoginDtoResponse(user);
            return gson.toJson(userLoginDtoResponse);
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    public String getOnlineUserUUIDString(String requestJsonString) {
        try {
            OnlineUserTokenDtoRequest onlineUserTokenDtoRequest
                    = gson.fromJson(requestJsonString, OnlineUserTokenDtoRequest.class);
            Validator.validateUserUUIDString(onlineUserTokenDtoRequest.getUserToken());
            User user = userDao.getOnlineUserByToken(onlineUserTokenDtoRequest.getUserToken());
            UserLoginDtoResponse userLoginDtoResponse = new UserLoginDtoResponse(user);
            return gson.toJson(userLoginDtoResponse);
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    public String logInUser(String requestJsonString) {
        try {
            UserAuthorizationDtoRequest request = gson.fromJson(requestJsonString, UserAuthorizationDtoRequest.class);
            Validator.validateUserLogin(request.getLogin());
            Validator.validateUserLPassword(request.getPassword());
            UUID token = UUID.randomUUID();
            String userUUIDString = userDao.logInUser(request.getLogin(), request.getPassword(), token.toString());
            LogInUserDtoResponse logInUserDtoResponse = new LogInUserDtoResponse(userUUIDString);
            return gson.toJson(logInUserDtoResponse);
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    public String logOutUser(String requestJsonString) {
        try {
            LogOutUserDtoRequest logOutUserDtoRequest = gson.fromJson(requestJsonString, LogOutUserDtoRequest.class);
            Validator.validateUserUUIDString(logOutUserDtoRequest.getUserUUIDString());
            userDao.logOutUser(logOutUserDtoRequest.getUserUUIDString());
            return gson.toJson(new SuccessResponse());
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    public String leaveServer(String requestJsonString) throws ServerException {
        try {
            LeaveServerDtoRequest leaveServerDtoRequest = gson.fromJson(requestJsonString, LeaveServerDtoRequest.class);
            Validator.validateUserUUIDString(leaveServerDtoRequest.getUserUUIDString());
            userDao.leaveServer(leaveServerDtoRequest.getUserUUIDString());
            return gson.toJson(new SuccessResponse());
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }
}
