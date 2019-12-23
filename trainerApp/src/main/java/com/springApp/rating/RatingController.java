package com.springApp.rating;

import com.springApp.trainer.Trainer;
import com.springApp.trainer.TrainerService;
import com.springApp.user.UserEntity;
import com.springApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("rating")
public class RatingController {

    private final TrainerRatingService trainerRatingService;
    private final TrainerService trainerService;
    private final UserRepository userRepository;


    @Autowired
    public RatingController(TrainerRatingService trainerRatingService, TrainerService trainerService, UserRepository userRepository) {
        this.trainerRatingService = trainerRatingService;
        this.trainerService = trainerService;
        this.userRepository = userRepository;
    }

    //model attribute przekazuja model do HTML, bez tego nie bylo by wiadomo jak przyporzadkowac do Usera id i do trenera ID.
    @GetMapping("/addRating")
    public String addRating(Model model, @ModelAttribute("currentUser")UserEntity userEntity, @ModelAttribute("trainer")Trainer trainer){
        System.out.println("formularz dodawania oceny");
        model.addAttribute("rating", new TrainerRating());
        return "rating/addRating";
    }

    @PostMapping("/addRating/save")
    public String saveRating(@ModelAttribute TrainerRating trainerRating){
        System.out.println(" zapisano ocene");
        trainerRatingService.createRating(trainerRating);
        return "redirect:/rating/listOfRatings";
    }
}
