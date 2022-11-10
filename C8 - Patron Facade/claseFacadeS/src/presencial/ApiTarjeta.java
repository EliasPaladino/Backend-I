package presencial;

public class ApiTarjeta {
    public int descuentoXTarjeta(Tarjeta tarj){
        int resp=0;
        if (tarj.getBanco().equals("Star Bank")){
            resp=20;
        }
        return resp;
    }
}
