package apartadoD.Roles;
import java.util.Enumeration;
import java.util.List;

import apartadoD.Adopcion;
import apartadoD.Animal;
import apartadoD.RolesDisponibles;

public class Adoptante extends Rol{

    private List<Adopcion> adopciones;
    private Socio socioRelacionado;


    public Adoptante(List<Adopcion> adopciones, Socio socio) {
        super(RolesDisponibles.ADOPTANTE);
        this.adopciones = adopciones;
        this.socioRelacionado = socio;
    }

    public Enumeration<Adopcion> getAdopciones() {
        return (Enumeration<Adopcion>) java.util.Collections.enumeration(adopciones);
    }

    public void addAdopcion(Adopcion a){
        this.adopciones.add(a);
    }

    //Operacion adoptar
    public void adoptar(Animal a, Voluntario v){
        v.tramitarAdopcion(a, this); // Mando al voluntario a tramitar la adopcion
    }
}
