import java.util.Date;

public class Empleado {

    private Long id;
    private String name;
    private int age;
    private String company;
    private Date admissionDate;


    public Empleado(String name, int age, Date admissionDate, String company) {
        this.name = name;
        this.age = age;
        this.admissionDate = admissionDate;
        this.company = company;
    }
}
