package grupo13.LAB3.services;

import grupo13.LAB3.models.transaccionModel;
import grupo13.LAB3.respositories.transaccionRepositoryimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class transaccionService {
    @Autowired
    transaccionRepositoryimp transaccionRepositoryimpInstance;

    @GetMapping("/transaccion/all")
    public List<transaccionModel> buscarTransacciones(){
        return transaccionRepositoryimpInstance.obtenerTransacciones();
    }

    @GetMapping("/transaccion/{id}")
    public transaccionModel buscarTransaccionPorId(@PathVariable long id) {
        return transaccionRepositoryimpInstance.obtenerTransaccionPorId(id);
    }

    @PutMapping("/transaccion/update/{id}")
    public ResponseEntity<Map<String, Object>> actualizarTransaccion(@PathVariable Long id, @RequestBody transaccionModel transaccionActualizada) {
        boolean actualizacionExitosa = transaccionRepositoryimpInstance.actualizarTransaccion(id, transaccionActualizada);

        if (actualizacionExitosa) {
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("mensaje", "Transacción actualizada correctamente");
            respuesta.put("idTransaccionActualizada", id);
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
