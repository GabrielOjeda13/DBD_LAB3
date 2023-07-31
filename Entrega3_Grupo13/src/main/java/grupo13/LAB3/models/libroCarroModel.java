package grupo13.LAB3.models;

public class libroCarroModel {
    private Integer id_libroCarro;
    private Integer carro_id;
    private Integer libro_id;
    private float precio_libro;

    public Integer getId() {
        return id_libroCarro;
    }

    public void setId(Integer id) {
        this.id_libroCarro = id;
    }

    public Integer getCarro_id() {
        return carro_id;
    }

    public void setCarro_id(Integer carro_id) {
        this.carro_id = carro_id;
    }

    public Integer getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(Integer libro_id) {
        this.libro_id = libro_id;
    }

    public float getPrecio_libro() {
        return precio_libro;
    }

    public void setPrecio_libro(float precio_libro) {
        this.precio_libro = precio_libro;
    }
}
