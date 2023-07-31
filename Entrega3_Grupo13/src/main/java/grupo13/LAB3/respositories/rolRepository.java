package grupo13.LAB3.respositories;

import grupo13.LAB3.models.rolModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface rolRepository {
    public int crear(rolModel rol);

    List<rolModel> showRol(int id);

    public List<rolModel> obtenerRoles();

    public void delete(int id);
}
