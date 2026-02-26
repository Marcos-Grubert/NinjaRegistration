package com.eventhorizon.NinjaRegistration.Ninja;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {return "Boas vindas ao controller ninja";}

    //Adicionar ninja
    @PostMapping("/create")
    public String criateNinja(){
        return "Ninja criado";
    }

    //Mostrar ninjas
    @GetMapping("/showNinjas")
    public List<NinjaModel> showNinjas(){
        return ninjaService.showNinjas();
    }

    //
    @GetMapping("/showNinja/{id}")
    public NinjaModel showNinjaPerId(@PathVariable Long id){
        return ninjaService.showNinjaPerId(id);
    }

    //Altera dados do Ninja
    @PutMapping("/updateNinjaPerId")
    public String updateNinjaPerId(){
        return "Ninja atualizado";
    }

    //Exclur Ninja
    @DeleteMapping("/deleteNinjaPerId")
    public String deleteNinjaPerId(){
        return "Ninja deletado";
    }


}
