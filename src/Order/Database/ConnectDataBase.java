/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order.Database;
import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 *
 * @author Admin
 */
public class ConnectDataBase {

    private static ConnectDataBase instance;
    private BasicDataSource dataSource;
    private String host = "localhost";
    private String port = "3306";
    private String database = "OrderCoffee";
    private String username = "root";
    private String password = "Thanhhung1020@";

    public static ConnectDataBase getInstance() {
        if (instance == null) {
            instance = new ConnectDataBase();
        }
        return instance;
    }

    private ConnectDataBase() {

    }

    public void connectToDatabase() throws SQLException {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://" + host + ":" + port + "/" + database);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.start();
    }

     public Connection createConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void close(AutoCloseable... close) throws SQLException {
        try {
            for (AutoCloseable c : close) {
                if (c != null) {
                    c.close();
                }
            }
        } catch (Exception e) {
            throw new SQLException("Error on closing");
        }
    }
}
