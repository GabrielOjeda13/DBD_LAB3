package grupo13.LAB3.respositories;
import grupo13.LAB3.models.usuarioModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface usuarioRepository {

    public Integer crear(usuarioModel usuario);

    public String update(usuarioModel usuario, Integer id_usuario);

    public List<usuarioModel> getusuarios();

    public List<usuarioModel> showusuario(Integer id);

    public void delete(Integer id);
}
