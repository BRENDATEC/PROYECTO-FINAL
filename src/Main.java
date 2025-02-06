import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaCitas sistema = new SistemaCitas();
        sistema.cargarAdministradores();

        // Login de Administrador
        System.out.println("Ingrese su ID de Administrador:");
        String id = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contrasena = scanner.nextLine();

        if (!sistema.validarAdministrador(id, contrasena)) {
            System.out.println("Acceso denegado.");
            return;
        }

        // Menú de opciones
        boolean salir = false;
        while (!salir) {
            System.out.println("1. Dar de alta doctor");
            System.out.println("2. Dar de alta paciente");
            System.out.println("3. Crear cita");
            System.out.println("4. Ver citas");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese ID del doctor:");
                    int idDoctor = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.println("Ingrese nombre del doctor:");
                    String nombreDoctor = scanner.nextLine();
                    System.out.println("Ingrese especialidad del doctor:");
                    String especialidad = scanner.nextLine();
                    sistema.darAltaDoctor(idDoctor, nombreDoctor, especialidad);
                    break;
                case 2:
                    System.out.println("Ingrese ID del paciente:");
                    int idPaciente = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.println("Ingrese nombre del paciente:");
                    String nombrePaciente = scanner.nextLine();
                    sistema.darAltaPaciente(idPaciente, nombrePaciente);
                    break;
                case 3:
                    System.out.println("Ingrese ID de la cita:");
                    int idCita = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.println("Ingrese fecha y hora de la cita (yyyy-mm-ddTHH:mm):");
                    String fechaHoraString = scanner.nextLine();
                    LocalDateTime fechaHora = LocalDateTime.parse(fechaHoraString);
                    System.out.println("Ingrese motivo de la cita:");
                    String motivo = scanner.nextLine();
                    System.out.println("Ingrese ID del doctor:");
                    int idDoctorCita = scanner.nextInt();
                    System.out.println("Ingrese ID del paciente:");
                    int idPacienteCita = scanner.nextInt();
                    Doctor doctor = new Doctor(idDoctorCita, "", ""); // Simulación de búsqueda de doctor
                    Paciente paciente = new Paciente(idPacienteCita, ""); // Simulación de búsqueda de paciente
                    sistema.crearCita(idCita, fechaHora, motivo, doctor, paciente);
                    break;
                case 5:
                    salir = true;
                    break;
                case 4:
                    sistema.verCitas();  // Llamamos al método para ver las citas
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        scanner.close();
    }
}
