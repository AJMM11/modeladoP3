import java.util.Enumeration;

public interface Voluntario {

    public Enumeration<Adopcion> getTramites();

    //Operacion tramitarAdopcion
    public void tramitarAdopcion(Animal a, Adoptante ad);

    //Operacion registrar
    public void registrar(Animal a);
    
}
