package grupo13.LAB3.models;

public class categoriaModel {
    private Integer id_categoria;
    private String nombre_categoria;

    public Integer getId() {
        return id_categoria;
    }

    public void setId(Integer nuevoId_categoria) {
        this.id_categoria = nuevoId_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }
}