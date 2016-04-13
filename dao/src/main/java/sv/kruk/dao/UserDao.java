package sv.kruk.dao;

import sv.kruk.domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * methods for use user in db
 */
public interface UserDao {

    public boolean save(User user) throws SQLException;
    public boolean update(User user) throws SQLException;
    public boolean delete(User user) throws  SQLException;
    public User getUserById(Long id) throws SQLException;
    public User getUserByUsername(String username) throws SQLException;
    List<User> getAll() throws SQLException;

}
