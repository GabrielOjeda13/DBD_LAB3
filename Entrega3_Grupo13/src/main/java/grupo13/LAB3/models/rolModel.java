package grupo13.LAB3.models;

public class rolModel {
    private int id_rol;
    private String nombre_rol;
    private String descripcion;

    public int getId() {
        return id_rol;
    }

    public void setId(int id) {
        this.id_rol = id;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
