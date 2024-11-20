import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class Socio {

    private Date registro;
    private Refugio refugio;
    private Map<Class<?>, Object> roles = new HashMap<>(); // Mapa de roles, evita duplicidad (un socio no puede ser 2 veces el mismo rol) 

    public Socio(Date registro, Refugio refugio) {
        this.registro = registro;
        this.refugio = refugio;
    }

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

    public void addRol(Object rol) {
        if (roles.containsKey(rol.getClass())) {
            System.err.println("El socio ya tiene un rol del tipo: " + rol.getClass().getSimpleName());
        } else{
            for (RolesDisponibles r : RolesDisponibles.values()) {
                if (r.getClaseRol().equals(rol.getClass())) {           // Si la clase está en RolesDisponibles, la añadimos
                    roles.put(rol.getClass(), rol);
                    return;
                }
            }
            System.err.println("La clase recibida no es un rol disponible");
        }
    }

    public Object getRol(RolesDisponibles rol) {
        return roles.get(rol.getClaseRol());
    }
    
}
