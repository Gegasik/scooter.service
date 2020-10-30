package com.scooter.service.сontroller;

import com.scooter.service.OAP.Loggable;
import com.scooter.service.model.AuthRequest;
import com.scooter.service.model.UserModel;
import com.scooter.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Loggable
    @GetMapping("user")
    public ResponseEntity getUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @Loggable
    @PostMapping("user")
    public void saveUser(@RequestBody UserModel userModel) {
        userService.save(userModel);
    }
    @Loggable
    @PostMapping("login")
    public ResponseEntity<Object> getAuthUser(@RequestBody AuthRequest request) {

        UserModel userEntity = userService.findByEmailAndPassword(request.getEmail(), request.getPassword());
        if (userEntity == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else {
            return ResponseEntity.ok(userEntity);
        }
    }

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }
    // Convert a predefined exception to an HTTP Status code
}


