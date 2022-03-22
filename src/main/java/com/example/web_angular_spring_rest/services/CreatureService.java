package com.example.web_angular_spring_rest.services;

import com.example.web_angular_spring_rest.entity.Creature;
import com.example.web_angular_spring_rest.repo.CreatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatureService {

    public final CreatureRepository creatureRepository;

    public CreatureService(CreatureRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }

    public void saveCreature(Creature creature) {
        creatureRepository.save(creature);
    }

    public List<Creature> getCreatures() {
        return creatureRepository.findAll();
    }
}
