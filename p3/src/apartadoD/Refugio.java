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

    public List<Animal> getAnimalesRefugiados() {
        return (List<Animal>) animalesRefugiados;
    }

    public List<Animal> getAnimalesRegistrados() {
        return (List<Animal>) animalesRegistrados;
    }

    public void anadirCantidad(Double c){
        this.liquidez += c;
    }

    public void eliminarAnimalRefugiado(Animal a){
        animalesRefugiados.remove(a);
    }
    
    //Operacion registrar animal
    public void registrar(Animal a){ // Pasamos el estado a disponible, y lo registramos
        a.setEstado(EstadoAnimal.disponible);
        animalesRegistrados.add(a);
        animalesRefugiados.add(a);
    }

}
