package net.thumbtack.school.http;

import com.google.gson.Gson;
import net.thumbtack.school.database.jdbc.JdbcUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CountryService {

    private Gson gson = new Gson();

    public static void main(String[] args) throws Exception {

        JdbcUtils.createConnection();
        deleteCities();

        String[] cities = {"London", "Paris", "Astana", "Moscow"};
        for (String city : cities) {
            insertCity(new City(city));
        }

        List<City> cityList = getCitiesUsingColNames();
        for (City city : cityList) {
            System.out.println(new CountryService().getCountryInfo(city.getName()));
        }

        JdbcUtils.closeConnection();
    }


    public String getCountryInfo(String capital_city_name) throws IOException {

        URL url = new URL("http://restcountries.eu/rest/v2/capital/" + capital_city_name + "?fields=name;capital;currencies");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.connect();
        try (InputStreamReader in = new InputStreamReader((InputStream) conn.getContent());
             BufferedReader buff = new BufferedReader(in)) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = buff.readLine()) != null) {
                sb.append(line).append("\n");
            }

            return gson.toJson(sb.toString());
        }
    }

    public static void insertCity(City city) throws SQLException {
        String insertQuery = "insert into city values(?,?)";
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, city.getId());
            preparedStatement.setString(2, city.getName());
            preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    city.setId(generatedKeys.getInt(1));
                }
            }
        }
    }


    public static List<City> getCitiesUsingColNames() throws SQLException {
        List<City> citiesList = new ArrayList<>();
        String selectQuery = "select * from city";

        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery();) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String capital_city_name = resultSet.getString("capital_city_name");

                citiesList.add(new City(id, capital_city_name));
            }
        }
        return citiesList;
    }

    public static void deleteCities() throws SQLException {
        String deleteQuery = "delete from city";
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(deleteQuery);) {
            preparedStatement.executeUpdate();
        }
    }

}
