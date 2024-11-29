package apartadoD.Roles;
import java.util.Enumeration;
import java.util.List;

import apartadoD.Adopcion;
import apartadoD.Animal;

public class Adoptante {

    private List<Adopcion> adopciones;
    private Socio socio;

    public Adoptante(List<Adopcion> adopciones, Socio socio) {
        if(socio == null){
            throw new IllegalArgumentException("Debe estar asociado a un socio");
        }
        this.adopciones = adopciones;
        this.socio = socio;
    }

    public Enumeration<Adopcion> getAdopciones() {
        return (Enumeration<Adopcion>) java.util.Collections.enumeration(adopciones);
    }

    public void addAdopcion(Adopcion a){
        this.adopciones.add(a);
    }

    //Operacion adoptar
    public void adoptar(Animal a, Voluntario v){
        if (a == null || v == null) {
            throw new IllegalArgumentException("Animal o Voluntario no puede ser null");
        }
        v.tramitarAdopcion(a, this); // Mando al voluntario a tramitar la adopcion
    }
}
