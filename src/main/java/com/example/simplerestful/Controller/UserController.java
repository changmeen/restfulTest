package com.example.simplerestful.Controller;

import com.example.simplerestful.Entity.User;
import com.example.simplerestful.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public Long create(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/user/{id}")
    public User read(@PathVariable Long id) {
        return userService.findById(id);
    }
}