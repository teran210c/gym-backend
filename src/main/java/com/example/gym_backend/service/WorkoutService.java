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
        workout.setCreatedAt(LocalDateTime.now());
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
