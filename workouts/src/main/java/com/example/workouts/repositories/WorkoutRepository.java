package com.example.workouts.repositories;

import com.example.workouts.models.Workout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkoutRepository extends CrudRepository<Workout, Integer> {
    Optional<Workout> findByName(String name);
}
