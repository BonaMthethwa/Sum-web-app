
package za.tut.bl;
import java.sql.*;
import java.time.Instant;

public class DBManager implements DBInterface, TBLInterface{
    private Connection connection;

    public DBManager() throws SQLException {
        connection =DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    @Override
    public void storedata(Integer num1, Integer num2, char op, Integer answer) throws SQLException {
        String sql="Insert into ari_tbl values(?,?,?,?,?)";
        PreparedStatement ps=connection.prepareStatement(sql);
        ps.setInt(1, num1);
        ps.setInt(2, num2);
        ps.setString(3, String.valueOf(op));
        ps.setInt(4, answer);
        ps.setTimestamp(5, Timestamp.from(Instant.now()));
        ps.executeUpdate();
        ps.close();
    }
    
    
    
}
