package apartadoD.Roles;

import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import apartadoD.Donacion;

public class Donante {

    private List<Donacion> donaciones;
    private Socio socio;

    public Donante(List<Donacion> donaciones, Socio socio) {
        if(donaciones == null || donaciones.isEmpty()){
            throw new IllegalArgumentException("La lista de donaciones no puede ser nula");
        }
        if(socio == null){
            throw new IllegalArgumentException("Debe estar asociado a un socio");
        }
        this.donaciones = donaciones;
        this.socio = socio;
        for(Donacion d : donaciones){
            if(d.getCantidad() > 0 || d!=null){
                socio.getRefugio().anadirCantidad(d.getCantidad());
            }
        }
    }

    public Enumeration<Donacion> getDonaciones() {
        return java.util.Collections.enumeration(donaciones);
    }

    //Operacion donar
    public void donar(Double c){
        Donacion d = new Donacion(c, new Date()); //Creo una nueva donacion
        donaciones.add(d); // Agrego la donacion a la lista de donaciones
        socio.getRefugio().anadirCantidad(c); // Sumo la liquidez al refugio
    }

}
