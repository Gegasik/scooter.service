package com.scooter.service.сontroller;

import com.scooter.service.OAP.Loggable;
import com.scooter.service.model.ScooterModel;
import com.scooter.service.service.ScooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScooterController {
    @Autowired
    ScooterService scooterService;

    @Loggable
    @GetMapping(value = "/scooters")
    public ResponseEntity GetScooters() {
        return ResponseEntity.ok(scooterService.getAll());
    }

    @Loggable
    @GetMapping(value = "/freescoots")
    public ResponseEntity GetFreeScoots() {
        return ResponseEntity.ok(scooterService.getFreeScoots());
    }

    @Loggable
    @GetMapping(value = "/freescoots{id}")
    public ResponseEntity getPageFreeScoots(@PathVariable(value = "id") int id) {
        //return ResponseEntity.ok(scooterService.getPageFreeScoots(id));
        return ResponseEntity.ok("ds");
    }

    @PostMapping(value = "/scooters")
    public ResponseEntity postScooters(@RequestBody ScooterModel scooterModel) {
        Thread t;
        Thread.yield();
        Thread.yield();
        System.out.println("QWEQWEQEQ " + Thread.currentThread().getId());
        scooterService.save(scooterModel);
        return ResponseEntity.ok(200);
    }
}


