package grupo13.LAB3.services;


import grupo13.LAB3.models.carroModel;
import grupo13.LAB3.respositories.carroRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class carroService {

    @Autowired
    carroRepositoryImp carroRepositoryImpInstance;

    @PostMapping( "/create/carro")
    public ResponseEntity<carroModel> crear(@RequestBody carroModel carro){
        int idGenerado = carroRepositoryImpInstance.crear(carro);

        carro.setId(idGenerado);

        return ResponseEntity.status(HttpStatus.CREATED).body(carro);
    }

    @PutMapping("/carro/{id}")
    public String update(@RequestBody carroModel carro, @PathVariable int id) { return carroRepositoryImpInstance.update(carro, id); }

    @GetMapping("carro/{id}")
    public List<carroModel> getCarro(@PathVariable int id) { return carroRepositoryImpInstance.showCarro(id); }

    @GetMapping("/carros")
    public List<carroModel> buscarCarros() { return  carroRepositoryImpInstance.obtenerCarros(); }

    @DeleteMapping("/carro/{id}")
    public void delete(@PathVariable int id) {
        carroRepositoryImpInstance.delete(id);
    }
}
