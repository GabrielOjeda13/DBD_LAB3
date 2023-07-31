package grupo13.LAB3.respositories;

import grupo13.LAB3.models.valoracionModel;

import java.util.List;

public interface valoracionRepository {
    public Integer crearValoracionUnica(valoracionModel valoracion);

    public List<valoracionModel> getvaloracion();

    public List<valoracionModel> showvaloracion(Integer id);

    public void delete(Integer id);

    public String update(valoracionModel valoracion, Integer id);
}