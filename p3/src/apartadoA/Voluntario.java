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
        return (Enumeration<Adopcion>) java.util.Collections.enumeration(tramites);
    }

    //Operacion tramitarAdopcion
    public void tramitarAdopcion(Animal a, Adoptante ad){
        if(a == null || ad == null){
            throw new IllegalArgumentException("Animal o Adoptante no puede ser null");
        }
        a.setEstado(EstadoAnimal.adoptado); // Cambio el estado del animal a adoptado
        Adopcion adopcion = new Adopcion(new Date(), ad, a); // Creo una nueva adopcion
        a.setAdopcion(adopcion); // Asigno la adopcion al animal
        tramites.add(adopcion); // Agrego la adopcion a la lista de tramites del voluntario
        ad.addAdopcion(adopcion);; // Agrego la adopcion a la lista de adopciones del adoptante
        this.getRefugio().eliminarAnimalRefugiado(a);; // Elimino al animal de la lista de animales refugiados
    }

    //Operacion registrar
    public void registrar(Animal a){ // Hacemos que el refugio registre al animal
        this.getRefugio().registrar(a);
    }
    
}
