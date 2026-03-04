package com.eventhorizon.NinjaRegistration.Ninja;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ninja/ui")
public class ControllerUi {
    private final NinjaService ninjaService;

    public ControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //Mostrar ninjas
    @GetMapping("/showAll")
    public String showAll(Model model) {
        List<NinjaDTO> ninjas = ninjaService.showAll();
        model.addAttribute("ninjas", ninjas);
        return "showNinjas"; // tem que retornar o nome da pagina que renderiza
    }

    //delete ninja by id
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        ninjaService.deleteById(id);
        return "redirect:/ninja/ui/showAll";
    }
}
