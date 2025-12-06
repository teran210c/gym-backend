package com.example.gym_backend.controller;

import com.example.gym_backend.model.Week;
import com.example.gym_backend.service.WeekService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weeks")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class WeekController {

    private final WeekService weekService;

    @PostMapping
    public Week createWeek() {
        return weekService.createWeek();
    }

    @GetMapping
    public List<Week> getWeeks() {
        return weekService.getAllWeeks();
    }
}

