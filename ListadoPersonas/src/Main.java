import clases.Consola;
import clases.ManejoArchivos;
import clases.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int AGREGAR = 1;
    private static final int EDITAR = 2;
    private static final int ELIMINAR = 3;
    private static final int LISTAR = 4;
    private static final int SALIR = 5;

    public static void main(String[] args) {
        Consola consola = new Consola();
        List<Persona> personas = new ArrayList<Persona>();
        boolean salir = false;
        int opcion;


            while (!salir){
                mostrarMenu();
                opcion = consola.entradaInt();

                if(opcion >= 1 && opcion <= 4){
                    operacionesListado(opcion, consola, personas);
                } else if (opcion == SALIR) {
                    System.out.println("Hasta pronto...");
                    salir = true;
                }
                else{
                    System.out.println("La opción " + opcion + " no es válida");
                }

            }

    }

    public static void mostrarMenu(){
        System.out.println("*** Listado de Personas APP ***");
        System.out.print("""
                1.Agregar
                2.Editar
                3.Eliminar
                4.Listar
                5.Salir
                """);
    }

    public static void operacionesListado(int opcion, Consola consola, List<Persona> personas){
        switch (opcion){
            case AGREGAR -> {
                addPersona(consola, personas);
            }
            case EDITAR -> {

            }
            case ELIMINAR -> {

            }
            case LISTAR -> {
                listarPersonas(personas);
            }
        }
    }

    public static void addPersona(Consola consola, List<Persona> personas){
        consola.limpiarBuffer();
        String nombre = consola.entradaString("nombre");
        String apellido = consola.entradaString("apellido");
        String telefono = consola.entradaString("teléfono");
        String email = consola.entradaString("email");

        Persona newPersona = new Persona(nombre, apellido, telefono, email);
        personas.add(newPersona);

        ManejoArchivos.writeFile("bd.txt", newPersona);

//        System.out.println("Se ha agregado con éxito a " + newPersona);
//        System.out.println("En total hay " + personas.size() + " personas en el listado");
    }

    public static void listarPersonas(List<Persona> personas){
        if(!personas.isEmpty()) {
            personas.forEach(((persona) -> {
                System.out.println(persona.getId() + "." + persona);
            }));
        }
        else {
            System.out.println("No hay personas en el listado");
        }
    }
}