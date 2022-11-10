import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Programa {

    private static final Logger logger = Logger.getLogger(String.valueOf(Programa.class));

    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "sa", "");
        Statement stmt = con.createStatement();

        String createTable = "DROP TABLE IF EXISTS EMPLEADO; CREATE TABLE EMPLEADO(ID INT PRIMARY KEY, NAME VARCHAR(255), LASTNAME VARCHAR(255))";
        stmt.execute(createTable);

        try {
            String empleado1 = "INSERT INTO EMPLEADO VALUES(1, 'ELIAS', 'PALADINO')";
            String empleado2 = "INSERT INTO EMPLEADO VALUES(2, 'FRANCO', 'GOMEZ')";
            String empleado3 = "INSERT INTO EMPLEADO VALUES(3, 'LAURA', 'LOPEZ')";
            String empleado4 = "INSERT INTO EMPLEADO VALUES(5, 'MELINA', 'GIMENEZ')";

            stmt.execute(empleado1);
            stmt.execute(empleado2);
            stmt.execute(empleado3);
            stmt.execute(empleado4);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error identificador repetido", e);
        }

        try {
            String update = "UPDATE EMPLEADO SET ID=4 WHERE NAME='MELINA'";
            stmt.execute(update);
        } catch (Exception e) {
            logger.log(Level.CONFIG, "No existe ese empleado", e);
        }

        String sql = "SELECT * FROM EMPLEADO";
        ResultSet rd = stmt.executeQuery(sql);

        while (rd.next()) {
            System.out.println(rd.getInt(1) + " | " + rd.getString(2) + " | " + rd.getString(3) );
        }
    }
}
