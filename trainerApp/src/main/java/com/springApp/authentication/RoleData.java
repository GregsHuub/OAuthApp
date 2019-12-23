package com.springApp.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleData implements ApplicationRunner {


    private final RoleRepository repo;

    @Autowired
    public RoleData(RoleRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repo.save(new Role(1, "ROLE_ADMIN"));
        repo.save(new Role(2, "ROLE_USER"));
        repo.save(new Role(3, "ROLE_TRAINER"));
    }
}
