package com.springApp.trainer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository  extends JpaRepository<Trainer, Long> {

    Trainer findOneById(Long id);
    Trainer findOneByEmail(String email);
    Trainer findOneByName(String name);
    Trainer findOneByLastName(String name);
    List<Trainer> findAllBySpecialization(String specialisation);


}
