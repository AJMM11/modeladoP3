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

    public Double getLiquidez() {
        return liquidez;
    }

    public void setLiquidez(Double liquidez) {
        this.liquidez = liquidez;
    }

    public Enumeration<Animal> getAnimalesRefugiados() {
        return (Enumeration<Animal>) java.util.Collections.enumeration(animalesRefugiados);
    }

    public Enumeration<Animal> getAnimalesRegistrados() {
        return (Enumeration<Animal>) java.util.Collections.enumeration(animalesRegistrados);
    }

    public void anadirCantidad(Double c){
        this.liquidez += c;
    }

    public void eliminarAnimalRefugiado(Animal a){
        if (animalesRefugiados.contains(a)){
            animalesRefugiados.remove(a);
        }else{
            throw new IllegalArgumentException("El animal no se encuentra en la lista de animales refugiados");
        }
    }
    
    //Operacion registrar animal
    public void registrar(Animal a){ // Pasamos el estado a disponible, y lo registramos
        if (a == null) {
            throw new IllegalArgumentException("El animal no puede ser null");
        }
        a.setEstado(EstadoAnimal.disponible);
        animalesRegistrados.add(a);
        animalesRefugiados.add(a);
    }

}
