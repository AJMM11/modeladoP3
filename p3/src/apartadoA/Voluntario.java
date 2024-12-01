package apartadoA;

import java.util.Date;
import java.util.Enumeration;
import java.util.List;

public class Voluntario extends Socio {

    private List<Adopcion> tramites;

    public Voluntario(Date registro, Refugio refugio, List<Adopcion> tramites) {
        super(registro, refugio);
        this.tramites = tramites;
    }

    public Enumeration<Adopcion> getTramites() {
        return (Enumeration<Adopcion>) tramites;
    }

    //Operacion tramitarAdopcion
    public void tramitarAdopcion(Animal animal, Adoptante adoptante) {
        if (animal.getEstado() != EstadoAnimal.disponible) {
            throw new IllegalArgumentException("El animal no está disponible para adopción.");
        }
        animal.setEstado(EstadoAnimal.adoptado);
        Adopcion adopcion = new Adopcion(new Date(), adoptante, animal);
        adoptante.addAdopcion(adopcion);
        tramites.add(adopcion);
        this.getRefugio().eliminarAnimalRefugiado(animal);
    }

    //Operacion registrar
    public void registrar(Animal a){ // Hacemos que el refugio registre al animal
        this.getRefugio().registrarAnimal(a);
    }
    
}
