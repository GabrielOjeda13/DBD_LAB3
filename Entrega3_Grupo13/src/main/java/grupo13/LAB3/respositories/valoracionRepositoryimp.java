package grupo13.LAB3.respositories;

import grupo13.LAB3.models.valoracionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Query;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class valoracionRepositoryimp implements valoracionRepository {

    @Autowired
    private Sql2o sql2o ;

    @Override
    public Integer crearValoracionUnica(valoracionModel valoracion) {
        List<valoracionModel> valoracionesExistentes = showvaloracion(valoracion.getId());
        if (valoracionesExistentes != null && !valoracionesExistentes.isEmpty()) {
            return null;
        }

        // si no existe una valoración previa, se procede con la creacinn
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Categoria (id_valoracion, lector_id, libro_id, comentario, puntaje) " +
                    "VALUES (:id_valoracion, :lector_id, :libro_id, :comentario, :puntaje)";
            Query query = conn.createQuery(sql, true)
                    .addParameter("id_valoracion", valoracion.getId())
                    .addParameter("lector_id", valoracion.getLector_id())
                    .addParameter("libro_id", valoracion.getLibro_id())
                    .addParameter("comentario", valoracion.getComentario())
                    .addParameter("puntaje", valoracion.getPuntaje());

            Integer idGenerado = (Integer) query.executeUpdate().getKey();
            return idGenerado;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



    @Override
    public List<valoracionModel> getvaloracion(){
        try(Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM valoracion";
            return conn.createQuery(sql, true)
                    .executeAndFetch(valoracionModel.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<valoracionModel> showvaloracion(Integer id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from valoracion where id_valoracion = :id ")
                    .addParameter("id_valoracion",id)
                    .executeAndFetch(valoracionModel.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void delete(Integer id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from valoracion where id_valoracion = :id ")
                    .addParameter("id_valoracion",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String update(valoracionModel valoracion, Integer id) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update valoracion set lector_id =:lector_id or libro_id = :libro_id or comentario = :comentario or puntaje = :puntaje WHERE id_categoria=:id";
            conn.createQuery(updateSql)
                    .addParameter("id_valoracion", valoracion.getId())
                    .addParameter("lector_id", valoracion.getLector_id())
                    .addParameter("libro_id", valoracion.getLibro_id())
                    .addParameter("comentario", valoracion.getComentario())
                    .addParameter("puntaje", valoracion.getPuntaje())
                    .executeUpdate();
            return "Se actualizó la Categoria";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar la Categoria";
        }
    }

}