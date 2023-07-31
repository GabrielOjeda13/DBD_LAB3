package grupo13.LAB3.respositories;

import grupo13.LAB3.models.favoritoModel;
import grupo13.LAB3.models.libroModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class favoritoRepositoryimp implements favoritoRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Integer crear(favoritoModel favorito) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO favorito (lector_id, libro_id, comentario)" +
                    "VALUES (:lector_id, :libro_id, :comentario)";
            Query query = conn.createQuery(sql, true)
                    .addParameter("lector_id", favorito.getLector_id())
                    .addParameter("libro_id", favorito.getLibro_id())
                    .addParameter("comentario", favorito.getComentario());

            Integer idGenerado = (Integer) query.executeUpdate().getKey();
            return idGenerado;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<favoritoModel> getfavoritos() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("Select * from favorito order by lector_id ASC")
                    .executeAndFetch(favoritoModel.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<favoritoModel> showfavorito(Integer id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("Select * from favorito where id =:id")
                    .addParameter("id", id)
                    .executeAndFetch(favoritoModel.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(favoritoModel favorito, Integer id) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "update favorito set lector_id=:lector_id, libro_id=:libro_id, comentario=:comentario WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("lector_id", favorito.getLector_id())
                    .addParameter("libro_id", favorito.getLibro_id())
                    .addParameter("comentario", favorito.getComentario())
                    .addParameter("id", id)
                    .executeUpdate();
            return "Se actualizó el favorito";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar favorito";
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from favorito where id=:id")
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
