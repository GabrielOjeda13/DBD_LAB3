package grupo13.LAB3.services;

import grupo13.LAB3.models.favoritoModel;
import grupo13.LAB3.models.libroModel;
import grupo13.LAB3.respositories.libroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class libroService {
    private final libroRepository LibroRepository;

    libroService(libroRepository libroRepository){
        this.LibroRepository = libroRepository;
    }

    @PostMapping("/libro")
    @ResponseBody
    public ResponseEntity<libroModel> crear(@RequestBody libroModel libro){
        Integer idGenerado = LibroRepository.crear(libro);

        libro.setId(idGenerado);

        return ResponseEntity.status(HttpStatus.CREATED).body(libro);
    }


    @GetMapping("/libro")
    public List<libroModel> getfavoritos(){
        return LibroRepository.getlibros();
    }

    @GetMapping("/libro/{id}")
    public List<libroModel> getfavorito(@PathVariable Integer id){
        return LibroRepository.showlibro(id);
    }

    @PutMapping("/libro/{id}")
    @ResponseBody
    public String updatefavorito(@RequestBody libroModel Favorito, @PathVariable Integer id){
        String retorno = LibroRepository.update(Favorito,id);
        return retorno;
    }

    @GetMapping("/libro/rankingFavoritos")
    public List<libroModel> RankingLibrosFavoritos(){
        return LibroRepository.RankingLibrosFavoritos();
    }

    @DeleteMapping("/libro/{id}")
    public void borrar(@PathVariable Integer id){
        LibroRepository.delete(id);
    }
}
