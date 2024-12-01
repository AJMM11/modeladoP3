package apartadoA;

import java.util.Enumeration;
import java.util.List;

public class Refugio {

    private Double liquidez;
    private List<Animal> animalesRefugiados;
    private List<Animal> animalesRegistrados;

    public Refugio(Double liquidez, List<Animal> animalesRefugiados, List<Animal> animalesRegistrados) {
        this.liquidez = liquidez;
        this.animalesRefugiados = animalesRefugiados;
        this.animalesRegistrados = animalesRegistrados;
    }

    public double getLiquidez() {
        return liquidez;
    }

    public void setLiquidez(Double liquidez) {
        this.liquidez = liquidez;
    }

    public Enumeration<Animal> getAnimalesRefugiados() {
        return (Enumeration<Animal>) animalesRefugiados;
    }

    public Enumeration<Animal> getAnimalesRegistrados() {
        return (Enumeration<Animal>) animalesRegistrados;
    }

    public void anadirCantidad(Double c){
        this.liquidez += c;
    }

    
    //Operacion registrarAnimal
    // Pasamos el estado a disponible, y lo registramos
    public void registrarAnimal(Animal animal) {
        if (animal.getEstado() != EstadoAnimal.disponible) {
            animal.setEstado(EstadoAnimal.disponible);
        }
        animalesRegistrados.add(animal);
        animalesRefugiados.add(animal);
    }

    public void eliminarAnimalRefugiado(Animal animal) {
        if (!animalesRefugiados.remove(animal)) {
            throw new IllegalStateException("El animal no está en la lista de refugiados.");
        }
    }

}
