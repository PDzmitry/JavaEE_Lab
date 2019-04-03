package by.iba.protasovitski.dao;

import by.iba.protasovitski.model.Person;
import by.iba.protasovitski.util.ConnectorDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {

    private final static String SQL_GET_PERSON_ALL = "select * from persons";
    private final static String SQL_CREATE_PERSON = "insert into persons(name, phone, email) values(?,?,?)";
    private final static String SQL_UPDATE_PERSON = "update persons set name=?, phone=?,email= ? where id=?";
    private final static String SQL_DELETE_PERSON = "delete from persons where id=?";
    private final static String SQL_GET_PERSON_ID = "select * from persons where id=?";

    private static List<Person> createPersonList(ResultSet resultSet) {
        List<Person> people = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setPhone(resultSet.getString("phone"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }
        } catch (SQLException e) {
            people = null;
            e.printStackTrace();
        }
        return people;
    }

    public static List<Person> findAll() {
        List<Person> people;
        try {
            PreparedStatement preparedStatement = ConnectorDB.getConnection()
                    .prepareStatement(SQL_GET_PERSON_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            people = createPersonList(resultSet);
        } catch (SQLException e) {
            people = null;
            e.printStackTrace();
        }
        return people;
    }

    public static Person find(int id) {
        Person person = new Person();
        try {
            PreparedStatement preparedStatement = ConnectorDB.getConnection()
                    .prepareStatement(SQL_GET_PERSON_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Person> people = createPersonList(resultSet);
            if (people != null) {
                person = people.iterator().next();
            }
        } catch (SQLException e) {
            person = null;
            e.printStackTrace();
        }
        return person;
    }

    public static boolean create(Person person) {
        boolean result = true;
        try {
            PreparedStatement preparedStatement = ConnectorDB.getConnection().prepareStatement(SQL_CREATE_PERSON);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getPhone());
            preparedStatement.setString(3, person.getEmail());
            result = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            result = false;
        }
        return result;
    }

    public static boolean update(Person person) {
        boolean result = true;
        try {
            PreparedStatement preparedStatement = ConnectorDB.getConnection().prepareStatement(SQL_UPDATE_PERSON);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getPhone());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.setInt(4, person.getId());
            result = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            result = false;
        }
        return result;
    }

    public static boolean delete(int id) {
        boolean result = true;
        try {
            PreparedStatement preparedStatement = ConnectorDB.getConnection().prepareStatement(SQL_DELETE_PERSON);
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            result = false;
        }
        return result;
    }

}
