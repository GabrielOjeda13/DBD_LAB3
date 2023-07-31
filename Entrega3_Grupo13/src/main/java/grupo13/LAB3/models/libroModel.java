package grupo13.LAB3.models;

public class libroModel {
    private Long cantidadDeFavoritos;
    private Integer id;
    private String nombre_libro;
    private Integer categoria_id;
    private String descripcion;
    private String fecha_publicacion;
    private Integer autor_id;
    private Integer edad_minima;
    private float precio_libro;

    public Long getcantidadDeFavoritos() {
        return cantidadDeFavoritos;
    }
    public void setcantidadDeFavoritos(Long cantidadDeFavoritos) {
        this.cantidadDeFavoritos = cantidadDeFavoritos;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    public Integer getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Integer categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public Integer getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(Integer autor_id) {
        this.autor_id = autor_id;
    }

    public Integer getEdad_minima() {
        return edad_minima;
    }

    public void setEdad_minima(Integer edad_minima) {
        this.edad_minima = edad_minima;
    }

    public float getPrecio_libro() {
        return precio_libro;
    }

    public void setPrecio_libro(float precio_libro) {
        this.precio_libro = precio_libro;
    }
}
