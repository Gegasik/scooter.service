package com.scooter.service.сontroller;

import com.scooter.service.model.UserModel;
import com.scooter.service.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity getUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping(value = "/login/{login}")
    public ResponseEntity getUserByLogin(@PathVariable(name = "login") String login) {
        Optional<UserModel> user = userService.findByLogin(login);
        return user.isPresent() ? ResponseEntity.ok(user.get()) :
                ResponseEntity.badRequest().body("invalid User login");
    }

    @PostMapping("/users")
    public void saveUser(@RequestBody UserModel userModel) {
        userService.save(userModel);
    }

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }
}
