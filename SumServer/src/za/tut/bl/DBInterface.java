
package za.tut.bl;
import java.sql.*;

public interface DBInterface {
   
    public void storedata(Integer num1,Integer num2,char op,Integer answer)throws SQLException;


}
