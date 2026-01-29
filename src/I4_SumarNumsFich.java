import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * @author Daniel Gaitan
 */
public class I4_SumarNumsFich {
    void sumarFichero(String nombreFich) throws IOException {
        int suma = 0;
        try (BufferedReader br = new BufferedReader (new FileReader(nombreFich))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                try {
                    int num = Integer.parseInt(linea.trim());
                    suma += num;
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: dato no numérico en el fichero → \"" + linea + "\"");
                }
            }
            System.out.println("Suma total = " + suma);
        }
    }
    public static void main(String[] args) throws IOException {
        try {
            new I4_SumarNumsFich().sumarFichero("f1datos.txt");
        } catch (FileNotFoundException e) {
            System.out.println("No existe el fichero");
        }
    }
}