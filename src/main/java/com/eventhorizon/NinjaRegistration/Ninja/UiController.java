package com.eventhorizon.NinjaRegistration.Ninja;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninja/ui")
public class UiController {
    private final NinjaService ninjaService;

    public UiController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    //Mostrar ninjas
    @GetMapping("/showAll")
    public String showAll(Model model) {
        List<NinjaDTO> ninjas = ninjaService.showAll();
        model.addAttribute("ninjas", ninjas);
        return "showNinjas"; // tem que retornar o nome da pagina que renderiza
    }

    @GetMapping("/show/{id}")
    public String showById(@PathVariable Long id,  Model model) {
        NinjaDTO ninja = ninjaService.showById(id);
        if(ninja != null){
            model.addAttribute("ninja", ninja);
            return "showNinjaById";
        } else {
//            model.addAttribute("mensagem", "Ninja com id "+ id+ " não encontrado.");
            return "showAll";
        }
    }

    //delete ninja by id
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        ninjaService.deleteById(id);
        return "redirect:/ninja/ui/showAll";
    }

    @PostMapping("/createNinja")
    public String createNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes, Model model) {
        ninjaService.create(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja com sucesso!");
        return "redirect:/ninja/ui/showAll";
    }
}
