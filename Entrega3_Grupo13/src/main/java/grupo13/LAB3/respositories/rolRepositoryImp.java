package grupo13.LAB3.respositories;

import grupo13.LAB3.models.rolModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Service
public class rolRepositoryImp implements rolRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public int crear(rolModel rol) {
        try(Connection conn = sql2o.open()) {
            String sql = "INSERT INTO rol (nombre_rol, descripcion)" + "VALUES (:nombre_rol, :descripcion)";
            Query query = conn.createQuery(sql, true)
                    .addParameter("nombre_rol", rol.getNombre_rol())
                    .addParameter("descripcion", rol.getDescripcion());

            int idGenerado = (int) query.executeUpdate().getKey();
            return idGenerado;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public String update(rolModel rol, int id) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update rol set nombre_rol= :nombre_rol, descripcion= :descripcion where id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("nombre_rol", rol.getNombre_rol())
                    .addParameter("descripcion", rol.getDescripcion())
                    .executeUpdate();
            return "se actualizo el rol";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "fallo al actualizar el rol";
        }
    }

    @Override
    public List<rolModel> showRol(int id) {
        try(Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM rol where id=:id";
            return conn.createQuery("select * from rol where id= :id")
                    .addParameter("id", id)
                    .executeAndFetch(rolModel.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public List<rolModel> obtenerRoles() {
        try(Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM rol";
            return conn.createQuery(sql, true)
                    .executeAndFetch(rolModel.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(int id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from rol where id = :id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
