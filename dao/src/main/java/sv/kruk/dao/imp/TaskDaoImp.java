package sv.kruk.dao.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sv.kruk.dao.TaskDao;
import sv.kruk.domain.Task;
import sv.kruk.domain.User;
import sv.kruk.util.DataSource;
import sv.kruk.util.ParseTask;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.util.List;

public class TaskDaoImp implements TaskDao {
    final static Logger logger = LoggerFactory.getLogger(TaskDaoImp.class);
    private Connection dbConnection = null;
    private ResultSet resultSet = null;
    private  PreparedStatement statement = null;

    private static volatile TaskDaoImp instance;

    private TaskDaoImp(){}
    /**
     * singleton
     * @return
     */
    public static TaskDaoImp getInstance(){
        if (instance == null) {
            synchronized (TaskDaoImp.class){
                if (instance == null) {
                    instance = new TaskDaoImp();
                }
            }
        }
        return  instance;
    }

    /**
     * return list tasks for current user
     * @param user
     * @return
     * @throws SQLException
     */
    public List<Task> getTasksByUser(User user) throws SQLException {
        String sql = "SELECT * FROM task_manager.task where task.createTaskUser_id = ?;";
        List<Task> tasks = null;
        try {
            dbConnection = DataSource.getInstance().getConnection();
            statement = dbConnection.prepareStatement(sql);
            statement.setLong(1, user.getId());
            resultSet = statement.executeQuery();
            tasks = ParseTask.getTasksByResultSet(resultSet);
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
        return tasks;
    }

    /**
     * save new task in db by current user
     * @param task
     * @throws SQLException
     */
    public void save(Task task) throws SQLException {
        String sql = "INSERT INTO task_manager.task (title, description, createDate, status_id, createTaskUser_id) VALUES (?, ?, ?,?,?);";
        try {
            dbConnection = DataSource.getInstance().getConnection();
            statement = dbConnection.prepareStatement(sql);
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setDate(3, new java.sql.Date(task.getCreateDate().getTime()));
            statement.setLong(4, task.getStatus().getId());
            statement.setLong(5, task.getCreateTaskUser().getId());
            statement.executeUpdate();
            statement.close();
            dbConnection.commit();
        } catch (SQLException e) {
            dbConnection.rollback();
            logger.error("task not saved",e.getMessage());
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            dbConnection.rollback();
            logger.error("task not saved",e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            dbConnection.rollback();
            logger.error("task not saved",e.getMessage());
            e.printStackTrace();
        } finally {
            if (statement != null) statement.close();
            if (dbConnection != null) dbConnection.close();
        }
    }

    /**
     * return task by taskId
     * @param taskId
     * @return
     * @throws SQLException
     */
    public Task getTaskById(Long taskId) throws SQLException {
        String sql = "SELECT * FROM task_manager.task where task.id = ?;";

        List<Task> tasks = null;
        try {
            dbConnection = DataSource.getInstance().getConnection();
            statement = dbConnection.prepareStatement(sql);
            statement.setLong(1, taskId);
            resultSet = statement.executeQuery();
            tasks = ParseTask.getTasksByResultSet(resultSet);
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
        if (tasks != null && !tasks.isEmpty()) {
            return tasks.get(0);
        }else{
            return  null;
        }
    }

    public void updateStatus(Long taskId, Long statusId) {

    }
}
