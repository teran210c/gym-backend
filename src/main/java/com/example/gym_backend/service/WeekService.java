package com.example.gym_backend.service;

import com.example.gym_backend.model.Week;
import com.example.gym_backend.repository.WeekRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeekService {
    private final WeekRepository weekRepository;

    public WeekService(WeekRepository weekRepository) {
        this.weekRepository = weekRepository;
    }

    public Week createWeek(Week week) {
        return weekRepository.save(week);
    }

    public List<Week> getAllWeeks() {
        return weekRepository.findAll();
    }


}
