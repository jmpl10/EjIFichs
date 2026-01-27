import java.io.File;
import java.io.IOException;

public class CrearEstructuraDeFicheros {
    public static void main(String[] args) {
        File dir1 = new File("dir1");
        if (dir1.exists()) {
            System.out.println("dir1 ya existe");
        } else {
            if (dir1.mkdir()) {
                System.out.println("dir1 creado");
            } else {
                System.out.println("No se pudo crear dir1");
            }
        }

        File f1 = new File(dir1, "f1.txt");
        if (f1.exists()) {
            System.out.println("f1.txt ya existe");
        } else {
            try {
                f1.createNewFile();
                System.out.println("f1.txt creado");
            } catch (IOException e) {
                System.out.println("No se pudo crear f1");
            }
        }

        File f2 = new File(dir1, "f2.txt");
        if (f2.exists()) {
            System.out.println("f2.txt ya existe");
        } else {
            try {
                f2.createNewFile();
                System.out.println("f2.txt creado");
            } catch (IOException e) {
                System.out.println("No se pudo crear f2");
            }
        }

        File dir1a = new File(dir1, "dir1a");
        if (dir1a.exists()) {
            System.out.println("dir1a ya existe");
        } else {
            if (dir1a.mkdir()) {
                System.out.println("dir1a creado");
            } else {
                System.out.println("No se pudo crear dir1a");
            }
        }

        File f1a = new File(dir1a, "f1a.txt");
        if (f1a.exists()) {
            System.out.println("f1a.txt ya existe");
        } else {
            try {
                f1a.createNewFile();
                System.out.println("f1a.txt creado");
            } catch (IOException e) {
                System.out.println("No se pudo crear f1a");
            }
        }

        File f2a = new File(dir1a, "f2a.txt");
        if (f2a.exists()) {
            System.out.println("f2a.txt ya existe");
        } else {
            try {
                f2a.createNewFile();
                System.out.println("f2a.txt creado");
            } catch (IOException e) {
                System.out.println("No se pudo crear f2a");
            }
        }
    }
}
