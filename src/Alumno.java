public class Alumno {
String nombre;
int nota[];
int contNotas=0;
Alumno (String linea){
    String[] datos=linea.split(";");
    this.nombre = datos[0];
    nota = new int[datos.length-1];
    for (int i = 1; i < datos.length; i++) {
        try {
            if (!datos[i].isEmpty())
                anadirNota(Integer.parseInt(datos[i].trim()));
        }catch (NumberFormatException ignored){
            System.out.println("Error en el alumno:"+nombre);
        }
    }
}
Alumno (String nombre, int numNotas){
    this.nombre = nombre;
    nota = new int[numNotas];
}
void anadirNota(int nota){
    this.nota[contNotas]=nota;
    contNotas++;
}
    public double notaMedia() {
    int suma=0;
    for (int i = 0; i < contNotas; i++) {
        suma+=nota[i];
    }
    return (double)suma/contNotas;
    }

    @Override
    public String toString() {
        return nombre+":"+notaMedia();
    }
}

