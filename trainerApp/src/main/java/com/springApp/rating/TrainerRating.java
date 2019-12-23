package com.springApp.rating;

import com.springApp.trainer.Trainer;
import com.springApp.user.UserEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "rating")
public class TrainerRating implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer rate;
    private String opinion;

    @EmbeddedId
    TrainerRatingKey key_id;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    UserEntity userEntity;

    @ManyToOne
    @MapsId("trainer_id")
    @JoinColumn(name = "trainer_id")
    Trainer trainer;




    public TrainerRating(Integer rate, String opinion) {
        this.rate = rate;
        this.opinion = opinion;
    }

    public TrainerRating() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public TrainerRatingKey getKey_id() {
        return key_id;
    }

    public void setKey_id(TrainerRatingKey key_id) {
        this.key_id = key_id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }



    public TrainerRating(TrainerRatingKey key_id, UserEntity userEntity, Trainer trainer, Long id, Integer rate, String opinion) {
        this.key_id = key_id;
        this.userEntity = userEntity;
        this.trainer = trainer;
        this.id = id;
        this.rate = rate;
        this.opinion = opinion;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainerRating that = (TrainerRating) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(rate, that.rate) &&
                Objects.equals(opinion, that.opinion) &&
                Objects.equals(key_id, that.key_id) &&
                Objects.equals(userEntity, that.userEntity) &&
                Objects.equals(trainer, that.trainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rate, opinion, key_id, userEntity, trainer);
    }
}
