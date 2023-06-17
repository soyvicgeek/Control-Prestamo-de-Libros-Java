package data;

import data.interfaces.CrudCategoryInterface;
import database.Conexion;
import entities.Categories;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoryDAO implements CrudCategoryInterface<Categories>{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public CategoryDAO() {
        CON = new Conexion("biblioteca", "root", "123", "jdbc:mysql://localhost:3306/");
    }

    @Override
    public List<Categories> listar(String texto) {
        List<Categories> registros = new ArrayList();
        String sql;
        try{
            sql="SELECT * FROM categoriaslibros\n" +
                "WHERE nombreCategoria LIKE ?";
            ps=CON.conectar().prepareStatement(sql);
            ps.setString(1, "%"+texto+"%");
            
            rs=ps.executeQuery();
            while(rs.next()) {
                registros.add(new Categories(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBoolean(5)));
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
    
    public List<Categories> listarCategorias() {
        List<Categories> registros = new ArrayList();
        String sql;
        try{
            sql="SELECT idCategoria, nombreCategoria FROM categoriaslibros WHERE habilitado = 1 order by nombreCategoria asc";
            ps=CON.conectar().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                registros.add(new Categories(rs.getInt(1),rs.getString(2)));
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
    public boolean insertar(Categories obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Categories obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean desactivar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean activar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int total() {
        String sql;
        int totalRegistros=0;
        try {
            sql="SELECT COUNT(idCategoria) as numRegistros FROM categoriaslibros ";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*@Override
    public void rellenarCombox(JComboBox combo, String valor) {
        
        String sql;
        try {
            sql="SELECT * FROM categoriaslibros";
            ps=CON.conectar().prepareStatement(sql);
            rs=ps.executeQuery();
            
            while (rs.next()) {
                combo.addItem(rs.getString(valor));
            }
            
            ps.close();
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps=null;
            rs=null;
            CON.desconectar();
        }
    
    }*/
}
