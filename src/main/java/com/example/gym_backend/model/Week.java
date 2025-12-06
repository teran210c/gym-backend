package com.example.gym_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "week")
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Week {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // "Semana 1" o "Week A", etc

    @OneToMany(mappedBy = "week", cascade = CascadeType.ALL)
    private List<Workout> workouts;
}
