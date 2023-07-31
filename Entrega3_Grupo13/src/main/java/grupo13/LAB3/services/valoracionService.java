package grupo13.LAB3.services;

import grupo13.LAB3.models.valoracionModel;
import grupo13.LAB3.respositories.valoracionRepositoryimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class valoracionService {

    private final valoracionRepositoryimp valoracionRepositoryimp;

    @Autowired
    public valoracionService(valoracionRepositoryimp valoracionRepository) {
        this.valoracionRepositoryimp = valoracionRepository;
    }

    @PostMapping( "/create/valoracion")
    @ResponseBody
    public ResponseEntity<valoracionModel> crear(@RequestBody valoracionModel valoracion){
        Integer idGenerado = valoracionRepositoryimp.crearValoracionUnica(valoracion);

        valoracion.setId(idGenerado);

        return ResponseEntity.status(HttpStatus.CREATED).body(valoracion);
    }

    // get R
    @GetMapping("/valoraciones")
    public List<valoracionModel> getvaloracion(){
        return valoracionRepositoryimp.getvaloracion();
    }


    //get by
    @GetMapping("/valoracion/{id}")
    public List<valoracionModel> getCategoria(@PathVariable Integer id){
        return valoracionRepositoryimp.showvaloracion(id);
    }

    // actualizar U
    @PutMapping("/valoracion/{id}")
    @ResponseBody
    public Integer update(@RequestBody valoracionModel valoracion, @PathVariable Integer id){
        int regreso = Integer.parseInt(valoracionRepositoryimp.update(valoracion,id));
        return regreso;
    }


    // borrar D
    @DeleteMapping("/valoracion/{id}")
    public void borrar(@PathVariable Integer id){
        valoracionRepositoryimp.delete(id);
    }
}


