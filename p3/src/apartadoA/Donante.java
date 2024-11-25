package apartadoA;

import java.util.Date;
import java.util.Enumeration;
import java.util.List;

public class Donante extends Socio {

    private List<Donacion> donaciones;

    public Donante(Date registro, Refugio refugio, List<Donacion> donaciones) {
        super(registro, refugio);
        this.donaciones = donaciones;
    }

    public Enumeration<Donacion> getDonaciones() {
        return (Enumeration<Donacion>) donaciones;
    }

    //Operacion donar
    public void donar(Double c){
        Donacion d = new Donacion(c, new Date()); //Creo una nueva donacion
        donaciones.add(d); // Agrego la donacion a la lista de donaciones
        this.getRefugio().anadirCantidad(c); // Sumo la liquidez al refugio
    }

}
