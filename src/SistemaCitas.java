import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class SistemaCitas {
    private List<Doctor> doctores;
    private List<Paciente> pacientes;
    private List<Cita> citas;
    private List<Administrador> administradores;

    public SistemaCitas() {
        doctores = new ArrayList<>();
        pacientes = new ArrayList<>();
        citas = new ArrayList<>();
        administradores = new ArrayList<>();
    }

    public void darAltaDoctor(int id, String nombre, String especialidad) {
        doctores.add(new Doctor(id, nombre, especialidad));
        guardarDoctores();
    }

    public void darAltaPaciente(int id, String nombre) {
        pacientes.add(new Paciente(id, nombre));
        guardarPacientes();
    }

    public void crearCita(int id, LocalDateTime fechaHora, String motivo, Doctor doctor, Paciente paciente) {
        citas.add(new Cita(id, fechaHora, motivo, doctor, paciente));
        guardarCitas();
    }

    public boolean validarAdministrador(String id, String contrasena) {
        for (Administrador admin : administradores) {
            if (admin.validar(id, contrasena)) {
                return true;
            }
        }
        return false;
    }

    public void guardarDoctores() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("doctores.csv"))) {
            for (Doctor doctor : doctores) {
                writer.write(doctor.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los doctores.");
        }
    }

    public void guardarPacientes() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pacientes.csv"))) {
            for (Paciente paciente : pacientes) {
                writer.write(paciente.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los pacientes.");
        }
    }

    public void guardarCitas() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("citas.csv"))) {
            for (Cita cita : citas) {
                writer.write(cita.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar las citas.");
        }
    }

    public void cargarAdministradores() {
        // Aquí se cargarían los administradores, por ejemplo, de un archivo CSV
        administradores.add(new Administrador("admin", "1234"));
    }

    public void verCitas() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas.");
        } else {
            for (Cita cita : citas) {
                System.out.println("ID: " + cita.getId());
                System.out.println("Fecha y Hora: " + cita.getFechaHora());
                System.out.println("Motivo: " + cita.getMotivo());
                System.out.println("Doctor: " + cita.getDoctor() + " (" + cita.getDoctor().getEspecialidad() + ")");
                System.out.println("Paciente: " + cita.getPaciente());
              //  System.out.println("prueba: " + cita.getPaciente());
                System.out.println("---------------");
            }
        }
    }


}
