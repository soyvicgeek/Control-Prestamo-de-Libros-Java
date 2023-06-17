package data.interfaces;

import java.util.List;

public interface CrudPrestamosInterface<T> {
    public List<T> listar(String texto);
    public boolean insertar(T obj);
    public boolean actualizar(T obj);
    public boolean devolver(int id);
    public int total();
    public boolean existe(String texto);
}
