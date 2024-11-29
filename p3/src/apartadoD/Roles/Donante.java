package apartadoD.Roles;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import apartadoD.Donacion;
import apartadoD.Refugio;

public class Donante {

    private List<Donacion> donaciones;
    private Socio socioRelacionado;

    public Donante(Date registro, Refugio refugio, List<Donacion> donaciones) {
        this.donaciones = donaciones;
    }

    public Enumeration<Donacion> getDonaciones() {
        return (Enumeration<Donacion>) donaciones;
    }

    //Operacion donar
    public void donar(Double c){
        Donacion d = new Donacion(c, new Date()); //Creo una nueva donacion
        donaciones.add(d); // Agrego la donacion a la lista de donaciones
        socioRelacionado.getRefugio().anadirCantidad(c); // Sumo la liquidez al refugio
    }

}
