import java.util.Enumeration;

public interface Adoptante{

    public Enumeration<Adopcion> getAdopciones();

    public void addAdopcion(Adopcion a);

    //Operacion adoptar
    public void adoptar(Animal a, Voluntario v); // Mando al voluntario a tramitar la adopcion

}
