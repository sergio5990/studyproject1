package sv.kruk.dao;

import sv.kruk.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    public boolean save(User user) throws SQLException;
    public boolean update(User user) throws SQLException;
    public boolean delete(User user) throws  SQLException;
    public User getUserById(Long id) throws SQLException;
    public User getUserByName(String username) throws SQLException;
    List<User> getAll() throws SQLException;

}
