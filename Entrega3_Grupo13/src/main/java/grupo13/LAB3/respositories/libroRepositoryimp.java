package grupo13.LAB3.respositories;

import grupo13.LAB3.models.favoritoModel;
import grupo13.LAB3.models.libroModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.time.LocalDate;
import java.util.List;

@Repository
public class libroRepositoryimp implements libroRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Integer crear(libroModel libro) {
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO libro (nombre_libro,categoria_id,descripcion,fecha_publicacion,autor_id,edad_minima,precio_libro)" +
                    "VALUES (:nombre_libro,:categoria_id,:descripcion,:fecha_publicacion,:autor_id,:edad_minima,:precio_libro)";
            Query query = conn.createQuery(sql, true)
                    .addParameter("nombre_libro", libro.getNombre_libro())
                    .addParameter("categoria_id", libro.getCategoria_id())
                    .addParameter("descripcion", libro.getDescripcion())
                    .addParameter("fecha_publicacion", LocalDate.parse(libro.getFecha_publicacion()))
                    .addParameter("autor_id", libro.getAutor_id())
                    .addParameter("edad_minima", libro.getEdad_minima())
                    .addParameter("precio_libro", libro.getPrecio_libro());
            Integer idGenerado = (Integer) query.executeUpdate().getKey();
            return idGenerado;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public String update(libroModel libro, Integer id) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update libro set nombre_libro=:nombre_libro, categoria_id=:categoria_id, descripcion=:descripcion, fecha_publicacion=:fecha_publicacion,autor_id=:autor_id,edad_minima=:edad_minima,precio_libro=:precio_libro where id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("nombre_libro", libro.getNombre_libro())
                    .addParameter("categoria_id", libro.getCategoria_id())
                    .addParameter("descripcion", libro.getDescripcion())
                    .addParameter("fecha_publicacion", LocalDate.parse(libro.getFecha_publicacion()))
                    .addParameter("autor_id",libro.getAutor_id())
                    .addParameter("edad_minima", libro.getEdad_minima())
                    .addParameter("precio_libro", libro.getPrecio_libro())
                    .executeUpdate();
            return "Se actualizo el libro";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo actualizar favorito";
        }
    }

    @Override
    public List<libroModel> getlibros() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from libro order by nombre_libro ASC")
                    .executeAndFetch(libroModel.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<libroModel> showlibro(Integer id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from libro where id=:id")
                    .addParameter("id",id)
                    .executeAndFetch(libroModel.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from libro where id=: id")
                    .addParameter("id", id)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<libroModel> RankingLibrosFavoritos() {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT l.id, l.nombre_libro, COUNT(f.id) as cantidadDeFavoritos " +
                    "FROM libro l " +
                    "LEFT JOIN favorito f ON l.id = f.libro_id " +
                    "GROUP BY l.id, l.nombre_libro " +
                    "ORDER BY cantidadDeFavoritos DESC " +
                    "LIMIT 10";
            return conn.createQuery(sql)
                    .executeAndFetch(libroModel.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
