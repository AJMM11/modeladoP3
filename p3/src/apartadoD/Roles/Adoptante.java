package apartadoD.Roles;
import java.util.Enumeration;
import java.util.List;

import apartadoD.Adopcion;
import apartadoD.Animal;
import apartadoD.EstadoAnimal;
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
        if (a == null || v == null) {
            throw new IllegalArgumentException("Animal o Voluntario no puede ser null");
        }else if(a.getEstado() != EstadoAnimal.disponible){
            throw new IllegalArgumentException("El animal no esta disponible para adoptar");
        }
            
        v.tramitarAdopcion(a, this); // Mando al voluntario a tramitar la adopcion

    }
}
