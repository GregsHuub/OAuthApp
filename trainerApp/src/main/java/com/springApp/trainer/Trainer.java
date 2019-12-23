package com.springApp.trainer;


import com.springApp.rating.TrainerRating;
import com.springApp.user.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Getter @Setter @NoArgsConstructor
public class Trainer extends UserEntity {

    private int phone;
    private String specialization;
    private boolean enabled;


    @OneToMany(mappedBy = "trainer")
    Set<TrainerRating> trainerRatings;
}
