package com.example.gym_backend.service;

import com.example.gym_backend.model.Exercise;
import com.example.gym_backend.model.Week;
import com.example.gym_backend.model.Workout;
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
        // Crear semana
        Week week = Week.builder()
                .title(generateWeekTitle())
                .workouts(new ArrayList<>())
                .build();

        // Crear workout vacío
        Workout workout = Workout.builder()
                .week(week)
                .exercises(new ArrayList<>())
                .build();

        // Crear ejercicio vacío
        Exercise emptyExercise = Exercise.builder()
                .name(null)
                .muscleGroup(null)
                .reps(null)
                .weight(null)
                .workout(workout)
                .build();

        workout.getExercises().add(emptyExercise);
        week.getWorkouts().add(workout);

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
