package dev.naoisemcg.naoisespetitions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/petitions")
public class PetitionController {
    private final PetitionService petitionService;

    public PetitionController(PetitionService petitionService) {
        this.petitionService = petitionService;
    }

    @GetMapping
    public String getPetitions(Model model) {
        model.addAttribute("petitions", petitionService.getAllPetitions());
        return "petition-list";
    }

    @GetMapping("/{id}")
    public String getPetitionDetails(@PathVariable Integer id, Model model) {
        model.addAttribute("petition", petitionService.getPetitionById(id));
        return "petition-details";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model) {
        model.addAttribute("petition", new Petition());
        return "petition-create";
    }

    @PostMapping("/create")
    public String createPetition(Petition petition) {
        petitionService.createNewPetition(petition);
        return "redirect:/petitions";
    }

    @PostMapping("/{id}/sign")
    public String addSignature(@PathVariable Integer id, @RequestParam String signature) {
        petitionService.signPetition(id, signature);
        return "redirect:/petitions/" + id;
    }
}
