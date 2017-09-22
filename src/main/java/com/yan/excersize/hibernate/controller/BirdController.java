package com.yan.excersize.hibernate.controller;

import com.yan.excersize.hibernate.domain.bird.Bird;
import com.yan.excersize.hibernate.domain.bird.MigratoryBird;
import com.yan.excersize.hibernate.domain.bird.ProvincialBird;
import com.yan.excersize.hibernate.service.IBirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Mohammad Nur on 9/22/2017.
 */

@Controller
@RequestMapping("birds")
public class BirdController {

    @Autowired
    IBirdService birdService;

    @GetMapping("all")
    public ResponseEntity<List<Bird>> getAllBirds() {
        List<Bird> list = birdService.getBirds();
        return new ResponseEntity<List<Bird>>(list, HttpStatus.OK);
    }

    @GetMapping("local")
    public ResponseEntity<List<ProvincialBird>> getAllLocalBirds() {
        List<ProvincialBird> list = birdService.getProvincialBirds();
        return new ResponseEntity<List<ProvincialBird>>(list, HttpStatus.OK);
    }

    @GetMapping("traveling")
    public ResponseEntity<List<MigratoryBird>> getTravelingBirds() {
        List<MigratoryBird> list = birdService.getMigratoryBirds();
        return new ResponseEntity<List<MigratoryBird>>(list, HttpStatus.OK);
    }
}
