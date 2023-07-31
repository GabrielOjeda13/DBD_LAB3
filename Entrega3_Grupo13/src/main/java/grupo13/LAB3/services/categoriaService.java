package grupo13.LAB3.services;

import grupo13.LAB3.models.categoriaModel;
import grupo13.LAB3.respositories.categoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class categoriaService {
    private final categoriaRepository categoriaRepository;

    @Autowired
    public categoriaService(categoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping("/create/categoria")
    @ResponseBody
    public ResponseEntity<categoriaModel> crear(@RequestBody categoriaModel categoria){
        Integer idGenerado = categoriaRepository.crear(categoria);

        categoria.setId(idGenerado);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    // get R
    @GetMapping("/categorias")
    public List<categoriaModel> getcategoria(){
        return categoriaRepository.getcategoria();
    }
    //get by
    @GetMapping("/categoria/{id}")
    public List<categoriaModel> getCategoria(@PathVariable Integer id){
        return categoriaRepository.showcategoria(id);
    }

    // actualizar U
    @PutMapping("/categoria/{id}")
    @ResponseBody
    public ResponseEntity<categoriaModel> updateCategoria(@RequestBody categoriaModel categoria, @PathVariable Integer id) {
        // Verificar si la categoría con el ID proporcionado existe en la base de datos
        List<categoriaModel> categoriasEncontradas = categoriaRepository.showcategoria(id);
        if (categoriasEncontradas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Actualizar los datos de la categoría
        categoria.setId(id);
        categoriaRepository.update(categoria, id);

        return ResponseEntity.ok(categoria);
    }
    // borrar D
    @DeleteMapping("/categoria/{id}")
    public void borrar(@PathVariable Integer id){
        categoriaRepository.delete(id);
    }

}
