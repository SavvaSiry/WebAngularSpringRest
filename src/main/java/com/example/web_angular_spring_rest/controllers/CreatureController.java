package com.example.web_angular_spring_rest.controllers;

import com.example.web_angular_spring_rest.entity.Clan;
import com.example.web_angular_spring_rest.entity.Creature;
import com.example.web_angular_spring_rest.entity.View;
import com.example.web_angular_spring_rest.services.CreatureService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/clan")
    @JsonView(View.Clan.class)
    public List<Clan> getClan() {
        return creatureService.getClan();
    }

    @PostMapping(value = "/post/creature",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Creature> postBody(@RequestBody Creature creature) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(creatureService.addCreature(creature));
    }

    @PostMapping(value = "/delete/creature",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Boolean deleteCreature(@RequestBody Creature creature) {
        return creatureService.deleteCreature(creature);
    }

    @PostMapping(value = "/delete/creatures",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Boolean deleteCreatures(@RequestBody Creature[] creatures) {
        return creatureService.deleteCreatures(creatures);
    }
}
