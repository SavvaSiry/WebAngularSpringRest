package com.example.web_angular_spring_rest.repo;

import com.example.web_angular_spring_rest.entity.Creature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CreatureRepository extends JpaRepository<Creature, Long> {
}
