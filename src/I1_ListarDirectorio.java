import java.io.File;
import java.util.Scanner;

public class I1_ListarDirectorio {

    int listarFicheros(File dir) {
        File[] ficheros = dir.listFiles();
        int tamanoTotal=0;
        if (ficheros != null) {
            for (int i = 0; i < ficheros.length; i++) {
                File fichero = ficheros[i];
                if (fichero.isDirectory()) {
                    tamanoTotal+=listarFicheros(fichero);
                } else {
                    tamanoTotal+=fichero.length();
                    System.out.println("Nombre: " + fichero.getAbsolutePath() + " | Tamaño: " + fichero.length() + " bytes");
                }
            }
        }
        return tamanoTotal;
    }
    long getTotalSize(File dir) {
        long totalSize = 0;
        File[] ficheros = dir.listFiles();
        if (ficheros != null) {
            for (int i = 0; i < ficheros.length; i++) {
                File fichero = ficheros[i];
                if (fichero.isDirectory()) {
                    totalSize += getTotalSize(fichero);
                } else {
                    totalSize += fichero.length();
                }
            }
        }
        return totalSize;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del directorio: ");
        String directorioPath = scanner.nextLine();

        I1_ListarDirectorio f = new I1_ListarDirectorio();

        File directorio = new File(directorioPath);
        long tamañoTotal=0;
        if (directorio.exists() && directorio.isDirectory()) {
           tamañoTotal=  f.listarFicheros(directorio);
        } else {
            System.out.println("El directorio no existe o no es un directorio válido.");
        }
        // tamañoTotal = f.getTotalSize(directorio);
        System.out.println("Tamaño total del directorio: " + tamañoTotal + " bytes");

        scanner.close();
    }
}