package com.eventhorizon.NinjaRegistration.Ninja;
import com.eventhorizon.NinjaRegistration.Mission.MissionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninja/ui")
public class NinjaUiController {
    private final NinjaService ninjaService;
    private final MissionService missionService;

    public NinjaUiController(NinjaService ninjaService ,  MissionService missionService) {
        this.ninjaService = ninjaService;
        this.missionService = missionService;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    //Mostrar ninjas
    @GetMapping("/showAll")
    public String showAll(Model model) {
        List<NinjaDto> ninjas = ninjaService.showAll();
        model.addAttribute("ninjas", ninjas);
        return "showNinjas"; // tem que retornar o nome da pagina que renderiza
    }

    @GetMapping("/show/{id}")
    public String showById(@PathVariable Long id,  Model model) {
        NinjaDto ninja = ninjaService.showById(id);
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

    @GetMapping("/createNinja")
    public String showForm(Model model) {
        model.addAttribute("ninja", new NinjaDto());
        model.addAttribute("missions", missionService.getMissions());
        return "createNinja";
    }

    @PostMapping("/createNinja")
    public String createNinja(@ModelAttribute NinjaDto ninja, RedirectAttributes redirectAttributes, Model model) {
        ninjaService.create(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja com sucesso!");
        return "redirect:/ninja/ui/showAll";
    }

    @GetMapping("/updateNinja/{id}")
    public String updateNinja(@PathVariable Long id, Model model) {
        NinjaDto ninja = ninjaService.showById(id);
        model.addAttribute("ninja", ninja);
        model.addAttribute("missions", missionService.getMissions());
        return "updateNinja";
    }

    @PutMapping("/update/{id}")
    public String updateNinja(@ModelAttribute NinjaDto ninja, @PathVariable Long id, RedirectAttributes redirectAttributes){
        NinjaDto updatedNinjaDto = ninjaService.update(ninja, id);
        if(updatedNinjaDto != null){
            //Em vez de ResponseEntity, usamos mensagens de "Flash" para o Thymeleaf
            redirectAttributes.addFlashAttribute("mensagem", "ID " + id + " atualizado com sucesso!");
        }else{
            redirectAttributes.addFlashAttribute("erro", "ID " + id + " não encontrado.");
        }
        return "redirect:/ninja/ui/showAll";
    }
}
