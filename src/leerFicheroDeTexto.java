import java.io.*;

public class leerFicheroDeTexto {
    public static void main(String[] args) {
        String archivo = "notasAlumnos.csv";
       Alumno mejorAlumno = null;
        double mejorPromedio = -1.0;
        double sumaPromediosClase = 0.0;
        int totalAlumnos = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo));
                BufferedWriter bw= new BufferedWriter(new FileWriter("medias.txt"))) {
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] datosAlumno = linea.split("[;]");
                // Alumno a= new Alumno (linea);
                Alumno a= new Alumno(datosAlumno[0], datosAlumno.length-1);
                for (int i = 1; i < datosAlumno.length; i++) {
                    try {
                        if (!datosAlumno[i].isEmpty())
                          a.anadirNota(Integer.parseInt(datosAlumno[i].trim()));
                    }catch (NumberFormatException ignored){
                        System.out.println("Error en el alumno:"+a.nombre);
                    }
                }
                double notaMedia= a.notaMedia();
                bw.write(a.toString());
                bw.newLine();
                sumaPromediosClase+=notaMedia;
                totalAlumnos++;
                if (notaMedia > mejorPromedio){
                    mejorPromedio=notaMedia;
                    mejorAlumno= a;
                }
            }

            if (totalAlumnos > 0) {
                System.out.printf("Mejor alumno: %s (%.2f)%n", mejorAlumno.nombre, mejorPromedio);
                System.out.printf("Media clase: %.2f%n", (sumaPromediosClase / totalAlumnos));
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
