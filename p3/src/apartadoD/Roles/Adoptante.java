package apartadoD.Roles;
import java.util.Enumeration;
import java.util.List;

import apartadoD.Adopcion;
import apartadoD.Animal;
import apartadoD.RolesDisponibles;

public class Adoptante extends Rol{

    private List<Adopcion> adopciones;

    public Adoptante(List<Adopcion> adopciones) {
        super(RolesDisponibles.ADOPTANTE);
        this.adopciones = adopciones;
    }

    public Enumeration<Adopcion> getAdopciones() {
        return java.util.Collections.enumeration(adopciones);
    }

    public void addAdopcion(Adopcion a){
        this.adopciones.add(a);
    }

    //Operacion adoptar
    public void adoptar(Animal a, Voluntario v){
        v.tramitarAdopcion(a, this); // Mando al voluntario a tramitar la adopcion
    }
}
