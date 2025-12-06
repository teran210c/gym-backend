package com.example.gym_backend.service;

import com.example.gym_backend.model.MuscleGroup;
import com.example.gym_backend.repository.MuscleGroupRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MuscleGroupService {

    private final MuscleGroupRepository repository;

    public MuscleGroupService(MuscleGroupRepository repository) {
        this.repository = repository;
    }

    public List<MuscleGroup> getAll() {
        return repository.findAll();
    }
}
