import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception{

        Class.forName("org.h2.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "sa", "");
        Statement stmt = con.createStatement();

        String createTable = "DROP TABLE IF EXISTS TEST; CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255), AGE INT, COMPANY VARCHAR(255))";
        stmt.execute(createTable);

        String insertRow = "INSERT INTO TEST VALUES(1, 'ELIAS', 23, 'MERCADO_LIBRE')";
        String insertRow2 = "INSERT INTO TEST VALUES(2, 'ROBERTO', 27, 'DIGITALHOUSE')";
        String insertRow3 = "INSERT INTO TEST VALUES(3, 'LUCAS', 19, 'FACEBOOK')";
        String insertRow4 = "INSERT INTO TEST VALUES(4, 'ANA', 24, 'GOOGLE')";

        stmt.execute(insertRow);
        stmt.execute(insertRow2);
        stmt.execute(insertRow3);
        stmt.execute(insertRow4);

        String sql = "SELECT * FROM TEST";
        ResultSet rd = stmt.executeQuery(sql);

        while( rd.next() ) {
            System.out.println(rd.getInt(1) + " " + rd.getString(2) + " " + rd.getInt(3) + " " + rd.getString(4));
        }
    }
}
