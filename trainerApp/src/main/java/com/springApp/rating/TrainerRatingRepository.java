package com.springApp.rating;

import com.springApp.trainer.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRatingRepository extends JpaRepository<TrainerRating, Long> {

    TrainerRating findRatingById(Long id);
    List<TrainerRating> findAllRatingByTrainerId(Long id);
    List<TrainerRating> findAllRatingByUserId(Long id);
    List<TrainerRating> findAllRatingByRate(Long rate);
}
