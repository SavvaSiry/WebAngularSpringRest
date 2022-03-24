package com.example.web_angular_spring_rest.repo;

import com.example.web_angular_spring_rest.entity.Clan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClanRepository extends JpaRepository<Clan, Long> {
}
