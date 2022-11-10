package clase1_mesa;

public class Figura {

    private String nombre;
    private double area = 0.0;

    public Figura(String nombre, double area){
        this.nombre = nombre;
        this.area = area;
    }

    public String getNombre() {
        return nombre;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double calcularArea(double ladoORadio){
        return 0;
    }

    public void mostrarArea(){
        if(getArea() != 0){
            System.out.println("El area del " + getNombre() + " es " + getArea());
        } else {
            System.out.println("El valor del radio o lado debe ser mayor a cero");
        }
    }
}
