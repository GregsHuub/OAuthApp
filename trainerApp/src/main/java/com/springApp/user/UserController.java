package com.springApp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

//    LOGIN , REGISTER
    @GetMapping("/login")
    public String loginForm(){
        return "user/login";
    }


    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("userDto", new UserDto());
        System.out.println("wyswietlono formularz rejestrowania");
        return "user/register";
    }
    @PostMapping("/register/save")
    public String registerSave(@ModelAttribute UserDto userDto){
        userService.createUser(userDto);
        System.out.println("Zapisano uzytkownika");
        return "redirect:/login";
    }
    //    LOGIN , REGISTER

    //SHOW LIST OF ALL USERS
    @GetMapping("/showUsers")
    public String getListOfUsers(Model model) {
        model.addAttribute("listOfUsers", userService.getListOfUsers());
        return "user/showMeUser";
    }

}
