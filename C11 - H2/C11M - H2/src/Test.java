import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "sa", "");
        Statement stmt = con.createStatement();

        String createTable = "DROP TABLE IF EXISTS FIGURA; CREATE TABLE FIGURA(ID INT PRIMARY KEY, TYPE VARCHAR(255), COLOR VARCHAR(255));";
        stmt.execute(createTable);

        String figura1 = "INSERT INTO FIGURA VALUES(1, 'CIRCULO', 'ROJO')";
        String figura6 = "INSERT INTO FIGURA VALUES(6, 'CIRCULO', 'ROJO')";
        String figura2 = "INSERT INTO FIGURA VALUES(2, 'CIRCULO', 'VERDE')";
        String figura3 = "INSERT INTO FIGURA VALUES(3, 'CUADRADO', 'ROJO')";
        String figura4 = "INSERT INTO FIGURA VALUES(4, 'CUADRADO', 'AZUL')";
        String figura5 = "INSERT INTO FIGURA VALUES(5, 'CUADRADO', 'AMARILLO')";

        stmt.execute(figura1);
        stmt.execute(figura2);
        stmt.execute(figura3);
        stmt.execute(figura4);
        stmt.execute(figura5);
        stmt.execute(figura6);

        String buscarCirculosRojos = "SELECT * FROM FIGURA WHERE(TYPE = 'CIRCULO' AND COLOR='ROJO')";
        ResultSet circulosRojos = stmt.executeQuery(buscarCirculosRojos);
        int contador = 1;
        while (circulosRojos.next()) {
            System.out.println("Circulo rojo nro: " + contador);
            contador++;
        }

        String sql = "SELECT * FROM FIGURA";
        ResultSet rd = stmt.executeQuery(sql);

        while (rd.next()) {
            System.out.println(rd.getInt(1) + " " + rd.getString(2) + " " + rd.getString(3));
        }
    }
}
