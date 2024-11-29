package apartadoD;
import Roles.Adoptante;
import Roles.Donante;
import Roles.Voluntario;

public enum RolesDisponibles {
    ADOPTANTE(Adoptante.class),
    DONANTE(Donante.class),
    VOLUNTARIO(Voluntario.class);

    private final Class<?> claseRol;

    RolesDisponibles(Class<?> claseRol) {
        this.claseRol = claseRol;
    }

    public Class<?> getClaseRol() {
        return claseRol;
    }

    public static RolesDisponibles getNombreRol(Class<?> claseRol) {
        for (RolesDisponibles r : RolesDisponibles.values()) {
            if (r.getClaseRol().equals(claseRol)) {
                return r;
            }
        }
        return null;
    }
}
