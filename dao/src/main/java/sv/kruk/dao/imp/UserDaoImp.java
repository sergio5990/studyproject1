package sv.kruk.dao.imp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sv.kruk.domain.User;
import sv.kruk.util.DataSource;
import sv.kruk.util.ParseUser;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImp implements sv.kruk.dao.UserDao {
    final static Logger logger = LoggerFactory.getLogger(UserDaoImp.class);

    private Connection dbConnection = null;
    private ResultSet resultSet = null;
    private PreparedStatement statement = null;

    private static volatile UserDaoImp instance;

    private UserDaoImp(){}

    /**
     * singleton
     * @return
     */
    public static UserDaoImp getInstance(){
        if (instance == null) {
            synchronized (UserDaoImp.class){
                if (instance == null) {
                    instance = new UserDaoImp();
                }
            }
        }
        return  instance;
    }

    /**
     * save new user in db
     * @param user
     * @return
     * @throws SQLException
     */
    public boolean save(User user) throws SQLException {
        String sql = "INSERT INTO task_manager.user (username, password) VALUES (?, ?);";
        try {
            dbConnection = DataSource.getInstance().getConnection();
            statement = dbConnection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
            statement.close();
            dbConnection.commit();
        } catch (SQLException e) {
            dbConnection.rollback();
            logger.error("user not saved", e.getMessage());
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            dbConnection.rollback();
            logger.error("user not saved", e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            dbConnection.rollback();
            logger.error("user not saved", e.getMessage());
            e.printStackTrace();
        } finally {
            if (statement != null) statement.close();
            if (dbConnection != null) dbConnection.close();
        }
        return true;
    }

    /**
     * update user parameter in db
     * @param user
     * @return
     * @throws SQLException
     */
    public boolean update(User user) throws SQLException {
        String sql = "UPDATE task_manager.user SET username=?, password=? WHERE id=?;";
        try {
            dbConnection = DataSource.getInstance().getConnection();
            statement = dbConnection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setLong(3, user.getId());
            statement.executeUpdate();
            statement.close();
            dbConnection.commit();
        } catch (SQLException e) {
            dbConnection.rollback();
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            dbConnection.rollback();
            e.printStackTrace();
        } catch (IOException e) {
            dbConnection.rollback();
            e.printStackTrace();
        } finally {
            if (statement != null) statement.close();
            if (dbConnection != null) dbConnection.close();
        }
        return true;
    }

    /**
     * delete user from db
     * @param user
     * @return
     * @throws SQLException
     */
    public boolean delete(User user) throws SQLException {
        String sql = "DELETE FROM task_manager.user WHERE id=?;";
        try {
            dbConnection = DataSource.getInstance().getConnection();
            statement = dbConnection.prepareStatement(sql);
            statement.setLong(1, user.getId());
            statement.executeUpdate();
            statement.close();
            dbConnection.commit();
        } catch (SQLException e) {
            dbConnection.rollback();
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            dbConnection.rollback();
            e.printStackTrace();
        } catch (IOException e) {
            dbConnection.rollback();
            e.printStackTrace();
        } finally {
            if (statement != null) statement.close();
            if (dbConnection != null) dbConnection.close();
        }
        return true;
    }

    /**
     * find user in db by userId
     * @param id
     * @return
     * @throws SQLException
     */
    public User getUserById(Long id) throws SQLException {
        String sql = "SELECT * FROM task_manager.user where id = ?;";
        User user = null;
        try {
            dbConnection = DataSource.getInstance().getConnection();
            statement = dbConnection.prepareStatement(sql);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            user = ParseUser.getUserByResultSet(resultSet);
            statement.close();
            dbConnection.commit();
        } catch (SQLException e) {
            dbConnection.rollback();
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            dbConnection.rollback();
            e.printStackTrace();
        } catch (IOException e) {
            dbConnection.rollback();
            e.printStackTrace();
        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (dbConnection != null) dbConnection.close();
        }
        return user;
    }

    /**
     * find user in db by username
     * @param username
     * @return
     * @throws SQLException
     */
    public User getUserByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM task_manager.user where user.username = ?;";
        User user = null;
        try {
            dbConnection = DataSource.getInstance().getConnection();
            statement = dbConnection.prepareStatement(sql);
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            user = ParseUser.getUserByResultSet(resultSet);
            statement.close();
            dbConnection.commit();
        } catch (SQLException e) {
            dbConnection.rollback();
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            dbConnection.rollback();
            e.printStackTrace();
        } catch (IOException e) {
            dbConnection.rollback();
            e.printStackTrace();
        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (dbConnection != null) dbConnection.close();
        }
        return user;
    }

    /**
     * return all user from db
     * @return
     * @throws SQLException
     */
    public List<User> getAll() throws SQLException {
        String sql = "SELECT * FROM task_manager.user;";
        List<User> users = null;
        try {
            dbConnection = DataSource.getInstance().getConnection();
            statement = dbConnection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            users = ParseUser.getUsersByResultSet(resultSet);
            statement.close();
            dbConnection.commit();
        } catch (SQLException e) {
            dbConnection.rollback();
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            dbConnection.rollback();
            e.printStackTrace();
        } catch (IOException e) {
            dbConnection.rollback();
            e.printStackTrace();
        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (dbConnection != null) dbConnection.close();
        }
        return users;
    }
}
