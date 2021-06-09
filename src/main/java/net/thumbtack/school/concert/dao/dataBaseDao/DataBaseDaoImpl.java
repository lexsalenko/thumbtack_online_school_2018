package net.thumbtack.school.concert.dao.dataBaseDao;

import com.google.gson.Gson;
import net.thumbtack.school.concert.dataBase.DataBase;
import net.thumbtack.school.concert.exception.ServerException;

public class DataBaseDaoImpl implements DataBaseDao {

    private DataBase dataBase = DataBase.getInstance();

    @Override
    public void startServer(String savedDataFileName, Gson gson) throws ServerException {
        dataBase.startServer(savedDataFileName, gson);
    }

    @Override
    public void stopServer(String savedDataFileName, Gson gson) throws ServerException {
        dataBase.stopServer(savedDataFileName, gson);
    }

}
