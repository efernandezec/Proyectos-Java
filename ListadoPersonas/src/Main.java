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
            case EDITAR -> editar(consola);
            case ELIMINAR -> eliminar(consola);
            case LISTAR -> crudPersona.getAllPersona();
        }
    }

    private static void agregar(Consola consola){
        consola.limpiarBuffer();
        String nombre = consola.entradaString("Proporcione el nombre : ");
        String apellido = consola.entradaString("Proporcione el apellido : ");
        String telefono = consola.entradaString("Proporcione el teléfono : ");
        String email = consola.entradaString("Proporcione el email : ");

        crudPersona.addPersona(nombre, apellido, telefono, email);
    }

    private static  void eliminar(Consola consola){
        crudPersona.getAllPersona();
        int idPersona = consola.entradaInt("Digite el número de la persona que desea eliminar: ");
        crudPersona.deletePersona(idPersona);
    }

    private static void editar(Consola consola){
        String newNombre = null, newApellido = null, newEmail = null, newTelefono = null;
        boolean existenPersonas = crudPersona.getAllPersona();
        if(existenPersonas){
            int idPersona = consola.entradaInt("Digite el número de la persona que desea editar: ");
            Persona persona = crudPersona.getPersona(idPersona);
            if(persona != null){
                System.out.println("Datos actuales de la persona :");
                System.out.println("Nombre : " + persona.getNombre());
                System.out.println("Apellido : " + persona.getApellido());
                System.out.println("Email : " + persona.getEmail());
                System.out.println("Teléfono : " + persona.getTelefono());

                consola.limpiarBuffer();
                boolean isNewNombre = consola.entradaBoolean("¿Desea modificar el nombre de la persona? ");
                if(isNewNombre){
                    newNombre = consola.entradaString("Digite el nuevo nombre de la persona : ");
                }

                boolean isNewApellido = consola.entradaBoolean("¿Desea modificar el apellido de la persona? ");
                if(isNewApellido){
                    newApellido = consola.entradaString("Digite el nuevo apellido de la persona :");
                }

                boolean isNewEmail = consola.entradaBoolean("¿Desea modificar el email de la persona? :");
                if(isNewEmail){
                    newEmail = consola.entradaString("Digite el nuevo nombre de la persona :");
                }

                boolean isNewTelefono = consola.entradaBoolean("¿Desea modificar el teléfono de la persona? : ");
                if(isNewTelefono){
                    newTelefono = consola.entradaString("Digite el nuevo nombre de la persona :");
                }
                crudPersona.updatePersona(idPersona, newNombre, newApellido, newEmail, newTelefono);
            }

        }

    }

}