
import Order.Database.ConnectDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {
        try {
            ConnectDataBase.getInstance().connectToDatabase();
            insert();
            System.out.println("Connect Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void insert() throws SQLException {
        String name = "foods";
        double sellPrice = 3;
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = ConnectDataBase.getInstance().createConnection();
            p = con.prepareStatement("insert into product (ProductName, SellPrice) values (?,?)");
            p.setString(1, name);
            p.setDouble(2, sellPrice);
            p.execute();
        } finally {
            // close
            ConnectDataBase.getInstance().close(p, con);
        }
    }
}
