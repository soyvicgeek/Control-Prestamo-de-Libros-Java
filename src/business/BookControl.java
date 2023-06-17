package business;

import data.BookDAO;
import data.CategoryDAO;
import entities.Books;
import entities.Categories;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class BookControl {
    private final BookDAO DATOS;
    private final CategoryDAO DATOSCAT;
    private Books obj;
    private DefaultTableModel modeloTabla;
    private int registrosMostrados;
    
    public BookControl() {
        DATOS = new BookDAO();
        DATOSCAT = new CategoryDAO();
        obj = new Books();
        registrosMostrados = 0;
    }
    
    public DefaultTableModel listar(String texto) {
        List<Books> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        //Rotulos de la tabla JTable
        String[] titulos = {"ID", "Nombre", "Autor", "Editorial", "Año", "Paginas", "Imagen", "Habilitado", "Disponibilidad", "Id Categoría", "Nombre Categoría"};
        String disponible;
        String habilitado;
        String[] registro = new String[11];
        //Agregar los titulos al modelo
        modeloTabla = new DefaultTableModel(null,titulos);
        registrosMostrados = 0;
        //Recorrer la lista de libros
        for(Books item:lista){
            registrosMostrados++;
            if (item.getDisponible() == 1){
                disponible = "Disponible";
            } else {
                disponible = "No Disponible";
            }
            
            if (item.isHabilitado()){
                habilitado = "Activo";
            } else {
                habilitado = "Desactivado";
            }
            
            //Llenar el registro
            registro[0] = Integer.toString(item.getIdLibro());
            registro[1] = item.getNombreLibro();
            registro[2] = item.getAutorLibro();
            registro[3] = item.getEditorialLibro();
            registro[4] = Integer.toString(item.getAnioLibro());
            registro[5] = Integer.toString(item.getPaginasLibro());
            registro[6] = item.getImagenLibro();
            registro[7] = habilitado;
            registro[8] = disponible;
            registro[9] = Integer.toString(item.getIdCategoria());
            registro[10] = item.getNombreCategoria();
            
            //Agregar en registro al modelo
            modeloTabla.addRow(registro);
        }
        return modeloTabla;
    }
    
    //Método para regresar  retornar los libros
    public DefaultComboBoxModel seleccionarCategorias() {
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Categories> lista = new ArrayList();
        
        lista = DATOSCAT.listarCategorias();
        for (Categories item: lista) {
            items.addElement(new Categories(item.getIdCategoria(), item.getNombreCategoria()));
        }
        return items;
    }
    
    public String insertar(String nombre, String autor, String editorial, int anio, int paginas, String img, int disponible, int categoria){
        //Verificar que no exista la categoria a insertar
        if(DATOS.existe(nombre)){
            return "El libro '"+ nombre +"' ya existe";
        } else {
            obj.setNombreLibro(nombre);
            obj.setAutorLibro(autor);
            obj.setEditorialLibro(editorial);
            obj.setAnioLibro(anio);
            obj.setPaginasLibro(paginas);
            obj.setImagenLibro(img);
            obj.setDisponible(disponible);
            obj.setIdCategoria(categoria);          
            
            //Llisto para insertar en la BD
            if (DATOS.insertar(obj)){
                return "OK";
            } else {
                return "Error en la inserción del registro";
            }
        }
    }
    
    public String actualizar(int id, String nombreLibro, String nombreLibroAnt, String autor, String editorial, int anio, int paginas, String img, int disponible, int categoria){
        
        if (nombreLibro.equals(nombreLibroAnt)) {
            
            obj.setIdLibro(id);
            obj.setNombreLibro(nombreLibro);
            obj.setAutorLibro(autor);
            obj.setEditorialLibro(editorial);
            obj.setAnioLibro(anio);
            obj.setPaginasLibro(paginas);
            obj.setImagenLibro(img);
            obj.setDisponible(disponible);
            obj.setIdCategoria(categoria);

            //3. Actualizar el registro
            if (DATOS.actualizar(obj)){
                return "OK";
            } else {
                return "Error en la actualización del registro";
            }
        } else {    
            if (DATOS.existe(nombreLibro)) {
                return "Elo libro " + nombreLibro +" ya existe.";
            } else {
                
                obj.setIdLibro(id);
                obj.setNombreLibro(nombreLibro);
                obj.setAutorLibro(autor);
                obj.setEditorialLibro(editorial);
                obj.setAnioLibro(anio);
                obj.setPaginasLibro(paginas);
                obj.setImagenLibro(img);
                obj.setDisponible(disponible);
                obj.setIdCategoria(categoria);
            
                if (DATOS.actualizar(obj)){
                    return "OK";
                } else {
                    return "Error en la actualización del registro";
                }
            }
        }
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
