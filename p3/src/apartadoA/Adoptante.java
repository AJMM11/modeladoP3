package apartadoA;

import java.util.Date;
import java.util.List;

public class Adoptante extends Socio{

    private List<Adopcion> adopciones;

    public Adoptante(Date registro, Refugio refugio ,List<Adopcion> adopciones) {
        super(registro, refugio);
        this.adopciones = adopciones;
    }

    public List<Adopcion> getAdopciones() {
        return adopciones;
    }

    public void addAdopcion(Adopcion a){
        this.adopciones.add(a);
    }

    //Operacion adoptar
    public void adoptar(Animal animal, Voluntario voluntario){
        if (animal.getEstado() != EstadoAnimal.disponible) {
            throw new IllegalArgumentException("El animal no está disponible para adopción.");
        }
        voluntario.tramitarAdopcion(animal, this); // Mando al voluntario a tramitar la adopcion
    }
}
