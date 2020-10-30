package com.scooter.service.сontroller;

import com.scooter.service.service.UsersScooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserAndScooterController {
    @Autowired
    UsersScooterService service;

    @GetMapping(value = "/myscoots/user{id}")
    public ResponseEntity allUsersScooters(@PathVariable(name = "id") int id) {
        Optional<List> list = Optional.of(service.getAllUsersScooters(id));
        return list.isPresent()
                ? ResponseEntity.ok(list)
                : ResponseEntity.badRequest().body("bad requestss");

    }

}
