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

    public String entradaString(String campo){
        String entrada;
        while (true){
            System.out.print("Proporcione el " + campo + ": ");
            entrada = consola.nextLine();
            if(!entrada.isEmpty()){
                break;
            }
            System.out.println("El " + campo + " no puede estar vacio.");
        }
        return entrada;

    }

    public void limpiarBuffer(){
        if(consola.hasNextLine()){
            consola.nextLine();
        }
    }
}
