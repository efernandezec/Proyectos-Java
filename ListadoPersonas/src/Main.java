import clases.Consola;
import clases.CrudPersona;
import clases.ManejoArchivos;
import clases.Persona;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int AGREGAR = 1;
    private static final int EDITAR = 2;
    private static final int ELIMINAR = 3;
    private static final int LISTAR = 4;
    private static final int SALIR = 5;

    private static CrudPersona crudPersona = new CrudPersona();

    public static void main(String[] args) {
        Consola consola = new Consola();
        List<Persona> personas = new ArrayList<Persona>();
        boolean salir = false;
        int opcion;


            while (!salir){
                mostrarMenu();
                opcion = consola.entradaInt("Ingrese la opción a realizar : ");

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
            case AGREGAR -> agregar(consola);
            case EDITAR -> {

            }
            case ELIMINAR -> eliminar(consola);

            case LISTAR -> {
                crudPersona.getAllPersona();
            }
        }
    }

    private static void agregar(Consola consola){
        consola.limpiarBuffer();
        String nombre = consola.entradaString("nombre");
        String apellido = consola.entradaString("apellido");
        String telefono = consola.entradaString("teléfono");
        String email = consola.entradaString("email");

        crudPersona.addPersona(nombre, apellido, telefono, email);
    }

    private static  void eliminar(Consola consola){
        crudPersona.getAllPersona();
        int idPersona = consola.entradaInt("Digite el número de la persona que desea eliminar: ");
        crudPersona.deletePersona(idPersona);
    }

}