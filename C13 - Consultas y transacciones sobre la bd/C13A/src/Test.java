public class Test {

    private static final String CREATE_TABLE_SQL = "DROP TABLE IF EXITS PACIENTE; CREATE TABLE PACIENTE"
                + "("
                + " ID INT PRIMARY KEY, "
                + " NAME VARCHAR(255), "
                + " LAST_NAME VARCHAR(255), "
                + " ADRESS VARCHAR(255), "
                + " USER VARCHAR(255), "
                + " PASSWORD VARCHAR(255) "
                + ")";

    private static final String INSERT_SQL = "INSERT INTO PACIENTE VALUES(?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE PASSWORD = ? WHERE USER = ?";

    public static void main(String[] args) {


    }
}
