package com.example.gym_backend.service;

import com.example.gym_backend.model.ExerciseTemplate;
import com.example.gym_backend.repository.ExerciseTemplateRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExerciseTemplateService {

    private final ExerciseTemplateRepository repository;

    public ExerciseTemplateService(ExerciseTemplateRepository repository) {
        this.repository = repository;
    }

    public List<ExerciseTemplate> getByMuscleGroup(Long muscleGroupId) {
        return repository.findByMuscleGroupId(muscleGroupId);
    }
}
