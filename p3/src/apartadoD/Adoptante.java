import java.util.Enumeration;
import java.util.List;

public class Adoptante {

    private List<Adopcion> adopciones;


    public Adoptante(List<Adopcion> adopciones) {
        this.adopciones = adopciones;
    }

    public Enumeration<Adopcion> getAdopciones() {
        return (Enumeration<Adopcion>) adopciones;
    }

    public void addAdopcion(Adopcion a){
        this.adopciones.add(a);
    }

    //Operacion adoptar
    public void adoptar(Animal a, Voluntario v){
        v.tramitarAdopcion(a, this); // Mando al voluntario a tramitar la adopcion
    }
}
