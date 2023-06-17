package entities;

public class DetallePrestamo {
    private int idDetallePrestamo;
    private int idPrestamo;
    private int idLibro;
    private String nombreLibro;
    private int libroStock;
    private int cantidad;
    
    public DetallePrestamo() {}

    public DetallePrestamo(int idDetallePrestamo, int idPrestamo, int idLibro, String nombreLibro, int libroStock, int cantidad) {
        this.idDetallePrestamo = idDetallePrestamo;
        this.idPrestamo = idPrestamo;
        this.idLibro = idLibro;
        this.nombreLibro = nombreLibro;
        this.libroStock = libroStock;
        this.cantidad = cantidad;
    }

    public DetallePrestamo(int idLibro, int cantidad) {
        this.idLibro = idLibro;
        this.cantidad = cantidad;
    }

    public int getIdDetallePrestamo() {
        return idDetallePrestamo;
    }

    public void setIdDetallePrestamo(int idDetallePrestamo) {
        this.idDetallePrestamo = idDetallePrestamo;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
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

    public int getLibroStock() {
        return libroStock;
    }

    public void setLibroStock(int libroStock) {
        this.libroStock = libroStock;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetallePrestamo{" + "idDetallePrestamo=" + idDetallePrestamo + ", idPrestamo=" + idPrestamo + ", idLibro=" + idLibro + ", nombreLibro=" + nombreLibro + ", libroStock=" + libroStock + ", cantidad=" + cantidad + '}';
    }
}
