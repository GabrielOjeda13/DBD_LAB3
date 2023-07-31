package grupo13.LAB3.models;

public class usuarioModel {
    private Integer id_usuario;
    private String nombre_completo;
    private String contraseña;
    private Integer edad;
    private int rol_id;
    private String email;

    public Integer getId() {
        return id_usuario;
    }

    public void setId(Integer id) {
        this.id_usuario = id;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contrasena) {
        this.contraseña = contrasena;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
