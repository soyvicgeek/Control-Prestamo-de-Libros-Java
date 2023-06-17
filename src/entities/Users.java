package entities;

import java.util.Objects;

public class Users {
    private int idUsuario;
    private String nombre;
    private String apePat;
    private String apeMat;
    private String usuario;
    private String password;
    private int habilitado;

    public Users(int idUsuario, String nombre) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
    }
    
    public Users(int idUsuario, String nombre, String apePat, String apeMat, String usuario, String password, int habilitado) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apePat = apePat;
        this.apeMat = apeMat;
        this.usuario = usuario;
        this.password = password;
        this.habilitado = habilitado;
    }
    
    public Users (){
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApePat() {
        return apePat;
    }

    public String getApeMat() {
        return apeMat;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApePat(String apePat) {
        this.apePat = apePat;
    }

    public void setApeMat(String apeMat) {
        this.apeMat = apeMat;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idUsuario;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + Objects.hashCode(this.apePat);
        hash = 23 * hash + Objects.hashCode(this.apeMat);
        hash = 23 * hash + Objects.hashCode(this.usuario);
        hash = 23 * hash + Objects.hashCode(this.password);
        hash = 23 * hash + this.habilitado;
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
        final Users other = (Users) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apePat, other.apePat)) {
            return false;
        }
        if (!Objects.equals(this.apeMat, other.apeMat)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (this.habilitado != other.habilitado) {
            return false;
        }
        return true;
    }
    
    
}
