package com.springApp.trainer;

import com.springApp.user.UserDto;
import lombok.*;

@Getter @Setter @NoArgsConstructor
public class TrainerDto extends UserDto {

    private int phone;
    private String specialization;

    public TrainerDto(String name, String lastName, String email, String password, int age, float weight, float height, int phone, String specialization) {
        super(name, lastName, email, password, age, weight, height);
        this.phone = phone;
        this.specialization = specialization;
    }
}
