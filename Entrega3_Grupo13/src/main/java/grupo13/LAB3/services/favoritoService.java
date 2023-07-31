package grupo13.LAB3.services;

import grupo13.LAB3.models.favoritoModel;
import grupo13.LAB3.models.libroModel;
import grupo13.LAB3.respositories.favoritoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class favoritoService {
    private final favoritoRepository FavoritoRepository;

    favoritoService(favoritoRepository favoritoRepository){
        this.FavoritoRepository = favoritoRepository;
    }

    @PostMapping("/favorito")
    @ResponseBody
    public ResponseEntity<favoritoModel> crear(@RequestBody favoritoModel favorito){
        Integer idGenerado = FavoritoRepository.crear(favorito);

        favorito.setId(idGenerado);

        return ResponseEntity.status(HttpStatus.CREATED).body(favorito);
    }


    @GetMapping("/favorito")
    public List<favoritoModel> getfavoritos(){
        return FavoritoRepository.getfavoritos();
    }

    @GetMapping("/favorito/{id}")
    public List<favoritoModel> getfavorito(@PathVariable Integer id){
        return FavoritoRepository.showfavorito(id);
    }

    @PutMapping("/favorito/{id}")
    @ResponseBody
    public String updatefavorito(@RequestBody favoritoModel Favorito, @PathVariable Integer id){
        String retorno = FavoritoRepository.update(Favorito,id);
        return retorno;
    }

    @DeleteMapping("/favorito/{id}")
    public void borrar(@PathVariable Integer id){
        FavoritoRepository.delete(id);
    }

}
