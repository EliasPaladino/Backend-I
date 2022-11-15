import java.sql.*;

public class Test {

    private static final String CREATE_TABLE_SQL = "DROP TABLE IF EXITS PACIENTE; CREATE TABLE PACIENTE"
                + "("
                + " ID INT PRIMARY KEY, "
                + " NAME VARCHAR(255), "
                + " LAST_NAME VARCHAR(255), "
                + " ADDRESS VARCHAR(255), "
                + " USER VARCHAR(255), "
                + " PASSWORD VARCHAR(255) "
                + ")";

    private static final String INSERT_SQL = "INSERT INTO PACIENTE (ID, NAME, LAST_NAME, ADDRESS, USER, PASSWORD) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE PACIENTE SET PASSWORD = ? WHERE USER = ?";

    public static void main(String[] args) throws Exception {
        Paciente paciente = new Paciente("Elias", "Paladino", "Calle falsa 123", "Paladain", "123");

        Connection connection = null;

        try {
            connection = getConnection();
            connection.setAutoCommit(false);

            Statement stmt = connection.createStatement();
            stmt.execute(CREATE_TABLE_SQL);

            PreparedStatement psInsert = connection.prepareStatement(INSERT_SQL);

            psInsert.setInt(1,1);
            psInsert.setString(2, paciente.getName());
            psInsert.setString(3, paciente.getLastName());
            psInsert.setString(4, paciente.getAdress());
            psInsert.setString(5, paciente.getUser());
            psInsert.setString(6, paciente.getPassword());

            connection.commit();

        } catch (Exception e) {
            if(connection != null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                }
            }
        } finally {

        }

    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:" + "./Database/my", "sa", "");
    }
}
