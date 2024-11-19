package apartadoA;

import java.util.Date;

public class Animal {

    private Date nacimiento;
    private EstadoAnimal estado;
    private Adopcion adopcion;

    public Animal(Date nacimiento, EstadoAnimal estado, Adopcion adopcion) {
        this.nacimiento = nacimiento;
        this.estado = estado;
        this.adopcion = adopcion;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public EstadoAnimal getEstado() {
        return estado;
    }

    public void setEstado(EstadoAnimal estado) {
        this.estado = estado;
    }

    public Adopcion getAdopcion() {
        return adopcion;
    }

    public void setAdopcion(Adopcion adopcion) {
        this.adopcion = adopcion;
    }
    
}
