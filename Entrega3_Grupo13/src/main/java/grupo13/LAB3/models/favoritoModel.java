package grupo13.LAB3.models;

public class favoritoModel {
    private Integer id;
    private Integer lector_id;
    private Integer libro_id;
    private String comentario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer nuevoId_favorito) {
        this.id = nuevoId_favorito;
    }

    public Integer getLector_id() {
        return lector_id;
    }

    public void setLector_id(Integer lector_id) {
        this.lector_id = lector_id;
    }

    public Integer getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(Integer libro_id) {
        this.libro_id = libro_id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
