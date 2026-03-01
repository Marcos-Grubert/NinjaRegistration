package com.eventhorizon.NinjaRegistration.Ninja;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {return "Boas vindas ao controller ninja";}

    //Adicionar ninja
    @PostMapping("/create")
    public NinjaDTO create(@RequestBody NinjaDTO ninjaDTO){
        return ninjaService.create(ninjaDTO);
    }

    //Mostrar ninjas
    @GetMapping("/showAll")
    public List<NinjaModel> showAll(){
        return ninjaService.showAll();
    }

    //
    @GetMapping("/show/{id}")
    public NinjaModel showById(@PathVariable Long id){
        return ninjaService.showById(id);
    }

    //Altera dados do Ninja
    @PutMapping("/update/{id}")
    public NinjaModel update(@RequestBody NinjaModel ninja, @PathVariable Long id){
        return ninjaService.update(ninja, id);
    }

    //Exclur Ninja
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        ninjaService.deleteById(id);
    }
}
