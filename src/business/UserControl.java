package business;

import data.UserDAO;
import entities.Users;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class UserControl {
    private final UserDAO DATOS;
    private Users obj;
    private DefaultTableModel modeloTabla;
    
    
    public UserControl() {
        DATOS = new UserDAO();
        obj = new Users();
    }
    
    public DefaultTableModel listar(String texto) {
        List<Users> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        //Rotulos de la tabla JTable
        String[] titulos = {"ID", "Nombre", "Autor", "Editorial", "Año", "Paginas", "Imagen", "Habilitado", "Disponible", "Categoría"};
        String estado;
        String[] registro = new String[11];
        //Agregar los titulos al modelo
        modeloTabla = new DefaultTableModel(null,titulos);
        //Recorrer la lista de libros
        /*for(Users item:lista){
            //Verificar si esta activo o inactivo
            if (item){
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            //Llenar el regustro
            registro[0] = Integer.toString(item.getIdCategoria());
            registro[1] = item.getNombreCategoria();
            registro[2] = item.getDescripcionCategoria();
            registro[3] = item.getObservaciones();
            registro[4] = estado;
            
            //Agregar en registro al modelo
            modeloTabla.addRow(registro);
        }*/
        return modeloTabla;
    }
    
    public String login(String user, String pass) { 
        obj.setUsuario(user);
        obj.setPassword(pass);
        
        if (DATOS.login(obj)){
            return "OK";
        } else {
            return "Las credenciales no coinciden";
        }
    }
    
}
