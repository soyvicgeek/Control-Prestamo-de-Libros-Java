package data.interfaces;

import java.util.List;
import javax.swing.JComboBox;

public interface CrudCategoryInterface<T> {
    
    public List<T> listar(String texto);
    public boolean insertar(T obj);
    public boolean actualizar(T obj);
    public boolean desactivar(int id);
    public boolean activar(int id);
    public int total();
    public boolean existe(String texto);
    //public void rellenarCombox(JComboBox combo, String valor);
}
