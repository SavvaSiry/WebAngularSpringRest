package com.example.web_angular_spring_rest.services;

import com.example.web_angular_spring_rest.entity.Clan;
import com.example.web_angular_spring_rest.entity.Creature;
import com.example.web_angular_spring_rest.repo.ClanRepository;
import com.example.web_angular_spring_rest.repo.CreatureRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CreatureService {

    public final CreatureRepository creatureRepository;
    public final ClanRepository clanRepository;

    public CreatureService(CreatureRepository creatureRepository, ClanRepository clanRepository) {
        this.creatureRepository = creatureRepository;
        this.clanRepository = clanRepository;
    }

    public void saveCreature(Creature creature) {
        creatureRepository.save(creature);
    }

    public List<Clan> getClan() {
        return clanRepository.findAll();
    }

    public List<Creature> getCreatures() {
        return creatureRepository.findAll();
    }

    public Creature addCreature(Creature creature) {
        saveCreature(creature);
        return creature;
    }

    public boolean deleteCreature(Creature creature) {
        creatureRepository.delete(creature);
        return true;
    }

    public boolean deleteCreatures(Creature[] creatures) {
        creatureRepository.deleteAll(Arrays.asList(creatures));
        return true;
    }
}
