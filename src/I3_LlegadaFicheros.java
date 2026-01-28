import java.io.File;
/**
 * @author Daniel Gaitan
 */
public class I3_LlegadaFicheros {
    public static void main(String[] args) throws InterruptedException {
        File origen = new File("Origen");
        File copia = new File("Copia");
        origen.mkdir();
        copia.mkdir();
        System.out.println("Vigilando el directorio Origen...");
        while (true){
            File[] archivos = origen.listFiles();
            if (archivos != null){
                for (int i=0; i< archivos.length; i++){
                    File f =archivos[i];
                    if (f.isFile()) {
                        System.out.println("Detectado fichero: " + f.getName());
                        File destino = new File(copia, f.getName());
                        if (destino.exists())
                            destino.delete();
                        boolean movido = f.renameTo(destino);
                        if (!movido){
                            System.out.println(f.getName() + "no se pudo mover");
                        }
                    }
                }
            }
            Thread.sleep(2000);
        }
    }
}
