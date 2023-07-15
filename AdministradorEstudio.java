public class AdministradorEstudio {
    private String[] nombreCursos;
    private int[] pesoCursos;
    private int numeroCursos;
    private int cursoActual;

    public AdministradorEstudio(int numeroCursos) {
        this.numeroCursos = numeroCursos;
        nombreCursos = new String[numeroCursos];
        pesoCursos = new int[numeroCursos];
        cursoActual = 0;
    }

    public boolean agregarCurso(String nombre, int peso) {
        if (cursoActual >= numeroCursos || peso < 0) {
            return false;
        }

        nombreCursos[cursoActual] = nombre;
        pesoCursos[cursoActual] = peso;
        cursoActual++;

        return true;
    }

    public void generarHorarioEstudio() {
        int totalPeso = 0;

        for (int peso : pesoCursos) {
            totalPeso += peso;
        }

        System.out.println("Horario de estudio sugerido:");
        for (int i = 0; i < cursoActual; i++) {
            double porcentaje = (double) pesoCursos[i] / totalPeso;
            double horasEstudio = porcentaje * 5; // Supongamos que el estudiante tiene 5 horas para estudiar al día
            System.out.println(nombreCursos[i] + ": " + horasEstudio + " horas al día");
        }
    }

    public static void main(String[] args) {
        AdministradorEstudio administrador = new AdministradorEstudio(3);
        administrador.agregarCurso("Matemáticas", 5);
        administrador.agregarCurso("Historia", 3);
        administrador.agregarCurso("Física", 4);
        administrador.generarHorarioEstudio();
    }
}