package grupo13.LAB3.controller;

import grupo13.LAB3.models.rolModel;
import grupo13.LAB3.services.rolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class rolController {

    @Autowired
    rolService rolServiceInstance;

    @PostMapping("/create/rol")
    @ResponseBody
    public ResponseEntity<rolModel> guardar(@RequestBody rolModel rol){
        return ResponseEntity.ok(rolServiceInstance.crear(rol));
    }

    @GetMapping("/roles")
    public List<rolModel> buscarRoles(){
        return rolServiceInstance.obtenerRoles();
    }

}
