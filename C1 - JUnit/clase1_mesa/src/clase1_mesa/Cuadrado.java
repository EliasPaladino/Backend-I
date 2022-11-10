package clase1_mesa;

public class Cuadrado extends Figura {

    public Cuadrado(String nombre, double area) {
        super(nombre, area);
        nombre = "Cuadrado";
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public void setArea(double area) {
        super.setArea(area);
    }

    @Override
    public double calcularArea(double ladoORadio){
        return ladoORadio * ladoORadio;
    }

    @Override
    public void mostrarArea() {
        super.mostrarArea();
    }
}
