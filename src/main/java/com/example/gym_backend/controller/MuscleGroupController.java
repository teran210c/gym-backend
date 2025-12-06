package com.example.gym_backend.controller;

import com.example.gym_backend.model.MuscleGroup;
import com.example.gym_backend.service.MuscleGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/muscle-groups")
@CrossOrigin(origins = "http://localhost:3000")
public class MuscleGroupController {

    private final MuscleGroupService service;

    public MuscleGroupController(MuscleGroupService service) {
        this.service = service;
    }

    @GetMapping
    public List<MuscleGroup> getAll() {
        return service.getAll();
    }
}
