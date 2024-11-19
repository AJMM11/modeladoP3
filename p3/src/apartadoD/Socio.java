import java.util.Date;
import java.util.Enumeration;
import java.util.List;

public class Socio implements Voluntario, Donante, Adoptante{

    private Date registro;
    private Refugio refugio;

    private List<Adopcion> tramites; //VOLUNTARIO

    private List<Donacion> donaciones; //DONANTE

    private List<Adopcion> adopciones; //ADOPTANTE


    public Socio(Date registro, Refugio refugio,
    List<Adopcion> tramites, List<Donacion> donaciones, List<Adopcion> adopciones) {
        this.registro = registro;
        this.refugio = refugio;
        this.tramites = tramites;
        this.donaciones = donaciones;
        this.adopciones = adopciones;
    }

    //VOLUNTARIO
    public void tramitarAdopcion(Animal a, Adoptante ad){
        a.setEstado(EstadoAnimal.adoptado); // Cambio el estado del animal a adoptado
        Adopcion adopcion = new Adopcion(new Date(), ad, a); // Creo una nueva adopcion
        a.setAdopcion(adopcion); // Asigno la adopcion al animal
        tramites.add(adopcion); // Agrego la adopcion a la lista de tramites del voluntario
        ad.addAdopcion(adopcion);; // Agrego la adopcion a la lista de adopciones del adoptante
        this.getRefugio().eliminarAnimalRefugiado(a);; // Elimino al animal de la lista de animales refugiados
    }

    public void registrar(Animal a){ // Hacemos que el refugio registre al animal
        this.getRefugio().registrar(a);
    }


    //DONANTE
    public void donar(Double c){
        Donacion d = new Donacion(c, new Date()); //Creo una nueva donacion
        donaciones.add(d); // Agrego la donacion a la lista de donaciones
        this.getRefugio().anadirCantidad(c); // Sumo la liquidez al refugio
    }


    //ADOPTANTE
    public void addAdopcion(Adopcion a){
        this.adopciones.add(a);
    }

    public void adoptar(Animal a, Voluntario v){
        v.tramitarAdopcion(a, this); // Mando al voluntario a tramitar la adopcion
    }


    // GETTERS Y SETTERS
    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    public Refugio getRefugio() {
        return refugio;
    }

    public void setRefugio(Refugio refugio) {
        this.refugio = refugio;
    }
    
    public Enumeration<Adopcion> getTramites() {
        return (Enumeration<Adopcion>) tramites;
    }

    public Enumeration<Donacion> getDonaciones() {
        return (Enumeration<Donacion>) donaciones;
    }

    public Enumeration<Adopcion> getAdopciones() {
        return (Enumeration<Adopcion>) adopciones;
    }
}
