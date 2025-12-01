package com.example.gym_backend.controller;

import com.example.gym_backend.model.Workout;
import com.example.gym_backend.service.WorkoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workouts")
@CrossOrigin(origins = "http://localhost:3000") // permite llamadas desde tu frontend React/Next.js
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    // Crear un nuevo workout
    @PostMapping
    public Workout createWorkout(@RequestBody Workout workout) {
        return workoutService.createWorkout(workout);
    }

    // Obtener todos los workouts
    @GetMapping
    public List<Workout> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

//    // Obtener un workout por ID
//    @GetMapping("/{id}")
//    public Workout getWorkoutById(@PathVariable Long id) {
//        return workoutService.getWorkoutById(id);
//    }



//    // Eliminar un workout
//    @DeleteMapping("/{id}")
//    public void deleteWorkout(@PathVariable Long id) {
//        workoutService.deleteWorkout(id);
//    }
}
