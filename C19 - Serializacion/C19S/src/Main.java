import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Main {
    public static ArrayList<Contacto> crearContactos(){
        ArrayList<Contacto> listaContactos = new ArrayList<>();
        String nombre;
        String Mail;
        String tel;

        listaContactos.add(new Contacto("Elias", "elias@asdas", "123152"));
        listaContactos.add(new Contacto("Ana", "ana@asdas", "123451"));
        listaContactos.add(new Contacto("Ronald", "ronald@asdas", "231452"));
        listaContactos.add(new Contacto("Rodri", "rodri@asdas", "512351"));

        return listaContactos;
    }
    public static void main(String[] args) {
        List<Contacto> listaContactos = new ArrayList<>();

        listaContactos = crearContactos();

        //Guardar la colección en un archivo
        FileOutputStream fos= null;
        try{
            fos= new FileOutputStream("SalidaTexto.txt");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(listaContactos);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Recuperar la colección de un archivo a una colección en Java
        List<Contacto> contactosRecuperados= null;
        FileInputStream fosLectura= null;
        try{
            fosLectura= new FileInputStream("SalidaTexto.txt");
            ObjectInputStream ois= new ObjectInputStream(fosLectura);
            contactosRecuperados=(ArrayList)ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //mostrar la información de la recuperación desde el archivo por consola
        for (Contacto contacto:contactosRecuperados) {
            System.out.println(contacto);
        }
    }
}
