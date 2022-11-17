import java.sql.*;

public class Test {

    private static final String CREATE_TABLE_SQL = "DROP TABLE IF EXISTS PACIENTE; CREATE TABLE PACIENTE"
                + "("
                + " ID INT PRIMARY KEY, "
                + " NAME VARCHAR(255), "
                + " LASTNAME VARCHAR(255), "
                + " ADDRESS VARCHAR(255), "
                + " USERNAME VARCHAR(255), "
                + " PASSWORD VARCHAR(255) "
                + ")";

    private static final String INSERT_SQL = "INSERT INTO PACIENTE(ID, NAME, LASTNAME, ADDRESS, USERNAME, PASSWORD) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE PACIENTE SET PASSWORD = ? WHERE USERNAME = ?";

    public static void main(String[] args) throws Exception {
        Paciente paciente = new Paciente("Elias", "Paladino", "Calle falsa 123", "Paladain", "123");

        Connection connection = null;

        try {
            connection = getConnection();

            Statement stmt = connection.createStatement();
            stmt.execute(CREATE_TABLE_SQL);

            PreparedStatement psInsert = connection.prepareStatement(INSERT_SQL);

            psInsert.setInt(1,1);
            psInsert.setString(2, paciente.getName());
            psInsert.setString(3, paciente.getLastName());
            psInsert.setString(4, paciente.getAdress());
            psInsert.setString(5, paciente.getUser());
            psInsert.setString(6, paciente.getPassword());

            psInsert.executeUpdate();

            connection.setAutoCommit(false);

            PreparedStatement psUpdate = connection.prepareStatement(UPDATE_SQL);

            psUpdate.setString(1, "abc123");
            psUpdate.setString(2, paciente.getUser());

            psUpdate.executeUpdate();

            int a = 4/0;

            connection.commit();
            connection.setAutoCommit(true);

            String sql = "SELECT * FROM PACIENTE";
            //Statement stmt2 = connection.createStatement();
            ResultSet rd = stmt.executeQuery(sql);
            while (rd.next()){
                System.out.println(rd.getString(5) + " " + rd.getString(6));
            }

        } catch (Exception e) {
            if(connection != null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                }
            }
        } finally {
            connection.close();
        }

        Connection connection1 = getConnection();
        String sql = "SELECT * FROM PACIENTE";
        Statement stmt2 = connection1.createStatement();
        ResultSet rd = stmt2.executeQuery(sql);
        while (rd.next()){
            System.out.println(rd.getString(5) + " " + rd.getString(6));
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/pacientes", "sa", "");
    }
}
