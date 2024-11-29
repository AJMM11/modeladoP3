package apartadoD.Roles;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import apartadoD.Adopcion;
import apartadoD.Animal;
import apartadoD.EstadoAnimal;
import apartadoD.Refugio;

public class Voluntario {

    private List<Adopcion> tramites;

    public Voluntario(List<Adopcion> tramites) {
        this.tramites = tramites;
    }

    public Enumeration<Adopcion> getTramites() {
        return java.util.Collections.enumeration(tramites);
    }

    //Operacion tramitarAdopcion
    public void tramitarAdopcion(Animal a, Adoptante ad){
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
