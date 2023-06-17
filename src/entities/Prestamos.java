package entities;

import java.util.Date;
import java.util.List;

public class Prestamos {
    private int idPrestamo;
    private int idUsuario;
    private String nombreUsuario;
    private int totalLibros;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private String estado;
    private List<DetallePrestamo>detalles;
    
    public Prestamos(){}

    public Prestamos(int idPrestamo, int idUsuario, String nombreUsuario, int totalLibros, String fechaPrestamo, String fechaDevolucion, String estado, List<DetallePrestamo> detalles) {
        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.totalLibros = totalLibros;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
        this.detalles = detalles;
    }
    
    public Prestamos(int idPrestamo, int idUsuario, String nombreUsuario, int totalLibros, String fechaPrestamo, String fechaDevolucion, String estado) {
        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.totalLibros = totalLibros;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getTotalLibros() {
        return totalLibros;
    }

    public void setTotalLibros(int totalLibros) {
        this.totalLibros = totalLibros;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public List<DetallePrestamo> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePrestamo> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Prestamos{" + "idPrestamo=" + idPrestamo + ", idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", totalLibros=" + totalLibros + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + ", estado=" + estado + '}';
    }
}
