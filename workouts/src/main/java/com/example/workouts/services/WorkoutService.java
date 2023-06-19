package com.example.workouts.services;

import com.example.workouts.models.Workout;
import com.example.workouts.repositories.WorkoutRepository;
import com.example.workouts.requests.CreateWorkoutRequest;
import com.example.workouts.requests.UpdateWorkoutRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class WorkoutService {
    final private WorkoutRepository repository;

    public List<Workout> getWorkouts() {
        List<Workout> allWorkouts = new ArrayList<>();
        for (var item : repository.findAll()) {
            allWorkouts.add(item);
        }
        return allWorkouts;
    }

    public void createWorkout(CreateWorkoutRequest workout) {
        if (repository.findByName(workout.getName()).isPresent()) {
            throw new IllegalArgumentException("Workout with name like this already existed");
        }
        final Workout newWorkout = new Workout(null, workout.getName(), workout.getDescription(), workout.getCoach(), workout.getDuration());
        repository.save(newWorkout);
    }

    public Workout getWorkoutById(Integer id) {
        final var workout = repository.findById(id);
        if (workout.isEmpty()) {
            throw new IllegalArgumentException("wrong id");
        }
        return workout.get();
    }

    public void updateWorkoutById(Integer id, UpdateWorkoutRequest newWorkout) {
        final var workout = repository.findById(id);
        if (workout.isEmpty()) {
            throw new IllegalArgumentException("wrong id");
        }

        if (newWorkout.getName() != null) {
            workout.get().setName(newWorkout.getName());
        }

        if (newWorkout.getDescription() != null) {
            workout.get().setDescription(newWorkout.getDescription());
        }

        if (newWorkout.getCoach() != null) {
            workout.get().setCoach(newWorkout.getCoach());
        }

        if (newWorkout.getDuration() != null) {
            workout.get().setDuration(newWorkout.getDuration());
        }

        repository.save(workout.get());
    }

    public void deleteWorkoutById(Integer id) {
        final var workout = repository.findById(id);
        if (workout.isEmpty()) {
            throw new IllegalArgumentException("wrong id");
        }
        repository.deleteById(id);
    }
}
