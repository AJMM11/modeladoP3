package apartadoD.Roles;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import apartadoD.Donacion;
import apartadoD.RolesDisponibles;

public class Donante extends Rol{

    private List<Donacion> donaciones;
    private Socio socioRelacionado;

    public Donante(List<Donacion> donaciones, Socio socio) {
        super(RolesDisponibles.DONANTE);
        this.socioRelacionado = socio;

        if(donaciones == null || donaciones.isEmpty()){
            throw new IllegalArgumentException("La lista de donaciones no puede ser nula");
        }
        this.donaciones = donaciones;
        for(Donacion d : donaciones){
            if(d.getCantidad() > 0 || d!=null){
                socioRelacionado.getRefugio().anadirCantidad(d.getCantidad());
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
        socioRelacionado.getRefugio().anadirCantidad(c); // Sumo la liquidez al refugio
    }

}
