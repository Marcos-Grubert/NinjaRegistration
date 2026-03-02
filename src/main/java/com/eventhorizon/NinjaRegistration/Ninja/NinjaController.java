package com.eventhorizon.NinjaRegistration.Ninja;

import com.eventhorizon.NinjaRegistration.Ninja.Response.ResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;
    private ResponseApi responseApi;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //Adicionar ninja
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody NinjaDTO ninjaDTO){

        NinjaDTO newNinjaDTO = ninjaService.create(ninjaDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseApi<>(201,"Ninja criado com sucesso", newNinjaDTO));
    }

    //Mostrar ninjas
    @GetMapping("/showAll")
    public ResponseEntity<List<NinjaDTO>> showAll(){
        List<NinjaDTO> allNinjaDTO = ninjaService.showAll();
        return ResponseEntity.ok(allNinjaDTO);
    }

    //
    @GetMapping("/show/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id){
        if(ninjaService.showById(id) != null){
            NinjaDTO ninjaDTO = ninjaService.showById(id);
            return ResponseEntity.ok(ninjaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseApi<>(404, "ID " + id + " não encontrado", null));
        }
    }

    //Altera dados do Ninja
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody NinjaDTO ninja, @PathVariable Long id){
        NinjaDTO updatedNinjaDTO = ninjaService.update(ninja,id);
        if(updatedNinjaDTO != null){
            return ResponseEntity.ok(new ResponseApi<>(200, "ID " + id + " atualizado com sucesso.", updatedNinjaDTO));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseApi<>(404, "ID " + id + " não encontrado.", null));
        }
    }

    //Exclur Ninja
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        boolean deleted = ninjaService.deleteById(id);
        if(deleted){
            return ResponseEntity.ok(new ResponseApi<>(200, "ID " + id + " deletado com sucesso.", null));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseApi<>(404, "ID " + id + " não encontrado.", null));
        }
    }
}
