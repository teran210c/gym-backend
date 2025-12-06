package com.example.gym_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exercise_templates")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class ExerciseTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "muscle_group_id")
    @JsonBackReference
    private MuscleGroup muscleGroup;

}
