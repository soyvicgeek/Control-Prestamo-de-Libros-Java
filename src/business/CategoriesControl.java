package business;

import data.CategoryDAO;
import entities.Categories;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CategoriesControl {
    private final CategoryDAO DATOS;
    private Categories obj;
    private DefaultTableModel modeloTabla;
    private int registrosMostrados;
    
    public CategoriesControl() {
        DATOS = new CategoryDAO();
        obj = new Categories();
        registrosMostrados = 0;
    }
    
    public DefaultTableModel listar(String texto) {
        List<Categories> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        //Rotulos de la tabla JTable
        String[] titulos = {"ID", "Nombre Categoría", "Imagen", "Descripción", "Habilitado"};
        String habilitado;
        String[] registro = new String[5];
        //Agregar los titulos al modelo
        modeloTabla = new DefaultTableModel(null,titulos);
        registrosMostrados = 0;
        //Recorrer la lista de libros
        for(Categories item:lista){
            registrosMostrados++;
            
            if (item.isHabilitado()){
                habilitado = "Activo";
            } else {
                habilitado = "Desactivado";
            }
            
            //Llenar el registro
            registro[0] = Integer.toString(item.getIdCategoria());
            registro[1] = item.getNombreCategoria();
            registro[2] = item.getImagenCategoria();
            registro[3] = item.getDescripcionCategoria();
            registro[4] = habilitado;
            
            //Agregar en registro al modelo
            modeloTabla.addRow(registro);
        }
        return modeloTabla;
    }
    
    public String activar(int id) {
        if (DATOS.activar(id)){
            return "OK";
        } else {
            return "No se puede activar el registro";
        }
    }
    
    public String desactivar(int id) {
        if (DATOS.desactivar(id)){
            return "OK";
        } else {
            return "No se puede desactivar el registro";
        }
    }
    
    public int total() {
        return DATOS.total();
    }
    
    //Regresa el total de registros mostrados
    public int totalMostrados() {
        return registrosMostrados;
    }
}
