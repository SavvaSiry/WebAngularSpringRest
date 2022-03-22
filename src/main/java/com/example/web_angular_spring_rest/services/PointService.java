package com.example.web_angular_spring_rest.services;

import com.example.web_angular_spring_rest.entity.Point;
import com.example.web_angular_spring_rest.repo.PointRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {

    public final PointRepository pointRepository;

    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public Point checkPoint(Point point) {
        int x = point.getX();
        int y = point.getY();
        int r = point.getR();

        if (x > 0 && y > 0 && r > 0) {
            point.setStatus(true);
        } else
            point.setStatus(false);

        savedPoint(point);
        return point;
    }

    public void savedPoint(Point point) {
        pointRepository.save(point);
    }

    public List<Point> getPoints(String token) {
        return pointRepository.findByToken(token);
    }
}
