    package clases;

    import java.util.ArrayList;
    import java.util.InputMismatchException;
    import java.util.List;
    import java.util.Scanner;

    public class EntradaUsuario {
        int operando = 1;
        Scanner teclado;

        public EntradaUsuario(){
            teclado = new Scanner(System.in);
        }

        public int entradaInt(){
            int numero;
            while (true){
                try {
                    numero = teclado.nextInt();
                    break;
                }
                catch (InputMismatchException e){
                    System.out.println("Entrada inválida. Ingrese un número");
                    teclado.next();
                }
            }
            return numero;
        }

        public  double operando(){
            double numero;
            while (true){
                System.out.print("Proporciona el valor del operando " + operando + ": ");
                try {
                    numero = teclado.nextDouble();
                    break;
                }
                catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Ingrese un número para el operando " + operando);
                    teclado.next();
                }
            };
            operando++;
            return numero;
        }

        public boolean entradaBooleana(String texto){
            String input;

            do {
                System.out.print(texto + "Solo se acepta (Y/N) :");
                input = teclado.next().trim().toUpperCase();
            } while (!input.equals("Y") && !input.equals("N"));

            return input.equals("Y");
        }

        public List<Double> entradaOperandos(){
            List<Double> operandos = new ArrayList<Double>();
            boolean isNewOperando;
            do {
                operandos.add(this.operando());
                isNewOperando = this.entradaBooleana("¿Desea añadir otro operando?");
            }while (isNewOperando);

            operando = 0;

            return operandos;
        }
    }
