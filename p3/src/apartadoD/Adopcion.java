import java.util.Date;

public class Adopcion {

    private Date fecha;
    private Adoptante adoptante;
    private Animal animal;

    public Adopcion(Date fecha, Adoptante adoptante, Animal animal) {
        this.fecha = fecha;
        this.adoptante = adoptante;
        this.animal = animal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(Adoptante adoptante) {
        this.adoptante = adoptante;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
}
