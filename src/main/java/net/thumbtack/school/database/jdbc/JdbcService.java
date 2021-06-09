package net.thumbtack.school.database.jdbc;

import net.thumbtack.school.database.model.Group;
import net.thumbtack.school.database.model.School;
import net.thumbtack.school.database.model.Subject;
import net.thumbtack.school.database.model.Trainee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcService {

    public static void insertTrainee(Trainee trainee) throws SQLException {
        String insertQuery = "insert into trainee values(?,?,?,?,?)";
        // REVU: строка слишком длинная, разбей на две с помощью Enter
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            // REVU: id должен генерироваться базой данных, поэтому лучше сделать как для groupid - setNull(1,  java.sql.Types.INTEGER)
            preparedStatement.setInt(1, trainee.getId());
            preparedStatement.setString(2, trainee.getFirstName());
            preparedStatement.setString(3, trainee.getLastName());
            preparedStatement.setInt(4, trainee.getRating());
            preparedStatement.setNull(5, java.sql.Types.INTEGER);
            preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    trainee.setId(generatedKeys.getInt(1));
                }
            }
        }
    }


    public static void updateTrainee(Trainee trainee) throws SQLException {
        String updateQuery = "update trainee set firstName = ?, lastName = ?, rating = ? where id = ?";
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(updateQuery)) {
            preparedStatement.setString(1, trainee.getFirstName());
            preparedStatement.setString(2, trainee.getLastName());
            preparedStatement.setInt(3, trainee.getRating());
            preparedStatement.setInt(4, trainee.getId());
            preparedStatement.executeUpdate();
        }
    }


    public static Trainee getTraineeByIdUsingColNames(int traineeId) throws SQLException {
        String selectQuery = "select id, firstName, lastName, rating from trainee where id=" + traineeId;
        // REVU: строка слишком длинная, разбей на две с помощью Enter
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(selectQuery); ResultSet resultSet = preparedStatement.executeQuery();) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int rating = resultSet.getInt("rating");

                return new Trainee(id, firstName, lastName, rating);
            }
        }
        return null;
    }


    public static Trainee getTraineeByIdUsingColNumbers(int traineeId) throws SQLException {
        String selectQuery = "select id, firstName, lastName, rating from trainee where id=" + traineeId;
        // REVU: строка слишком длинная, разбей на две с помощью Enter
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(selectQuery); ResultSet resultSet = preparedStatement.executeQuery();) {
            // REVU: if вместо while
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                int rating = resultSet.getInt(4);

                return new Trainee(id, firstName, lastName, rating);
            }
        }
        return null;
    }


    public static List<Trainee> getTraineesUsingColNames() throws SQLException {
        List<Trainee> traineeList = new ArrayList<>();
        String selectQuery = "select * from trainee";
        // REVU: строка слишком длинная, разбей на две с помощью Enter
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(selectQuery); ResultSet resultSet = preparedStatement.executeQuery();) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int rating = resultSet.getInt("rating");

                traineeList.add(new Trainee(id, firstName, lastName, rating));
            }
        }
        return traineeList;
    }


    public static List<Trainee> getTraineesUsingColNumbers() throws SQLException {
        List<Trainee> traineeList = new ArrayList<>();
        String selectQuery = "select * from trainee";
        // REVU: строка слишком длинная, разбей на две с помощью Enter
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(selectQuery); ResultSet resultSet = preparedStatement.executeQuery();) {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                int rating = resultSet.getInt(4);

                traineeList.add(new Trainee(id, firstName, lastName, rating));
            }
        }
        return traineeList;
    }


    public static void deleteTrainee(Trainee trainee) throws SQLException {
        String deleteQuery = "delete from trainee where id=?";
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, trainee.getId());
            preparedStatement.executeUpdate();
        }
    }


    public static void deleteTrainees() throws SQLException {
        String deleteQuery = "delete from trainee";
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(deleteQuery);) {
            preparedStatement.executeUpdate();
        }
    }


    public static void insertSubject(Subject subject) throws SQLException {
        String insertQuery = "insert into subject values(?,?)";
        // REVU: строка слишком длинная, разбей на две с помощью Enter
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            // REVU: setNull
            preparedStatement.setInt(1, subject.getId());
            preparedStatement.setString(2, subject.getName());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                subject.setId(generatedKeys.getInt(1));
            }
        }
    }


    public static Subject getSubjectByIdUsingColNames(int subjectId) throws SQLException {
        String selectQuery = "select id, name from subject where id=" + subjectId;
        // REVU: строка слишком длинная, разбей на две с помощью Enter
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(selectQuery); ResultSet resultSet = preparedStatement.executeQuery();) {
            // REVU: if
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                return new Subject(id, name);
            }
        }
        return null;
    }


    public static Subject getSubjectByIdUsingColNumbers(int subjectId) throws SQLException {
        String selectQuery = "select id, name from subject where id=" + subjectId;
        // REVU: строка слишком длинная, разбей на две с помощью Enter
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(selectQuery); ResultSet resultSet = preparedStatement.executeQuery();) {
            // REVU: if
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);

                return new Subject(id, name);
            }
        }
        return null;
    }


    public static void deleteSubjects() throws SQLException {
        String deleteQuery = "delete from subject";
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(deleteQuery)) {
            preparedStatement.executeUpdate();
        }
    }


    public static void insertSchool(School school) throws SQLException {
        String insertQuery = "insert into school(id, name, year) values(?, ?, ?)";
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            // REVU: setNull
            preparedStatement.setInt(1, school.getId());
            preparedStatement.setString(2, school.getName());
            preparedStatement.setInt(3, school.getYear());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                school.setId(resultSet.getInt(1));
            }
        }
    }


    public static School getSchoolByIdUsingColNames(int schoolId) throws SQLException {
        String selectQuery = "select id, name, year from school where id=" + schoolId;
        // REVU: строка слишком длинная, разбей на две с помощью Enter
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(selectQuery); ResultSet resultSet = preparedStatement.executeQuery();) {
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int year = resultSet.getInt("year");

                return new School(id, name, year, new ArrayList<>());
            }
        }
        return null;
    }


    public static School getSchoolByIdUsingColNumbers(int schoolId) throws SQLException {
        String selectQuery = "select id, name, year from school where id=" + schoolId;
        // REVU: строка слишком длинная, разбей на две с помощью Enter
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(selectQuery); ResultSet resultSet = preparedStatement.executeQuery();) {
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int year = resultSet.getInt(3);

                return new School(id, name, year, new ArrayList<>());
            }
        }
        return null;
    }


    public static void deleteSchools() throws SQLException {
        String deleteQuery = "delete from school";
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(deleteQuery)) {
            preparedStatement.executeUpdate();
        }
    }


    public static void insertGroup(School school, Group group) throws SQLException {
        String insertGroupQuery = "insert into `group` values(?,?,?,?)";

        try (PreparedStatement psInsertGroup = JdbcUtils.getConnection().prepareStatement(insertGroupQuery, Statement.RETURN_GENERATED_KEYS);) {

            // REVU: setNull
            psInsertGroup.setInt(1, group.getId());
            psInsertGroup.setString(2, group.getName());
            psInsertGroup.setString(3, group.getRoom());
            psInsertGroup.setInt(4, school.getId());
            psInsertGroup.executeUpdate();

            try (ResultSet generatedKeys = psInsertGroup.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    group.setId(generatedKeys.getInt(1));
                }
            }
        }
    }


    public static School getSchoolByIdWithGroups(int id) throws SQLException {
        // REVU: строка слишком длинная, разбей на две с помощью Enter
        String selectQuery = "select school.id, school.name, year, group.id, group.name, room from school inner join `group` where schoolid=school.id and school.id=?";
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(selectQuery);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            School school = new School();
            school.setGroups(new ArrayList<>());
            while (resultSet.next()) {
                school.setId(resultSet.getInt(1));
                school.setName(resultSet.getString(2));
                school.setYear(resultSet.getInt(3));
                Group group = new Group(resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6));

                school.addGroup(group);
            }
            return school;
        }
    }


    public static List<School> getSchoolsWithGroups() throws SQLException {
        String selectQuery = "select school.id, school.name, year, group.id, group.name, room from school inner join `group` where schoolid=school.id";
        try (PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(selectQuery); ResultSet resultSet = preparedStatement.executeQuery();) {
            Map<String, School> schoolMap = new HashMap<>();
            while (resultSet.next()) {
                int sid = resultSet.getInt("school.id");
                String sname = resultSet.getString("school.name");
                int syear = resultSet.getInt("year");
                if (!schoolMap.containsKey(sname)) {
                    schoolMap.put(sname, new School(sid, sname, syear, new ArrayList<>()));
                }

                int gid = resultSet.getInt("group.id");
                String gname = resultSet.getString("group.name");
                String room = resultSet.getString("room");
                School schoolTerm = schoolMap.get(sname);
                schoolTerm.addGroup(new Group(gid, gname, room));
                schoolMap.put(sname, schoolTerm);
            }

            return new ArrayList<>(schoolMap.values());
        }
    }

}