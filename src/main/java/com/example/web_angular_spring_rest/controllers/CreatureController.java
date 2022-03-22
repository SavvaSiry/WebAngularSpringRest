package com.example.web_angular_spring_rest.controllers;

import com.example.web_angular_spring_rest.entity.Creature;
import com.example.web_angular_spring_rest.entity.View;
import com.example.web_angular_spring_rest.services.CreatureService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
public class CreatureController {

    public final CreatureService creatureService;

    public CreatureController(CreatureService creatureService) {
        this.creatureService = creatureService;
    }

    @GetMapping("/creatures")
    @JsonView(View.Creature.class)
    public List<Creature> getPoints() {
        return creatureService.getCreatures();
    }

}
