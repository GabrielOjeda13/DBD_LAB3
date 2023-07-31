package grupo13.LAB3.respositories;

import grupo13.LAB3.models.carroModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Service
public class carroRepositoryImp implements carroRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public int crear(carroModel carro) {
        try(Connection conn = sql2o.open()) {
            String sql = "INSERT INTO carro (lector_id)" + "VALUES (:lector_id)";
            Query query = conn.createQuery(sql, true)
                    .addParameter("lector_id", carro.getLector_id());
            int idGenerado = (int) query.executeUpdate().getKey();
            return idGenerado;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public String update(carroModel carro, int id) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update carro set lector_id= :lector_id where id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("lector_id", carro.getLector_id())
                    .executeUpdate();
            return "se actualizo el carro";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "fallo al actualizar el carro";
        }
    }

    @Override
    public List<carroModel> showCarro(int id) {
        try(Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM carro where id=:id";
            return conn.createQuery("select * from carro where id= :id")
                    .addParameter("id", id)
                    .executeAndFetch(carroModel.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public List<carroModel> obtenerCarros() {
        try(Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM carro";
            return conn.createQuery(sql, true)
                    .executeAndFetch(carroModel.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(int id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from carro where id = :id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}