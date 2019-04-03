package by.iba.protasovitski.dao;

import by.iba.protasovitski.model.User;
import by.iba.protasovitski.util.ConnectorDB;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao {
    private final static String SQL_GET_USER = "select login,passw from users where login=? and passw=?";
    private final static String SQL_GET_USER_NAME = "select login from users where login=?";
    private final static String SQL_CREATE_USER = "insert into users (login,passw) values (?,?)";

    private Connection connection;

    public UserDao() {
        try {
            connection = ConnectorDB.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean create(User user) {
        boolean result = true;
        try {
            PreparedStatement preparedStatement = ConnectorDB.getConnection().prepareStatement(SQL_CREATE_USER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassw());
            result = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            result = false;
        }
        return result;
    }

    public String crypt(String password) {
        String str = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(password.getBytes());
            str = new String(bytes);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return str;
    }

    public boolean isValidUser(final String login, final String password) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_GET_USER);
            ps.setString(1, login);
            ps.setString(2, crypt(password));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean hasUser(final String login) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_GET_USER_NAME);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
