public class ServicioDescarga implements Servicio {

    @Override
    public String descargar(Usuario usuario) {
        System.out.println("Validando si el usuario puede descargar");
        return "El usuario " +usuario.getId()+ " puede descargar la canción";
    }
}
