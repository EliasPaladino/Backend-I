public class ServicioDescargaProxy implements Servicio {
    private ServicioDescarga servicio;

    @Override
    public String descargar(Usuario usuario) {
        String mensaje = "El usuario no es premium, no puede descargar";
        if(usuario.getTipoUsuario().equals("Premium")){
            servicio = new ServicioDescarga();
            mensaje = servicio.descargar(usuario);
        }
        return mensaje;
    }
}
