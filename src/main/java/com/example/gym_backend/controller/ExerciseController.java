package com.example.gym_backend.controller;

import com.example.gym_backend.model.Exercise;
import com.example.gym_backend.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/exercises")
@CrossOrigin(origins = "http://localhost:3000")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PutMapping("/{id}/name")
    public Exercise updateExerciseName(
            @PathVariable Long id,
            @RequestBody Map<String, String> body) {
        String newName = body.get("newName");
        return exerciseService.updateExerciseName(id, newName);
    }

}
