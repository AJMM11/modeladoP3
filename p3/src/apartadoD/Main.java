package apartadoD;

import java.util.Date;

import apartadoD.Roles.*;

public class Main {
    public static void main(String[] args) {
        // Creamos un refugio
        Refugio refugio = new Refugio(100.0, null, null);

        // Creamos un adoptante
        Adoptante adoptante = new Adoptante(null);

        // Creamos un voluntario
        Voluntario voluntario = new Voluntario(null);

        // Creamos un socio con el rol de adoptante
        Socio socioAd = new Socio(new Date(), refugio);
        socioAd.addRol(adoptante);

        // Creamos un socio con el rol de voluntario
        Socio socioVol = new Socio(new Date(), refugio);
        socioVol.addRol(voluntario);

        // Create a new animal
        Animal animal = new Animal("Animal", "Animal description", "Animal breed", "Animal color");
    }
}
