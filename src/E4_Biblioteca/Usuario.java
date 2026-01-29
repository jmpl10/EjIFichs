package E4_Biblioteca;

class Usuario {
    int identificador;
    String nombre;
    Libro[] librosEnSuHaber;

    //static int identificadorCreciente = 0;
    final static int LIBROSMAXIMOSPORUSUARIO = 5;

    Usuario(String nombre, int identificador) {
        this.nombre = nombre;
        this.identificador = identificador;
        librosEnSuHaber = new Libro[LIBROSMAXIMOSPORUSUARIO];
        //identificador = identificadorCreciente++;
    }
    void mostrar(){
        System.out.println("-----------------------------------------");
        System.out.print("Identificador: " + identificador);
        System.out.print(" Nombre: " + nombre);
        System.out.print(" Libros en su posición: ");
        for (int j = 0; j < librosEnSuHaber.length; j++) {
            if (librosEnSuHaber[j]!=null)
              librosEnSuHaber[j].mostrar();
        }
        System.out.println();
    }
}
