package com.example.web_angular_spring_rest.controllers;

import com.example.web_angular_spring_rest.entity.Creature;
import com.example.web_angular_spring_rest.entity.Point;
import com.example.web_angular_spring_rest.services.CreatureService;
import com.example.web_angular_spring_rest.services.PointService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.List;

@RestController
@SessionScope
public class MainController {

    public final PointService pointService;

    public MainController(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping("/points")
    public List<Point> getPoints() {
        return pointService.getPoints(RequestContextHolder.currentRequestAttributes().getSessionId());
    }

    //    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/post",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Point> postBody(@RequestBody Point point) {
        point.setToken(RequestContextHolder.currentRequestAttributes().getSessionId());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pointService.checkPoint(point));
    }
}
