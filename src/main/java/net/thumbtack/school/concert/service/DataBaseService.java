package net.thumbtack.school.concert.service;

import com.google.gson.Gson;
import net.thumbtack.school.concert.dao.dataBaseDao.DataBaseDaoImpl;
import net.thumbtack.school.concert.dto.request.StartServerDtoRequest;
import net.thumbtack.school.concert.dto.request.StopServerDtoRequest;
import net.thumbtack.school.concert.dto.response.ErrorResponse;
import net.thumbtack.school.concert.dto.response.SuccessResponse;
import net.thumbtack.school.concert.exception.ServerException;

public class DataBaseService {

    private Gson gson = new Gson();
    private DataBaseDaoImpl dataBaseDaoImpl = new DataBaseDaoImpl();

    public String startServer(String stringRequest) {
        try {
            StartServerDtoRequest startServerDtoRequest = gson.fromJson(stringRequest, StartServerDtoRequest.class);
            dataBaseDaoImpl.startServer(startServerDtoRequest.getFileName(), gson);
            return gson.toJson(new SuccessResponse());
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    public String stopServer(String stringRequest) {
        try {
            StopServerDtoRequest stopServerDtoRequest = gson.fromJson(stringRequest, StopServerDtoRequest.class);
            dataBaseDaoImpl.stopServer(stopServerDtoRequest.getFileName(), gson);
            return gson.toJson(new SuccessResponse());
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }
}
