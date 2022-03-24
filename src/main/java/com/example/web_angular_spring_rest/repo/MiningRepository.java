package com.example.web_angular_spring_rest.repo;

import com.example.web_angular_spring_rest.entity.Mining;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MiningRepository extends JpaRepository<Mining, Long> {
}
