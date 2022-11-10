package presencial;

public class FacadeDescuento implements Descuento{
    // atributos de nuestras APIs
    private ApiProducto apiProducto;
    private ApiTarjeta apiTarjeta;
    private ApiCantidad apiCantidad;

    public FacadeDescuento(){
        apiTarjeta= new ApiTarjeta();
        apiProducto= new ApiProducto();
        apiCantidad= new ApiCantidad();
    }

    @Override
    public int descuento(Tarjeta tarj, Producto prod, int cant) {
        int elDescuento=0;
        // resolver el problema
        elDescuento+=apiProducto.descuentoXProducto(prod);
        elDescuento+=apiTarjeta.descuentoXTarjeta(tarj);
        elDescuento+=apiCantidad.descuentoXCantidad(cant);
        return elDescuento;
    }
}
