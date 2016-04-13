package sv.kruk.dao.imp;


import sv.kruk.dao.StatusDao;
import sv.kruk.domain.Status;
import sv.kruk.util.DataSource;
import sv.kruk.util.ParseStatus;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StatusDaoImp implements StatusDao {

    private Connection dbConnection = null;
    private ResultSet resultSet = null;
    private PreparedStatement statement = null;

    private static volatile StatusDaoImp instance;

    private StatusDaoImp(){}
    /**
     * singleton
     * @return
     */
    public static StatusDaoImp getInstance(){
        if (instance == null) {
            synchronized (StatusDaoImp.class){
                if (instance == null) {
                    instance = new StatusDaoImp();
                }
            }
        }
        return  instance;
    }

    /**
     * return status by statusId
     * @param id
     * @return
     * @throws SQLException
     */
    public Status getStatusById(long id) throws SQLException {
        String sql = "SELECT * FROM task_manager.status where status.id = ?;";
        Status status = null;
        try {
            dbConnection = DataSource.getInstance().getConnection();
            statement = dbConnection.prepareStatement(sql);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            status = ParseStatus.getStatusResultSet(resultSet);
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
        return status;
    }

    /**
     * return status by statusName
     * @param name
     * @return
     * @throws SQLException
     */
    public Status getStatusByName(String name) throws SQLException {
        String sql = "SELECT * FROM task_manager.status where status.name = ?;";
        Status status = null;
        try {
            dbConnection = DataSource.getInstance().getConnection();
            statement = dbConnection.prepareStatement(sql);
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            status = ParseStatus.getStatusResultSet(resultSet);
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
        return status;
    }

    /**
     * return all status
     * @return
     * @throws SQLException
     */
    public List<Status> getAll() throws SQLException {
        String sql = "SELECT * FROM task_manager.status;";
        List<Status> statusList = null;
        try {
            dbConnection = DataSource.getInstance().getConnection();
            statement = dbConnection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            statusList = ParseStatus.getStatusListByResultSet(resultSet);
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
        return statusList;
    }
}
