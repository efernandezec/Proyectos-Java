package clases;

public class Suma {
    public Suma(){}

    /**
     * Realiza la suma de dos parámetros
     * @param operando1 Primer número
     * @param operando2 Segundo número
     * @return La suma de ambos operandos
     **/

    /** Al ser un metodo estatico no se requiere instanciar la clase **/
    public static double sumar(double ...operandos){
        double suma = 0;
        for(double operando : operandos){
            suma+=operando;
        }
        return suma;
    }
}
