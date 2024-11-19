package apartadoA;

import java.util.Date;
import java.util.Enumeration;
import java.util.List;

public class Adoptante extends Socio{

    private List<Adopcion> adopciones;


    public Adoptante(Date registro, Refugio refugio ,List<Adopcion> adopciones) {
        super(registro, refugio);
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
