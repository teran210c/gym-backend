package com.example.gym_backend.controller;

import com.example.gym_backend.model.ExerciseTemplate;
import com.example.gym_backend.service.ExerciseTemplateService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/exercise-templates")
@CrossOrigin(origins = "http://localhost:3000")
public class ExerciseTemplateController {

    private final ExerciseTemplateService service;

    public ExerciseTemplateController(ExerciseTemplateService service) {
        this.service = service;
    }

    @GetMapping("/{muscleGroupId}")
    public List<ExerciseTemplate> getByMuscleGroup(@PathVariable Long muscleGroupId) {
        return service.getByMuscleGroup(muscleGroupId);
    }
}
