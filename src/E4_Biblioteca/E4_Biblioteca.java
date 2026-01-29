package E4_Biblioteca;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class E4_Biblioteca {
    final static int LIBROS_MAXIMOS = 2000;
    final static int USUARIOS_MAXIMOS = 100;
    /**
     * El libro de código X puede estar en una posición distinta de X del array
     */
    private Libro[] libros;
    /**
     * El usuario de identificador X está en la posición  X deñ array
     */
    private Usuario[] usuarios;
    E4_Biblioteca (){
     libros= new Libro[LIBROS_MAXIMOS];
     usuarios= new Usuario[USUARIOS_MAXIMOS];
    }
    private int posicionLibreUsuarios() {
        int posicion = -1;
        for (int i = 0; i < usuarios.length && posicion == -1; i++) {
            if (usuarios[i] == null) posicion = i;
        }
        return posicion;
    }
    private void altaLibros() { // PRINCIPAL
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------");
        System.out.println("ALTA DE LIBRO");
        System.out.println("---------------------");

        if (Libro.librosMetidos < libros.length) {
            System.out.println("Introduce el título del libro");
            String titulo = sc.nextLine();
            libros[Libro.librosMetidos] = new Libro( titulo);
        } else {
            System.out.println("Se ha alcanzado el limite maximo de libros en esta biblioteca.");
        }
    }

    private void altaUsuario() { // PRINCIPAL
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------");
        System.out.println("ALTA DE USUARIO");
        System.out.println("---------------------");
        System.out.println("APORTA SU NOMBRE.");
        String nombre = sc.nextLine();
        int posicionLibre = posicionLibreUsuarios();
        if (posicionLibre != -1) {
            usuarios[posicionLibre] = new Usuario(nombre, posicionLibre);
        } else {
            System.out.println("Usuarios maximos alcanzados.");
        }
    }
    private void bajaUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------");
        System.out.println("BAJA DE USUARIO");
        System.out.println("---------------------");
        System.out.println("APORTA SU IDENTIFICADOR.");
        int id = sc.nextInt();
        if (id < usuarios.length && id >= 0) {
            if (usuarios[id] != null) {
                boolean estaVacio = true;
                for (int i = 0; i < usuarios[id].librosEnSuHaber.length && estaVacio; i++) {
                    if (usuarios[id].librosEnSuHaber[i] != null) estaVacio = false;
                }
                if (estaVacio) {
                    usuarios[id] = null;
                } else {
                    System.out.println("El usuario tiene libros de prestamo, no se le puede dar de baja.");
                }
            } else {
                System.out.println("Ese usuario no existe.");
            }
        } else {
            System.out.println("Id invalido.");
        }
    }
    private void listadoDeUsuarios(){
        boolean hayUsuarios=false;
        for (int i =0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                System.out.print("Usuario " + i+ " " );
                usuarios[i].mostrar();
                hayUsuarios=true;
            }
        }
        if (!hayUsuarios)
            System.out.println("No hay usuarios");
    }


    public void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int respuesta;
        do {
            System.out.println("---------------------");
            System.out.println("Elija una opcion:");
            System.out.println("---------------------");
            System.out.println("1.- Alta de libros.");
            System.out.println("2.- Alta de usuarios.");
            System.out.println("3.- Baja de usuarios.");
            System.out.println("4.- Préstamo de libros.");
            System.out.println("5.- Devolución de libro.");
            System.out.println("6.- Consulta de libro.");
            System.out.println("7.- Listado de usuarios.");
            System.out.println("8.- Listado de libros no prestados.");
            System.out.println("0.- Fin de la aplicación.");
            System.out.println("---------------------");
            respuesta = sc.nextInt();
            switch (respuesta) {
                case 1 -> altaLibros();
                case 2 -> altaUsuario();
                case 3 -> bajaUsuario();
                case 4 -> System.out.println(respuesta);
                case 5 -> System.out.println(respuesta);
                case 6 -> System.out.println(respuesta);
                case 7 -> listadoDeUsuarios();
                case 8 -> System.out.println(respuesta);
            }
        } while (respuesta != 0);
        System.out.println("Cerrando aplicacion.");
    }

    public static void main(String[] args) {
        E4_Biblioteca biblioteca = new E4_Biblioteca();
        biblioteca.cargarDatos();
        biblioteca.menuPrincipal();
        biblioteca.grabarDatos();
    }

    private void grabarDatos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("libros.txt"))) {
            for (int i=0;i<Libro.librosMetidos;i++) {
                if (libros[i]!=null)
                    bw.write(libros[i].codigo+"#"+libros[i].titulo+"#"+libros[i].portador.identificador);
            }
        }catch (Exception e) {
            System.out.println("Error en el fichero ");
        }

    }

    private void cargarDatos() {
        
    }
}
