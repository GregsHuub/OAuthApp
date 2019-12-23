package com.springApp.trainer;

import com.springApp.authentication.RoleRepository;
import com.springApp.user.UserRepository;
import com.springApp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;

@Service
@Transactional
public class TrainerService extends UserService {

    private final TrainerRepository trainerRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public TrainerService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository, TrainerRepository trainerRepo, BCryptPasswordEncoder passwordEncoder1, RoleRepository roleRepository1) {
        super(userRepository, passwordEncoder, roleRepository);
        this.trainerRepo = trainerRepo;
        this.passwordEncoder = passwordEncoder1;
        this.roleRepository = roleRepository1;
    }

    public Trainer createTrainer(TrainerDto trainerDto) {

        Trainer trainer = new Trainer();
        trainer.setEnabled(true);
        trainer.setName(trainerDto.getName());
        trainer.setLastName(trainerDto.getLastName());
        trainer.setAge(trainerDto.getAge());
        trainer.setPhone(trainerDto.getPhone());
        trainer.setPassword(passwordEncoder.encode(trainerDto.getPassword()));
        trainer.setEmail(trainerDto.getEmail());
        trainer.setSpecialization(trainerDto.getSpecialization());
        trainer.setRoles(new HashSet<>(Collections.singletonList(roleRepository.findOneByName("ROLE_TRAINER"))));

        return trainerRepo.save(trainer);


    }


}
