package apartadoA;

import java.util.Date;

public class Donacion {

    private Double cantidad;
    private Date fecha;

    public Donacion(Double cantidad, Date fecha) {
        if(cantidad <= 0 || cantidad == null){
            throw new IllegalArgumentException("La cantidad a donar no puede ser nula o negativa");
        }
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
