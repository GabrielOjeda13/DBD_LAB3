package grupo13.LAB3.services;

import grupo13.LAB3.models.rolModel;
import grupo13.LAB3.respositories.rolRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class rolService {

    @Autowired
    rolRepositoryImp rolRepositoryImpInstance;

    @PostMapping("/create/rol")
    @ResponseBody
    public ResponseEntity<rolModel> guardar(@RequestBody rolModel rol){
        int idGenerado = rolRepositoryImpInstance.crear(rol);

        rol.setId(idGenerado);

        return ResponseEntity.status(HttpStatus.CREATED).body(rol);
    }

    @GetMapping("/roles")
    public List<rolModel> buscarRoles(){
        return rolRepositoryImpInstance.obtenerRoles();
    }

    @DeleteMapping("/rol/{id}")
    public void delete(@PathVariable int id) { rolRepositoryImpInstance.delete(id); }

    @PutMapping("/rol/{id}")
    public String update(@PathVariable int id, @RequestBody rolModel rol) { return rolRepositoryImpInstance.update(rol, id); }

    @GetMapping("/rol/{id}")
    public List<rolModel> getRol(@PathVariable int id) { return rolRepositoryImpInstance.showRol(id); }

}
