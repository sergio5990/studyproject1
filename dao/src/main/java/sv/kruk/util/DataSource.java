package sv.kruk.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {

    private static String driver;
    private static String url;
    private static String password;
    private static String user;
    private static DataSource datasource;
    private ComboPooledDataSource pooledDataSource;

    /**
     * load config db from resources file
     */
    private static void config() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("database.properties");
        Properties prop = new Properties();
        try {
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * create datasource of parameter
     * @throws IOException
     * @throws SQLException
     * @throws PropertyVetoException
     */
    private DataSource() throws IOException, SQLException, PropertyVetoException {
        config();
        pooledDataSource = new ComboPooledDataSource();
        pooledDataSource.setDriverClass(driver); //loads the jdbc driver
        pooledDataSource.setJdbcUrl(url);
        pooledDataSource.setUser(user);
        pooledDataSource.setPassword(password);
        // the settings below are optional -- c3p0 can work with defaults
        pooledDataSource.setMinPoolSize(5);
        pooledDataSource.setAcquireIncrement(5);
        pooledDataSource.setMaxPoolSize(20);
        pooledDataSource.setMaxStatements(180);
    }
    /**
     * singleton
     * @return
     */
    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new DataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    /**
     * return connection from pool connection
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        Connection connection = this.pooledDataSource.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }
}
