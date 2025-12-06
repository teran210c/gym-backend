package com.example.gym_backend.controller;

import com.example.gym_backend.model.Week;
import com.example.gym_backend.service.WeekService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weeks")
@CrossOrigin(origins = "http://localhost:3000")
public class WeekController {
    private final WeekService weekService;

    public WeekController(WeekService weekService) {
        this.weekService = weekService;
    }

    @GetMapping
    public List<Week> getAll() {
        return weekService.getAllWeeks();
    }

    @PostMapping
    public Week create(@RequestBody Week week) {
        return weekService.createWeek(week);
    }
}
