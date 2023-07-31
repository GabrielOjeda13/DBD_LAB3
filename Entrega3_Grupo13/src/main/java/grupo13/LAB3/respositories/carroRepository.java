package grupo13.LAB3.respositories;

import grupo13.LAB3.models.carroModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface carroRepository {
    public int crear(carroModel carro);

    List<carroModel> showCarro(int id);

    public List<carroModel> obtenerCarros();

    public void delete(int id);
}
