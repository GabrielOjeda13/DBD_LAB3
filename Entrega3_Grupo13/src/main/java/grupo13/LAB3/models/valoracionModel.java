package grupo13.LAB3.models;

public class valoracionModel {
    private Integer id_valoracion;
    private Integer lector_id;
    private Integer libro_id;
    private String comentario;
    private float puntaje;

    public int getId() {
        return id_valoracion;
    }

    public void setId(Integer id) {
        this.id_valoracion = id;
    }

    public Integer getLector_id() {
        return lector_id;
    }

    public void setLector_id(Integer lector_id) {
        this.lector_id = lector_id;
    }

    public int getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(int libro_id) {
        this.libro_id = libro_id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public float getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(float puntaje) {
        this.puntaje = puntaje;
    }
}
