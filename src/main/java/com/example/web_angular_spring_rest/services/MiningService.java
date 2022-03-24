package com.example.web_angular_spring_rest.services;

import com.example.web_angular_spring_rest.entity.Mining;
import com.example.web_angular_spring_rest.repo.MiningRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MiningService {

    public final MiningRepository miningRepository;

    public MiningService(MiningRepository miningRepository) {
        this.miningRepository = miningRepository;
    }

    public List<Mining> getMinings() {
        return miningRepository.findAll();
    }

    public Mining addMining(Mining mining) {
        miningRepository.save(mining);
        return mining;
    }

    public boolean deleteMining(Mining mining) {
        miningRepository.delete(mining);
        return true;
    }

    public boolean deleteMinings(Mining[] minings) {
        miningRepository.deleteAll(Arrays.asList(minings));
        return true;
    }
}
