package dao;

public interface IDao<T> {

    void agregar(T t);
    T buscar(Long id);
    void eliminar(Long id);
    void modificar(T t);

}
