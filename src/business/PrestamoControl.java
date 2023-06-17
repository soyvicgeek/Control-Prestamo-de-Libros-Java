package business;

import data.BookDAO;
import data.PrestamosDAO;
import data.UserDAO;
import entities.Books;
import entities.DetallePrestamo;
import entities.Prestamos;
import entities.Users;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class PrestamoControl {
    private final PrestamosDAO DATOS;
    private final UserDAO DATOSUSR;
    private final BookDAO DATOSBOOK;
    private Prestamos obj;
    private DefaultTableModel modeloTabla;
    private int registrosMostrados;
    
    public PrestamoControl() {
        DATOS = new PrestamosDAO();
        DATOSUSR = new UserDAO();
        DATOSBOOK = new BookDAO();
        obj = new Prestamos();
        registrosMostrados = 0;
    }
    
    public DefaultTableModel listar(String texto) {
        List<Prestamos> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        //Rotulos de la tabla JTable
        String[] titulos = {"ID", "ID Usuario", "Nombre Usuario", "Total Prestamo", "Fecha Prestamo", "Fecha Devolución", "Estado"};
        String[] registro = new String[7];
        //Agregar los titulos al modelo
        modeloTabla = new DefaultTableModel(null,titulos);
        registrosMostrados = 0;
        //Formato a fechas
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Recorrer la lista de libros
        for(Prestamos item:lista){
            registrosMostrados++;
            
            //Llenar el registro
            registro[0] = Integer.toString(item.getIdPrestamo());
            registro[1] = Integer.toString(item.getIdUsuario());
            registro[2] = item.getNombreUsuario();
            registro[3] = Integer.toString(item.getTotalLibros());
            registro[4] = item.getFechaPrestamo();
            registro[5] = item.getFechaDevolucion();
            registro[6] = item.getEstado();

            //Agregar en registro al modelo
            modeloTabla.addRow(registro);
        }
        return modeloTabla;
    }
    
    public DefaultComboBoxModel seleccionarUsuarios() {
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Users> lista = new ArrayList();
        
        lista = DATOSUSR.listarUsuarios();
        for (Users item: lista) {
            items.addElement(new Users(item.getIdUsuario(), item.getNombre()));
        }
        return items;
    }
    
    public String insertar(int idUsuario, int totalLibros, String fechaPrestamo, String fechaDevolucion, DefaultTableModel detalles){
        
        obj.setIdUsuario(idUsuario);
        obj.setTotalLibros(totalLibros);
        obj.setFechaPrestamo(fechaPrestamo);
        obj.setFechaDevolucion(fechaDevolucion);
        
        //Recorrer los detalles
        List<DetallePrestamo> detallePrestamo = new ArrayList();
        int idL;
        int cantidad;
        //llenar lista
        for(int i=0; i<detalles.getRowCount(); i++){
            idL = Integer.parseInt(detalles.getValueAt(i, 0).toString());
            cantidad = Integer.parseInt(detalles.getValueAt(i, 2).toString());
            detallePrestamo.add(new DetallePrestamo(idL,cantidad));
        }
        obj.setDetalles(detallePrestamo);

        //Llisto para insertar en la BD
        if (DATOS.insertar(obj)){
            return "OK";
        } else {
            return "Error en la inserción del registro";
        }
    }
    
    public Books obtenerLibro(int ID) {
        Books lib = null;  
        lib = DATOSBOOK.obtenerLibro(ID);
        
        return lib;
    }
    
    
    public String devolver(int id) {
        if (DATOS.devolver(id)){
            return "OK";
        } else {
            return "No se puede devolver el libro";
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
