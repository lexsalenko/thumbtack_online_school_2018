package net.thumbtack.school.concert.dao.dataBaseDao;

import com.google.gson.Gson;
import net.thumbtack.school.concert.exception.ServerException;

public interface DataBaseDao {

    void startServer(String savedDataFileName, Gson gson) throws ServerException;

    void stopServer(String savedDataFileName, Gson gson) throws ServerException;

}
