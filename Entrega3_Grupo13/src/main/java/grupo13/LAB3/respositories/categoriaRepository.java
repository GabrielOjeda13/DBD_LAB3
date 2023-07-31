package grupo13.LAB3.respositories;

import grupo13.LAB3.models.categoriaModel;

import java.util.List;

public interface categoriaRepository {
    public Integer crear(categoriaModel categoria);

    List<categoriaModel> getcategoria();

    List<categoriaModel> showcategoria(Integer id);

    public void delete(Integer id);

    public String update(categoriaModel categoria, Integer id);
}
