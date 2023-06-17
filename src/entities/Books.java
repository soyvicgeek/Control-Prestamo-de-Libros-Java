package entities;

import java.util.Objects;

public class Books {
    private int idLibro;
    private String nombreLibro;
    private String autorLibro;
    private String editorialLibro;
    private int anioLibro;
    private int paginasLibro;
    private String imagenLibro;
    private int stock;
    private boolean habilitado;
    private int disponible;
    private int idCategoria;
    private String nombreCategoria;

    public Books(int idLibro, String nombreLibro) {
        this.idLibro = idLibro;
        this.nombreLibro = nombreLibro;
    }
    
    public Books(int idLibro, String nombreLibro, String autorLibro, String editorialLibro, int anioLibro, int paginasLibro, String imagenLibro, boolean habilitado, int disponible, int idCategoria, String nombreCategoria) {
        this.idLibro = idLibro;
        this.nombreLibro = nombreLibro;
        this.autorLibro = autorLibro;
        this.editorialLibro = editorialLibro;
        this.anioLibro = anioLibro;
        this.paginasLibro = paginasLibro;
        this.imagenLibro = imagenLibro;
        this.habilitado = habilitado;
        this.disponible = disponible;
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public Books(int idLibro, String nombreLibro, int stock) {
        this.idLibro = idLibro;
        this.nombreLibro = nombreLibro;
        this.stock = stock;
    }
    
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public Books(){
    
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }

    public String getEditorialLibro() {
        return editorialLibro;
    }

    public void setEditorialLibro(String editorialLibro) {
        this.editorialLibro = editorialLibro;
    }

    public int getAnioLibro() {
        return anioLibro;
    }

    public void setAnioLibro(int anioLibro) {
        this.anioLibro = anioLibro;
    }

    public int getPaginasLibro() {
        return paginasLibro;
    }

    public void setPaginasLibro(int paginasLibro) {
        this.paginasLibro = paginasLibro;
    }

    public String getImagenLibro() {
        return imagenLibro;
    }

    public void setImagenLibro(String imagenLibro) {
        this.imagenLibro = imagenLibro;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public String getNombreCategoria() {
        return nombreCategoria;
    }
    
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    @Override
    public String toString() {
        return nombreLibro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.idLibro;
        hash = 73 * hash + Objects.hashCode(this.nombreLibro);
        hash = 73 * hash + Objects.hashCode(this.autorLibro);
        hash = 73 * hash + Objects.hashCode(this.editorialLibro);
        hash = 73 * hash + this.anioLibro;
        hash = 73 * hash + this.paginasLibro;
        hash = 73 * hash + Objects.hashCode(this.imagenLibro);
        hash = 73 * hash + (this.habilitado ? 1 : 0);
        hash = 73 * hash + this.disponible;
        hash = 73 * hash + this.idCategoria;
        hash = 73 * hash + Objects.hashCode(this.nombreCategoria);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Books other = (Books) obj;
        if (this.idLibro != other.idLibro) {
            return false;
        }
        if (!Objects.equals(this.nombreLibro, other.nombreLibro)) {
            return false;
        }
        if (!Objects.equals(this.autorLibro, other.autorLibro)) {
            return false;
        }
        if (!Objects.equals(this.editorialLibro, other.editorialLibro)) {
            return false;
        }
        if (this.anioLibro != other.anioLibro) {
            return false;
        }
        if (this.paginasLibro != other.paginasLibro) {
            return false;
        }
        if (!Objects.equals(this.imagenLibro, other.imagenLibro)) {
            return false;
        }
        if (this.habilitado != other.habilitado) {
            return false;
        }
        if (this.disponible != other.disponible) {
            return false;
        }
        if (this.idCategoria != other.idCategoria) {
            return false;
        }
        if (!Objects.equals(this.nombreCategoria, other.nombreCategoria)) {
            return false;
        }
        return true;
    }
}
