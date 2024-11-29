package apartadoD;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import apartadoD.Roles.*;

public class Main {
    public static void main(String[] args) {
        try{

            //Creamos el refugio
            Refugio refugio = new Refugio(5000.0, new ArrayList<>(), new ArrayList<>());
    
            //Creamos los animales y los registramos
            Animal perroMax = new Animal(new Date(), EstadoAnimal.disponible, null);
            Animal perroRex = new Animal(new Date(), EstadoAnimal.disponible, null);
            Animal gataLuna = new Animal(new Date(), EstadoAnimal.disponible, null);
            Animal gataKitty = new Animal(new Date(), EstadoAnimal.disponible, null);
    
            // Asociamos los nombres a los animales en un Map, para poder mostrarlos con el nombre
            Map<String, Animal> animalesConNombres = new HashMap<>();
            animalesConNombres.put("perroMax", perroMax);
            animalesConNombres.put("perroRex", perroRex);
            animalesConNombres.put("gataLuna", gataLuna);
            animalesConNombres.put("gataKitty", gataKitty);
    
            refugio.registrar(perroMax);
            refugio.registrar(perroRex);
    
            //Creamos los socios
            Socio Antonio = new Socio(new Date(), refugio);
            Socio Maribel = new Socio(new Date(), refugio);
            Socio Juan = new Socio(new Date(), refugio);
            
            //Creamos los roles (donante Juan debe tener 1 donacion para crearlo)
            Antonio.addRol(new Voluntario(new ArrayList<>(), Antonio));
            Maribel.addRol(new Adoptante(new ArrayList<>(), Maribel));
            List<Donacion> donacionesJuan = new ArrayList<>();
            donacionesJuan.add(new Donacion(100.0, new Date()));
            Juan.addRol(new Donante(donacionesJuan, Juan));
            
            // Antonio registra a los otros dos animales mediante su rol Voluntario
            ((Voluntario) Antonio.getRolInstance(RolesDisponibles.VOLUNTARIO)).registrar(gataLuna);
            ((Voluntario) Antonio.getRolInstance(RolesDisponibles.VOLUNTARIO)).registrar(gataKitty);
    
    
            System.out.println("Los animales registrados son:");
            refugio.getAnimalesRegistrados().asIterator().forEachRemaining(animal -> 
                System.out.println("- " + animalesConNombres.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(animal)).map(Map.Entry::getKey).findFirst().orElse("Animal sin nombre")));
    
            System.out.println("Los animales refugiados son:");
            refugio.getAnimalesRefugiados().asIterator().forEachRemaining(animal -> 
                System.out.println("- " + animalesConNombres.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(animal)).map(Map.Entry::getKey).findFirst().orElse("Animal sin nombre")));
    
            //Juan dona 1000 euros con su rol Donante
            System.out.println("El refugio tiene una liquidez de: " + refugio.getLiquidez());
            System.out.println("Juan dona 1000 euros");
            ((Donante) Juan.getRolInstance(RolesDisponibles.DONANTE)).donar(1000.0);
            System.out.println("El refugio tiene una liquidez de: " + refugio.getLiquidez());
    
            //Maribel adopta a perroMax
            ((Adoptante) Maribel.getRolInstance(RolesDisponibles.ADOPTANTE)).adoptar(perroMax, (Voluntario) Antonio.getRolInstance(RolesDisponibles.VOLUNTARIO));
    
            System.out.println("Maribel adopta a perroMax, ahora los animales refugiados son:");
            refugio.getAnimalesRefugiados().asIterator().forEachRemaining(animal -> 
                System.out.println("- " + animalesConNombres.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(animal)).map(Map.Entry::getKey).findFirst().orElse("Animal sin nombre")));
    
            System.out.println("Y los animales adoptados por Maribel son:");
            ((Adoptante) Maribel.getRolInstance(RolesDisponibles.ADOPTANTE)).getAdopciones().asIterator().forEachRemaining(adopcion -> 
                System.out.println("- " + animalesConNombres.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(adopcion.getAnimal())).map(Map.Entry::getKey).findFirst().orElse("Animal sin nombre")));
            
            // Maribel adopta a gataLuna
            ((Adoptante) Maribel.getRolInstance(RolesDisponibles.ADOPTANTE)).adoptar(gataLuna, (Voluntario) Antonio.getRolInstance(RolesDisponibles.VOLUNTARIO));
    
            System.out.println("Maribel adopta a gataLuna, ahora los animales refugiados son:");
            refugio.getAnimalesRefugiados().asIterator().forEachRemaining(animal -> 
                System.out.println("- " + animalesConNombres.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(animal)).map(Map.Entry::getKey).findFirst().orElse("Animal sin nombre")));
    
            System.out.println("Y los animales adoptados por Maribel son:");
            ((Adoptante) Maribel.getRolInstance(RolesDisponibles.ADOPTANTE)).getAdopciones().asIterator().forEachRemaining(adopcion -> 
                System.out.println("- " + animalesConNombres.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(adopcion.getAnimal())).map(Map.Entry::getKey).findFirst().orElse("Animal sin nombre")));
    
            System.out.println("Y los animales cuya adopción ha sido gestionada por Antonio son:");
            ((Voluntario) Antonio.getRolInstance(RolesDisponibles.VOLUNTARIO)).getTramites().asIterator().forEachRemaining(adopcion -> 
                System.out.println("- " + animalesConNombres.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(adopcion.getAnimal())).map(Map.Entry::getKey).findFirst().orElse("Animal sin nombre")));
    
    
            System.out.println("Pero los animales registrados en el refugio siguen siendo:");
            refugio.getAnimalesRegistrados().asIterator().forEachRemaining(animal -> 
                System.out.println("- " + animalesConNombres.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(animal)).map(Map.Entry::getKey).findFirst().orElse("Animal sin nombre")));
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}
