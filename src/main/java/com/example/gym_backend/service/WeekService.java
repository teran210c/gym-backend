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

        // ☑️ Crear semana inicial solo si no existen semanas
        initializeDefaultWeek();
    }

    private void initializeDefaultWeek() {
        if (weekRepository.count() == 0) {
            Week week = Week.builder()
                    .title("Week 1")
                    .build();

            // Workout vacío
            Workout workout = Workout.builder()
                    .titleNumber(1)
                    .week(week)
                    .build();

            // Exercise vacío
            Exercise exercise = Exercise.builder()
                    .name(null)
                    .reps(null)
                    .weight(null)
                    .workout(workout)
                    .build();

            workout.setExercises(List.of(exercise));
            week.setWorkouts(List.of(workout));

            weekRepository.save(week);
        }
    }

    public Week createWeek() {
        Week week = Week.builder()
                .title(generateWeekTitle())
                .workouts(new ArrayList<>())
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
