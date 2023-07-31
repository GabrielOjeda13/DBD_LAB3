package grupo13.LAB3.respositories;

import grupo13.LAB3.models.categoriaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Query;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class categoriaRepositoryimp implements categoriaRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Integer crear(categoriaModel categoria){

        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Categoria (nombre_categoria)" +
                    "VALUES (:nombre_categoria)";
            Query query = conn.createQuery(sql, true)
                    .addParameter("nombre_categoria", categoria.getNombre_categoria());
            Integer idGenerado = (Integer) query.executeUpdate().getKey();
            return idGenerado;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<categoriaModel> getcategoria(){
        try(Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM categoria";
            return conn.createQuery(sql, true)
                    .executeAndFetch(categoriaModel.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<categoriaModel> showcategoria(Integer id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from categoria where id_categoria = :id ")
                    .addParameter("id_categoria",id)
                    .executeAndFetch(categoriaModel.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(Integer id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from categoria where id_categoria = :id ")
                    .addParameter("id_categoria",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String update(categoriaModel categoria, Integer id){
        try(Connection conn = sql2o.open()){
            String updateSql = "UPDATE categoria set nombre=:nombre WHERE id=:id";
            conn.createQuery(String.valueOf(updateSql))
                    .addParameter("id", id)
                    .addParameter("nombre_categoria", categoria.getNombre_categoria())
                    .executeUpdate();
            return "Se actualizó la Categoria";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar la Categoria";
        }
    }
}
