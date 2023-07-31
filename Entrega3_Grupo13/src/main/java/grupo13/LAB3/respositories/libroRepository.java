package grupo13.LAB3.respositories;

import grupo13.LAB3.models.favoritoModel;
import grupo13.LAB3.models.libroModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface libroRepository {
    public Integer crear(libroModel libro);

    public String update(libroModel libro, Integer id);

    public List<libroModel> getlibros();

    public List<libroModel> showlibro(Integer id);

    public void delete(Integer id);

    public List<libroModel> RankingLibrosFavoritos();
}
