package apartadoD.Roles;
import java.util.Enumeration;
import java.util.List;

import apartadoD.Adopcion;
import apartadoD.Animal;

public class Adoptante {

    private List<Adopcion> adopciones;


    public Adoptante(List<Adopcion> adopciones) {
        this.adopciones = adopciones;
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
