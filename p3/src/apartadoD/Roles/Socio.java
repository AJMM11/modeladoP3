package apartadoD.Roles;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import apartadoD.Refugio;
import apartadoD.RolesDisponibles;

import java.util.HashMap;
import java.util.List;

public class Socio {

    private Date registro;
    private Refugio refugio;
    private Map<Class<?>, Object> roles = new HashMap<>(); // Mapa de roles, evita duplicidad (un socio no puede ser 2 veces el mismo rol)

    public Socio(Date registro, Refugio refugio) {
        if (refugio == null) {
            throw new IllegalArgumentException("Todo socio debe pertenecer a un refugio");
        }
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
            System.err.println("La clase recibida no es un rol asignable");
        }
    }

    // Elimina el rol del socio
    public void removeRol(Object rol) {
        roles.remove(rol.getClass());
    }

    // Devuelve la instancia del rol solicitado, excepción si no tiene ese rol
    public Object getRolInstance(RolesDisponibles rol) {
        Object claseRol = roles.get(rol.getClaseRol());
        if(claseRol == null)
            throw new IllegalArgumentException("El socio no tiene un rol del tipo: " + rol.getClaseRol().getSimpleName());
        return claseRol;
    }

    // Devuelve el nombre de los roles asignados al socio
    public Enumeration<RolesDisponibles> getRoles() {
        List<RolesDisponibles> listaRoles = new ArrayList<>();
        for(Class<?> rol : roles.keySet()) {
            listaRoles.add(RolesDisponibles.getNombreRol(rol));
        }
        return java.util.Collections.enumeration(listaRoles);
    }

    // Devuelve el nombre de los roles asignables
    public static void showAsignableRoles() {
        for (RolesDisponibles r : RolesDisponibles.values()) {
            System.out.println(r.getClaseRol().getSimpleName());
        }
    }

}
