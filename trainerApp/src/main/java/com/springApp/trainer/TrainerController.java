package com.springApp.trainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trainer")
public class TrainerController {

    private TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("register")
    public String registerTrainer(Model model){
        model.addAttribute("trainerDto", new TrainerDto());
        System.out.println("Wyswietlono formularz rejestrowania trenera");
        return "trainer/registerTrainer";
    }
    @PostMapping("/register/save")
    public String saveTrainer(@ModelAttribute TrainerDto trainerDto){
        System.out.println("Zapiano trenera");
        trainerService.createTrainer(trainerDto);
        return "redirect:/user/login";
    }
}
