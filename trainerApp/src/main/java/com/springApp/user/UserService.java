package com.springApp.user;

import com.springApp.authentication.Role;
import com.springApp.authentication.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public UserEntity createUser(UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        //wlaczenie uzytkownika
        user.setEnabled(true);
        user.setHeight(userDto.getHeight());
        user.setWeight(userDto.getWeight());
        //kodowanie hasla
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setAge(userDto.getAge());

        //okreslenie roli
        user.setRoles(new HashSet<Role>(Collections.singletonList(roleRepository.findOneByName("ROLE_USER"))));
        return userRepository.save(user);

    }

    public UserEntity findUserById(Long id) {
        return userRepository.findOneById(id);
    }

    public List<UserEntity> getListOfUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.delete(userRepository.findOneById(id));
    }

    public void updateUser(UserEntity user) {
        userRepository.save(userRepository.findOneById(user.getId()));
    }

    public UserEntity findUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

}
