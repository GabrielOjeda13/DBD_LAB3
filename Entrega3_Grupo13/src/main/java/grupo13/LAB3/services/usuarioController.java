package grupo13.LAB3.services;

import grupo13.LAB3.models.usuarioModel;
import grupo13.LAB3.respositories.usuarioRepositoryimp;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class usuarioController {
    private final usuarioRepositoryimp  usuarioRepositoryImpInstance;

    public usuarioController(usuarioRepositoryimp usuarioRepositoryImpInstance) {
        this.usuarioRepositoryImpInstance = usuarioRepositoryImpInstance;
    }

    @PostMapping( "/create/usuario")
    @ResponseBody
    public ResponseEntity<usuarioModel> crear(@RequestBody usuarioModel usuario){
        Integer idGenerado = usuarioRepositoryImpInstance.crear(usuario);

        usuario.setId(idGenerado);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/usuarios")
    public List<usuarioModel> buscarUsuarios(){return usuarioRepositoryImpInstance.getusuarios();
    }

    @GetMapping("/usuarioEsp/{id}")
    public List<usuarioModel> buscarUsuario(@PathVariable Integer id){
        return usuarioRepositoryImpInstance.showusuario(id);
    }

    @PutMapping("/update/usuario/{id}")
    @ResponseBody
    @CacheEvict(value = "usuarios", allEntries = true)
    public String updateUsuario(@RequestBody usuarioModel usuario, @PathVariable Integer id){
        return usuarioRepositoryImpInstance.update(usuario, id);
    }

    @DeleteMapping("/delete/usuario/{id}")
    @ResponseBody
    public void borrar(@PathVariable Integer id){
        usuarioRepositoryImpInstance.delete(id);
    }

}
