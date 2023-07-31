package grupo13.LAB3.respositories;

import grupo13.LAB3.models.usuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;

@Repository
public class usuarioRepositoryimp implements usuarioRepository {

    @Autowired
    private  Sql2o sql2o;


    @Override
    public Integer crear(usuarioModel usuario) {
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO usuario (nombre_completo, contraseña, edad, rol_id, email)" +
                    "VALUES (:nombre_completo, :contraseña, :edad, :rol_id, :email)";

            Query query = conn.createQuery(sql, true)
                    .addParameter("nombre_completo", usuario.getNombre_completo())
                    .addParameter("contraseña", usuario.getContraseña())
                    .addParameter("edad", usuario.getEdad())
                    .addParameter("rol_id", usuario.getRol_id())
                    .addParameter("email", usuario.getEmail());

            Integer idGenerado = (Integer) query.executeUpdate().getKey();
            return idGenerado;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public String update(usuarioModel usuario, Integer id) {
        try(Connection conn = sql2o.open()){
            String updateSql = "UPDATE usuario SET nombre_completo= :nombre_completo, " +
                    "contraseña= :contraseña, edad= :edad, rol_id= :rol_id, email= :email " +
                    "WHERE id = :id";

            conn.createQuery(updateSql)

                    .addParameter("nombre_completo", usuario.getNombre_completo())
                    .addParameter("contraseña", usuario.getContraseña())
                    .addParameter("edad", usuario.getEdad())
                    .addParameter("rol_id", usuario.getRol_id())
                    .addParameter("email", usuario.getEmail())
                    .addParameter("id", id)
                    .executeUpdate();

            return "se actualizo el usuario";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "fallo al actualizar el usuario";
        }
    }

    @Override
    @Cacheable(value = "usuarios")
    public List<usuarioModel> getusuarios(){
        try (Connection conn = sql2o.open ()){
            return conn.createQuery("select * from usuario order by id ASC")
                    .executeAndFetch(usuarioModel.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<usuarioModel> showusuario(Integer id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from usuario where id= :id")
                    .addParameter("id", id)
                    .executeAndFetch(usuarioModel.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(Integer id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("Delete from usuario where id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
