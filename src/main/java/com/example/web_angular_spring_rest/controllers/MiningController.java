package com.example.web_angular_spring_rest.controllers;

import com.example.web_angular_spring_rest.entity.Creature;
import com.example.web_angular_spring_rest.entity.Mining;
import com.example.web_angular_spring_rest.entity.View;
import com.example.web_angular_spring_rest.services.CreatureService;
import com.example.web_angular_spring_rest.services.MiningService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MiningController {

    public final MiningService miningService;

    public MiningController(MiningService miningService) {
        this.miningService = miningService;
    }

    @GetMapping("/mining")
    @JsonView(View.Creature.class)
    public List<Mining> getPoints() {
        return miningService.getMinings();
    }

    @PostMapping(value = "/post/mining",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Mining> postBody(@RequestBody Mining mining) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(miningService.addMining(mining));
    }

    @PostMapping(value = "/delete/mining",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Boolean deleteMining(@RequestBody Mining mining) {
        return miningService.deleteMining(mining);
    }

    @PostMapping(value = "/delete/minings",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Boolean deleteMinings(@RequestBody Mining[] minings) {
        return miningService.deleteMinings(minings);
    }
}
