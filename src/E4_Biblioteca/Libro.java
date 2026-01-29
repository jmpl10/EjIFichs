package E4_Biblioteca;

class Libro {
    int codigo;
    String titulo;
    Usuario portador;
    static int librosMetidos = 0;
    Libro( String titulo) {
        this.titulo = titulo;
        codigo=librosMetidos;
        librosMetidos++;
        portador=null;
    }
    void mostrar(){
        System.out.println(codigo+" "+ titulo);
    }
}
