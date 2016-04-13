package sv.kruk.util;

import sv.kruk.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParseUser {
    /**
     * build user of resultset
     * @param resultSet
     * @return
     * @throws SQLException
     */
    public static User getUserByResultSet(ResultSet resultSet) throws SQLException {
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

    /**
     * build list users of resultset
     * @param resultSet
     * @return
     * @throws SQLException
     */
    public static List<User> getUsersByResultSet(ResultSet resultSet) throws SQLException {
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
