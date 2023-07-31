package grupo13.LAB3.respositories;

import grupo13.LAB3.models.transaccionModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface transaccionRepository {
    public List<transaccionModel> obtenerTransacciones();
    public transaccionModel obtenerTransaccionPorId(long id);
}
