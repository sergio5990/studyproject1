package sv.kruk.dao;

import sv.kruk.domain.Status;

import java.sql.SQLException;
import java.util.List;

public interface StatusDao {
    Status getStatusById(long id) throws SQLException;

    Status getStatusByName(String name) throws SQLException;

    List<Status> getAll() throws SQLException;
}
