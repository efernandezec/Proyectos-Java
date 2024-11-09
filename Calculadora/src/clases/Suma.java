package clases;

import java.util.List;

public class Suma {
    private Suma(){}
    /**
     * Realiza la suma de dos parámetros
     * @return La suma de ambos operandos
     **/

    /** Al ser un metodo estatico no se requiere instanciar la clase **/
    public static double sumar(List<Double> operandos){
        double suma = 0;
        for(double operando : operandos){
            suma+=operando;
        }
        return suma;
    }
}
