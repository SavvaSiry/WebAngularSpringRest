package com.example.web_angular_spring_rest.repo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PointRepository extends CrudRepository<Point, Long> {
    List<Point> findByToken(String token);
}
