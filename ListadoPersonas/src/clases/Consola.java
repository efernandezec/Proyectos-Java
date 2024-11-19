package clases;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Consola {
    Scanner consola;

    public Consola(){
        consola = new Scanner(System.in);
    }

    public int entradaInt(String texto){
        int entrada;

        while (true){
            try {
                if(texto != null){
                    System.out.print(texto);
                }
                entrada = consola.nextInt();
                break;
            }
            catch (InputMismatchException e){
                System.out.print("La opción ingresada es inválida. Ingrese un número");
                consola.next();
            }
        }
        return entrada;
    }
    public boolean entradaBoolean(String texto){
        String entrada;
        do {
            System.out.print(texto + " Solo se acepta (Y/N) :");
            entrada = consola.nextLine().toUpperCase().trim();
        }
        while (!entrada.equals("Y") && !entrada.equals("N"));

        return entrada.equals("Y");
    }

    public String entradaString(String texto){
        String entrada;
        while (true){
            System.out.print(texto);
            entrada = consola.nextLine();
            if(!entrada.isEmpty()){
                break;
            }
            System.out.println("El campo no puede estar vacio.");
        }
        return entrada;

    }

    public void limpiarBuffer(){
        if(consola.hasNextLine()){
            consola.nextLine();
        }
    }
}
