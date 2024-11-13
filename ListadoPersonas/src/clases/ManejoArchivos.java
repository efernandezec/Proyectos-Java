package clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ManejoArchivos {
    public static <T> void writeFile(String path, T objeto ){
        String rutaActual = System.getProperty("user.dir");
        try{
            File file = new File(rutaActual + "/src/archivos/" + path);

            /** if(file.exists()){
                System.out.print("El archivo ya existe");
            } **/
            FileWriter writer = new FileWriter(file, true);
            System.out.println("Elemento registrado con éxito : " + objeto);

            writer.write(objeto.toString());
            writer.write("\n");
            writer.close();
        }
        catch (IOException e){
            System.out.println("Ocurrió un error");
            e.printStackTrace();
        }
    }
}
