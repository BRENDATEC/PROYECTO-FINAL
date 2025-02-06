public class Administrador {
    private String id;
    private String contrasena;

    public Administrador(String id, String contrasena) {
        this.id = id;
        this.contrasena = contrasena;
    }

    public String getId() {
        return id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public boolean validar(String id, String contrasena) {
        return this.id.equals(id) && this.contrasena.equals(contrasena);
    }
}
