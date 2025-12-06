package com.example.gym_backend.service;

import com.example.gym_backend.model.Week;
import com.example.gym_backend.repository.WeekRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WeekService {
    private final WeekRepository weekRepository;

    public WeekService(WeekRepository weekRepository) {
        this.weekRepository = weekRepository;
    }

    public Week createWeek() {
        Week week = Week.builder()
                .title(generateWeekTitle())
                .workouts(new ArrayList<>()) // lista vacía
                .build();

        return weekRepository.save(week);
    }

    private String generateWeekTitle() {
        long count = weekRepository.count();
        return "Week " + (count + 1);
    }

    public List<Week> getAllWeeks() {
        return weekRepository.findAll();
    }


}
