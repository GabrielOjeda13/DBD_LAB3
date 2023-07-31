package grupo13.LAB3.respositories;

import grupo13.LAB3.models.favoritoModel;
import grupo13.LAB3.models.libroModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface favoritoRepository {
    public Integer crear(favoritoModel favorito);

    public String update(favoritoModel favorito, Integer id);

    public List<favoritoModel> getfavoritos();

    public List<favoritoModel> showfavorito(Integer id);

    public void delete(Integer id);
}
