package grupo13.LAB3.respositories;

import grupo13.LAB3.models.transaccionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Service
public class transaccionRepositoryimp implements transaccionRepository{
    @Autowired
    private Sql2o sql2o;


    @Override
    public List<transaccionModel> obtenerTransacciones() {
        try(Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM transaccion";
            return conn.createQuery(sql, true)
                    .executeAndFetch(transaccionModel.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public transaccionModel obtenerTransaccionPorId(long id) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM transaccion WHERE id=:id";
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(transaccionModel.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean actualizarTransaccion(Long id, transaccionModel transaccionActualizada) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE transaccion SET valor_sin_descuento = :valor_sin_descuento, descuento = :descuento, valor_total = :valor_total, folio_boleta = :folio_boleta WHERE id= :id";

            conn.createQuery(sql)
                    //.addParameter("carro_id", transaccionActualizada.getCarro_id())
                    //.addParameter("usuario_id", transaccionActualizada.getUsuario_id())
                    .addParameter("valor_sin_descuento", transaccionActualizada.getValor_sin_descuento())
                    .addParameter("descuento", transaccionActualizada.getDescuento())
                    .addParameter("valor_total", transaccionActualizada.getValor_total())
                    //.addParameter("fecha", transaccionActualizada.getFecha())
                    .addParameter("folio_boleta", transaccionActualizada.getFolio_boleta())
                    .addParameter("id", id)
                    .executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
