public class Usuario {
    private int id;
    private String tipoUsuario;

    public Usuario(int id, String tipoUsuario) {
        this.id = id;
        this.tipoUsuario = tipoUsuario;
    }

    public int getId() {
        return id;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }
}
