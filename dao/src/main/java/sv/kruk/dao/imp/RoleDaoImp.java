package sv.kruk.dao.imp;

import sv.kruk.util.DataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoleDaoImp implements sv.kruk.dao.RoleDao {

    private Connection dbConnection = null;
    private PreparedStatement statement = null;

    private static volatile RoleDaoImp instance;

    private RoleDaoImp(){}

    public static RoleDaoImp getInstance(){
        if (instance == null) {
            synchronized (RoleDaoImp.class){
                if (instance == null) {
                    instance = new RoleDaoImp();
                }
            }
        }
        return  instance;
    }

    public boolean save(String role) throws SQLException {
        String sql = "INSERT INTO task_manager.role (role_name) VALUES (?)";
        try {
            dbConnection = DataSource.getInstance().getConnection();
            statement = dbConnection.prepareStatement(sql);
            statement.setString(1, role);
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
        return  true;
    }

}
