package com.springApp.rating;

import com.springApp.trainer.Trainer;
import com.springApp.trainer.TrainerRepository;
import com.springApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerRatingService {

    private final TrainerRatingRepository trainerRatingRepository;
    private final UserRepository userRepository;
    private final TrainerRepository trainerRepository;
    private final Trainer trainer;

    @Autowired
    public TrainerRatingService(TrainerRatingRepository trainerRatingRepository, UserRepository userRepository, TrainerRepository trainerRepository, Trainer trainer) {
        this.trainerRatingRepository = trainerRatingRepository;
        this.userRepository = userRepository;
        this.trainerRepository = trainerRepository;
        this.trainer = trainer;
    }

    public TrainerRating createRating(TrainerRating trainerRating) {
        return trainerRatingRepository.save(trainerRating);
    }
    public List<TrainerRating> findAllByUserId(Long id){
//        userRepository.findOneById(id);
        return trainerRatingRepository.findAllRatingByUserId(id);
    }
    public List<TrainerRating> findAllByRate(Long rate){
        return trainerRatingRepository.findAllRatingByRate(rate);
    }
}
