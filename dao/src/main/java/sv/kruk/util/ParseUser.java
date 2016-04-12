package sv.kruk.util;

import sv.kruk.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParseUser {

    public static User getUserBySql(ResultSet resultSet) throws SQLException {
        User user = null;
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getLong(1));
            user.setPassword(resultSet.getString(2));
            user.setToken(resultSet.getString(3));
            user.setUsername(resultSet.getString(4));
        }
        return user;
    }

    public static List<User> getUsersBySql(ResultSet resultSet) throws SQLException {
        List<User> users = new ArrayList<User>();
        User user = null;
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getLong(1));
            user.setPassword(resultSet.getString(2));
            user.setToken(resultSet.getString(3));
            user.setUsername(resultSet.getString(4));
            users.add(user);
        }
        return users;
    }
}
