package com.example.gym_backend.service;

import com.example.gym_backend.model.Exercise;
import com.example.gym_backend.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Exercise updateExerciseName(Long exerciseId, String newName) {
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new RuntimeException("Exercise not found"));
        exercise.setName(newName);
        return exerciseRepository.save(exercise);
    }
}