package sv.kruk.util;

import sv.kruk.domain.Status;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParseStatus {

    public static Status getStatusResultSet(ResultSet resultSet) throws SQLException {
        Status status = new Status();
        while (resultSet.next()) {
            status.setId(resultSet.getLong(1));
            status.setName(resultSet.getString(2));
        }
        return status;
    }

    public static List<Status> getStatusListByResultSet(ResultSet resultSet) throws SQLException {
        List<Status> statusList = new ArrayList<Status>();
        Status status = null;
        while (resultSet.next()) {
            status = new Status();
            status.setId(resultSet.getLong(1));
            status.setName(resultSet.getString(2));
            statusList.add(status);
        }
        return statusList;
    }
}
