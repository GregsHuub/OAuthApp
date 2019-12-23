package com.springApp.rating;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TrainerRatingKey implements Serializable {

    @Column(name = "user_id")
    Long userId;

    @Column(name = "trainer_id")
    Long trainerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainerRatingKey that = (TrainerRatingKey) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(trainerId, that.trainerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, trainerId);
    }

    public TrainerRatingKey(Long userEntityId, Long trainerId) {
        this.userId = userEntityId;
        this.trainerId = trainerId;
    }

    public Long getUserEntityId() {
        return userId;
    }

    public void setUserEntityId(Long userEntityId) {
        this.userId = userEntityId;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }
}
