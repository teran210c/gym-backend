package com.example.gym_backend.service;

import com.example.gym_backend.model.Exercise;
import com.example.gym_backend.model.Workout;
import com.example.gym_backend.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public Workout createWorkout(Workout workout) {
        // Verifica que la semana exista
        if (workout.getWeek() == null || workout.getWeek().getId() == null) {
            throw new RuntimeException("Workout must belong to a week");
        }

        Long weekId = workout.getWeek().getId();

        // Cuenta workouts actuales en esa semana
        int count = workoutRepository.countByWeekId(weekId);

        if (count >= 7) {
            throw new RuntimeException("Week already has 7 workouts");
        }

        // Asigna título automático
        workout.setTitleNumber(count + 1);

        // Fecha
        workout.setCreatedAt(LocalDateTime.now());

        // Añade ejercicio vacío
        if (workout.getExercises() == null) {
            workout.setExercises(new ArrayList<>());
        }

        Exercise emptyExercise = new Exercise();
        emptyExercise.setWorkout(workout);

        workout.getExercises().add(emptyExercise);
        return workoutRepository.save(workout);
    }

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }
}
