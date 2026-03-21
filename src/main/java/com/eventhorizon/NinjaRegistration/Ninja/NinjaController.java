package com.eventhorizon.NinjaRegistration.Ninja;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private final NinjaService ninjaservice;
    private NinjaResponseApi ninjaResponseApi;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaservice = ninjaService;
    }

    //Adicionar ninja
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody NinjaDto NinjaDto){

        NinjaDto newNinjaDto = ninjaservice.create(NinjaDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new NinjaResponseApi<>(201,"Ninja criado com sucesso", newNinjaDto));
    }

    //Mostrar ninjas
    @GetMapping("/showAll")
    public ResponseEntity<List<NinjaDto>> showAll(){
        List<NinjaDto> allNinjaDto = ninjaservice.showAll();
        return ResponseEntity.ok(allNinjaDto);
    }

    //
    @GetMapping("/show/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id){
        if(ninjaservice.showById(id) != null){
            NinjaDto NinjaDto = ninjaservice.showById(id);
            return ResponseEntity.ok(NinjaDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NinjaResponseApi<>(404, "ID " + id + " não encontrado", null));
        }
    }

    //Altera dados do Ninja
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody NinjaDto ninja, @PathVariable Long id){
        NinjaDto updatedNinjaDto = ninjaservice.update(ninja,id);
        if(updatedNinjaDto != null){
            return ResponseEntity.ok(new NinjaResponseApi<>(200, "ID " + id + " atualizado com sucesso.", updatedNinjaDto));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NinjaResponseApi<>(404, "ID " + id + " não encontrado.", null));
        }
    }

    //Exclur Ninja
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        boolean deleted = ninjaservice.deleteById(id);
        if(deleted){
            return ResponseEntity.ok(new NinjaResponseApi<>(200, "ID " + id + " deletado com sucesso.", null));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new NinjaResponseApi<>(404, "ID " + id + " não encontrado.", null));
        }
    }
}
