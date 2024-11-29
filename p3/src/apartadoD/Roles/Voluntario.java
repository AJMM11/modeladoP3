package apartadoD.Roles;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import apartadoD.Adopcion;
import apartadoD.Animal;
import apartadoD.EstadoAnimal;

public class Voluntario {

    private List<Adopcion> tramites;
    private Socio socio;

    public Voluntario(List<Adopcion> tramites, Socio socio) {
        if(socio == null){
            throw new IllegalArgumentException("Debe estar asociado a un socio");
        }
        this.tramites = tramites;
        this.socio = socio;
    }

    public Enumeration<Adopcion> getTramites() {
        return java.util.Collections.enumeration(tramites);
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
        socio.getRefugio().eliminarAnimalRefugiado(a);; // Elimino al animal de la lista de animales refugiados
    }

    //Operacion registrar
    public void registrar(Animal a){ // Hacemos que el refugio registre al animal
        socio.getRefugio().registrar(a);
    }

}
