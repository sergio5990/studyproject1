package sv.kruk.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public interface RoleDao {

    public boolean save(String role) throws SQLException, IOException, PropertyVetoException;
}
