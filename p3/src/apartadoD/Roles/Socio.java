package apartadoD.Roles;

import apartadoD.Refugio;
import apartadoD.RolesDisponibles;

import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.HashMap;

public class Socio {

    private Date registro;
    private Refugio refugio;
    private Map<RolesDisponibles, Rol> roles = new HashMap<>(); // Mapa de roles, evita duplicidad (un socio no puede ser 2 veces el mismo rol)

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

    // Añade la instancia de rol al socio. Si ya tiene un rol del mismo tipo, no lo añade
    public void addRol(Rol nuevoRol) {
        if (roles.containsKey(nuevoRol.rol)) {
            System.err.println("El socio ya tiene un rol del tipo: " + nuevoRol.rol);
        }
        else{
            roles.put(nuevoRol.rol, nuevoRol);
        }
    }

    // Elimina el rol del socio
    public void removeRol(Rol eliminarRol) {
        roles.remove(eliminarRol.rol);
    }

    // Devuelve la instancia del rol solicitado, excepción si no tiene ese rol
    public Object getRolInstance(RolesDisponibles rol) throws Exception {
        Object claseRol = roles.get(rol);
        if(claseRol == null)
            throw new IllegalArgumentException("El socio no tiene un rol del tipo: " + rol);
        return claseRol;
    }

    // Devuelve el nombre de los roles asignados al socio
    public Enumeration<RolesDisponibles> getRolesNames() {
        return Collections.enumeration(roles.keySet());
    }

    // Devuelve el nombre de los roles asignables
    public static void showAsignableRoles() {
        for (RolesDisponibles rol : RolesDisponibles.values()) {
            System.out.println(rol);
        }
    }

}
