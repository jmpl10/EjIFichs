import java.io.File;

/**
 * @author Victor Enzian
 */
public class EsperaLlegadaFichero {
    public static void main(String[] args) throws InterruptedException {
        File origen = new File("Origen");
        File copia = new File("Copia");

        if (!origen.exists())
            origen.mkdir();
        if (!copia.exists())
            copia.mkdir();
        while(true){
            File [] ficheros = origen.listFiles();
            if (ficheros != null && ficheros.length > 0){
                for (int i = 0; i < ficheros.length; i++){
                    Thread.sleep(2000);
                    File fichero = ficheros[i];
                    if (fichero.isFile()){
                        System.out.println("Se ha encontrado el fichero: "+ fichero.getName());
                        File fichAux = new File(copia, fichero.getName());
                        if (fichero.renameTo(fichAux)){
                            System.out.println("Fichero copiado en carpeta copia");
                        }else {
                            System.out.println("No se ha podido copiar el fichero");
                        }
                    }
                }
            }
        }
    }
}
