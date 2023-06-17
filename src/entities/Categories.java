package entities;

import java.util.Objects;

public class Categories {
    private int idCategoria;
    private String nombreCategoria;
    private String imagenCategoria;
    private String descripcionCategoria;
    private boolean habilitado;

    public Categories(int idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }
    
    public Categories(int idCategoria, String nombreCategoria, String imagenCategoria, String descripcionCategoria, boolean habilitado) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.imagenCategoria = imagenCategoria;
        this.descripcionCategoria = descripcionCategoria;
        this.habilitado = habilitado;
    }
    
    public Categories() {
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

    public String getImagenCategoria() {
        return imagenCategoria;
    }

    public void setImagenCategoria(String imagenCategoria) {
        this.imagenCategoria = imagenCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public String toString() {
        return nombreCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idCategoria;
        hash = 97 * hash + Objects.hashCode(this.nombreCategoria);
        hash = 97 * hash + Objects.hashCode(this.imagenCategoria);
        hash = 97 * hash + Objects.hashCode(this.descripcionCategoria);
        hash = 97 * hash + (this.habilitado ? 1 : 0);
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
        final Categories other = (Categories) obj;
        if (this.idCategoria != other.idCategoria) {
            return false;
        }
        if (!Objects.equals(this.nombreCategoria, other.nombreCategoria)) {
            return false;
        }
        if (!Objects.equals(this.imagenCategoria, other.imagenCategoria)) {
            return false;
        }
        if (!Objects.equals(this.descripcionCategoria, other.descripcionCategoria)) {
            return false;
        }
        if (this.habilitado != other.habilitado) {
            return false;
        }
        return true;
    }
    
    
}
