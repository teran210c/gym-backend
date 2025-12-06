package com.example.gym_backend.repository;

import com.example.gym_backend.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    int countByWeekId(Long weekId);
}
