package apartadoA;

import java.util.Date;

public class Donacion {

    private Double cantidad;
    private Date fecha;

    public Donacion(Double cantidad, Date fecha) {
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
    
    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
