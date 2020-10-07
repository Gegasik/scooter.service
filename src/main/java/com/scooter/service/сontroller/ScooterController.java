package com.scooter.service.сontroller;

import com.scooter.service.service.ScooterService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class ScooterController {
    @Autowired
    ScooterService scooterService;

    @GetMapping(value = "/scooters")
    public ResponseEntity GetScooters() {
        return ResponseEntity.ok(scooterService.getAll());
    }

    @GetMapping(value = "/freescoots")
    public ResponseEntity GetFreeScoots(){
        return ResponseEntity.ok(scooterService.getFreeScoots());
    }

    @GetMapping(value = "/freescoots{id}")
    public ResponseEntity getPageFreeScoots(@PathVariable(value = "id")int id){
        return ResponseEntity.ok(scooterService.getPageFreeScoots(id));
    }
}


