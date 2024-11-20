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
}