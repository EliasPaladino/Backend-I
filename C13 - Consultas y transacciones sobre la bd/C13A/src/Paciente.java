public class Paciente {

    private Long id;
    private String name;
    private String lastName;
    private String adress;
    private String user;
    private String password;

    public Paciente(String name, String lastName, String adress, String user, String password) {
        this.name = name;
        this.lastName = lastName;
        this.adress = adress;
        this.user = user;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAdress() {
        return adress;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
