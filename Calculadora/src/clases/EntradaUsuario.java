    package clases;

    import java.util.Scanner;

    public class EntradaUsuario {
        int operando = 0;
        Scanner teclado;
        public EntradaUsuario(){
            teclado = new Scanner(System.in);
        }
        public  double solicitarOperando(){
            operando++;
            System.out.print("Proporciona el valor del operando " + operando + ": ");
            return teclado.nextDouble();
        }
    }
