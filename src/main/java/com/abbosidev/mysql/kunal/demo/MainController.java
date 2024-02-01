package com.abbosidev.mysql.kunal.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody User addNewUser(@RequestParam String name, @RequestParam String email) {
        final User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        userRepository.save(newUser);
        return newUser;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
