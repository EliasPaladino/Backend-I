import java.io.Serializable;

public class Contacto implements Serializable {
    private String nombre;
    private String mail;
    private String tel;

    public Contacto(String nombre, String mail, String tel) {
        this.nombre = nombre;
        this.mail = mail;
        this.tel = tel;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMail() {
        return mail;
    }

    public String getTel() {
        return tel;
    }

    @Override
    public String toString() {
        return "Contacto " +
                "\n   nombre = " + nombre + "\n" +
                "   mail = " + mail + "\n" +
                "   tel = " + tel + "\n";
    }
}
