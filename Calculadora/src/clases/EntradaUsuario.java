    package clases;

    import java.util.ArrayList;
    import java.util.InputMismatchException;
    import java.util.List;
    import java.util.Scanner;

    public class EntradaUsuario {
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

        public double entradaDouble(String... mensajes){
            double numero;
            String mensajeTry = mensajes.length > 0 ? mensajes[0] : null;
            while (true){
                try {
                    if(mensajeTry != null && !mensajeTry.isEmpty()){
                        System.out.print(mensajeTry);
                    }
                    numero = teclado.nextDouble();
                    break;
                }
                catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Ingrese un número");
                    teclado.next();
                }
            }
            return numero;
        }

        public boolean entradaBooleana(String texto){
            String input;

            do {
                System.out.print(texto + "  Solo se acepta (Y/N) :");
                input = teclado.next().trim().toUpperCase();
            } while (!input.equals("Y") && !input.equals("N"));

            return input.equals("Y");
        }

        public List<Double> entradaOperandos(){
            int operando = 1;
            List<Double> operandos = new ArrayList<Double>();
            boolean isNewOperando;
            do {
                String mensaje= "Proporciona el valor del operando " + operando + ": ";
                double numero = this.entradaDouble(mensaje);
                operandos.add(numero);
                operando++;
                isNewOperando = this.entradaBooleana("¿Desea añadir otro operando?");
            }while (isNewOperando);

            return operandos;
        }
    }
