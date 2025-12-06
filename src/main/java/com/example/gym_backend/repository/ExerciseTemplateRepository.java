package com.example.gym_backend.repository;

import com.example.gym_backend.model.ExerciseTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseTemplateRepository extends JpaRepository<ExerciseTemplate, Long> {

    List<ExerciseTemplate> findByMuscleGroupId(Long muscleGroupId);
}
