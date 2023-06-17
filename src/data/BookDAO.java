package data;

import data.interfaces.CrudBookInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import entities.Books;
import database.Conexion;

public class BookDAO implements CrudBookInterface<Books>{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public BookDAO() {
        CON = new Conexion("biblioteca", "root", "123", "jdbc:mysql://localhost:3306/");
    }
    
    @Override
    public List<Books> listar(String texto) {
        List<Books> registros = new ArrayList();
        String sql;
        try{
            sql="SELECT L.idLibro, L.nombreLibro, L.autorLibro, L.editorialLibro, L.anioLibro, L.paginasLibro, L.imagenLibro, L.habilitado, L.disponible, C.idCategoria, C.nombreCategoria\n" +
                "FROM libros L, categoriaslibros C\n" +
                "WHERE L.idCategoria = C.idCategoria\n" +
                "AND L.nombreLibro LIKE ? ORDER BY L.idLibro";
            ps=CON.conectar().prepareStatement(sql);
            ps.setString(1, "%"+texto+"%");
            
            rs=ps.executeQuery();
            while(rs.next()) {
                registros.add(new Books(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8), rs.getInt(9), rs.getInt(10), rs.getString(11)));
            }
            ps.close();
            rs.close();
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }
    
    public List<Books> listarLibros() {
        List<Books> registros = new ArrayList();
        String sql;
        try{
            sql="SELECT idLibro, nombreLibro FROM libros WHERE habilitado = 1 order by nombreLibro asc";
            ps=CON.conectar().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                registros.add(new Books(rs.getInt(1),rs.getString(2)));
            }
            ps.close();
            rs.close();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Books obj) {
        String sql;
        resp=false;
        try{
            sql="INSERT INTO libros (nombreLibro, autorLibro, editorialLibro, anioLibro, paginasLibro, imagenLibro, disponible, idCategoria) VALUES (?,?,?,?,?,?,?,?)";
            ps=CON.conectar().prepareStatement(sql);
            
            //Pasar los valores a la consulta sql
            ps.setString(1, obj.getNombreLibro());
            ps.setString(2, obj.getAutorLibro());
            ps.setString(3, obj.getEditorialLibro());
            ps.setInt(4, obj.getAnioLibro());
            ps.setInt(5, obj.getPaginasLibro());
            ps.setString(6, obj.getImagenLibro());
            ps.setInt(7, obj.getDisponible());
            ps.setInt(8, obj.getIdCategoria());
            
            //Verificar si se inserto el registro
            if (ps.executeUpdate() > 0){
                resp = true;
            }
            
            ps.close();
        }catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null, e.getMessage());
                }
        finally
        {
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Books obj) {
        String sql;
        resp=false;
        try{
            sql="UPDATE libros SET nombreLibro = ?, autorLibro = ?, editorialLibro = ?, anioLibro = ?, paginasLibro = ?, imagenLibro = ?, disponible = ?, idCategoria = ? WHERE idLibro = ?";
            ps=CON.conectar().prepareStatement(sql);
            
            //Pasar los valores a la consulta sql
            ps.setString(1, obj.getNombreLibro());
            ps.setString(2, obj.getAutorLibro());
            ps.setString(3, obj.getEditorialLibro());
            ps.setInt(4, obj.getAnioLibro());
            ps.setInt(5, obj.getPaginasLibro());
            ps.setString(6, obj.getImagenLibro());
            ps.setInt(7, obj.getDisponible());
            ps.setInt(8, obj.getIdCategoria());
            ps.setInt(9, obj.getIdLibro());
            
            //Verificar si se inserto el registro
            if (ps.executeUpdate() > 0){
                resp = true;
            }
            
            ps.close();
        }catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null, e.getMessage());
                }
        finally
        {
            ps=null;
            CON.desconectar();
        }
        return resp;
    }
    
    //Método que regrese los datos de un producto
    public Books obtenerLibro(int libroID) {
        Books lib = null;      
        String sql;
        try{
            sql="Select idLibro, nombreLibro, stock FROM libros WHERE idLibro = ?";
            ps=CON.conectar().prepareStatement(sql);
            ps.setInt(1, libroID);
            
            rs=ps.executeQuery();
            if(rs.next()) {
                lib = new Books(rs.getInt(1),rs.getString(2),rs.getInt(3));
            }
            ps.close();
            rs.close();
        }catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null, e.getMessage());
                }
        finally
        {
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return lib;
    }

    @Override
    public boolean desactivar(int id) {
        String sql;
        resp=false;
        try{
            sql="UPDATE libros SET habilitado = 0 WHERE idLibro = ?";
            ps=CON.conectar().prepareStatement(sql);
            
            //Pasar los valores a la consulta sql
            ps.setInt(1,id);
            
            //Verificar si se inserto el registro
            if (ps.executeUpdate() > 0){
                resp = true;
            }
            ps.close();
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean activar(int id) {
        String sql;
        resp=false;
        try{
            sql="UPDATE libros SET habilitado = 1 WHERE idLibro = ?";
            ps=CON.conectar().prepareStatement(sql);
            
            //Pasar los valores a la consulta sql
            ps.setInt(1,id);
            
            //Verificar si se inserto el registro
            if (ps.executeUpdate() > 0){
                resp = true;
            }
            ps.close();
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public int total() {
        String sql;
        int totalRegistros=0;
        try {
            sql="SELECT COUNT(idLibro) as numRegistros FROM libros ";
            ps=CON.conectar().prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next())    
                totalRegistros=rs.getInt("numRegistros");
            
            ps.close();
        }catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null, e.getMessage());
                }
        finally
        {
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return totalRegistros;
    }

    @Override
    public boolean existe(String texto) {
        String sql;
        resp=false;
        try {
            sql="SELECT idLibro FROM libros WHERE nombreLibro = ?";
            
            ps = CON.conectar().prepareStatement(sql);
            
            ps.setString(1, texto);
            rs = ps.executeQuery();
            //rs.last();
            if(rs.next())
            {
                resp=true;
            }
        ps.close();
        rs.close();       
        }
        catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null, e.getMessage());
                }
        finally
        {
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return resp;
    }
    
}
