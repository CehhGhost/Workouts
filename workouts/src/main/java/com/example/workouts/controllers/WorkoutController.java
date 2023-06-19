package com.example.workouts.controllers;

import com.example.workouts.models.Workout;
import com.example.workouts.requests.CreateWorkoutRequest;
import com.example.workouts.requests.UpdateWorkoutRequest;
import com.example.workouts.services.WorkoutService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/workouts")
@RequiredArgsConstructor
public class WorkoutController {
    final private WorkoutService service;
    @GetMapping
    public List<Workout> getWorkouts() {
        return service.getWorkouts();
    }
    @PostMapping
    public void createWorkout(@RequestBody CreateWorkoutRequest workout) {
        service.createWorkout(workout);
    }
    @GetMapping("/{id}")
    public Workout getWorkout(@PathVariable Integer id) {
        return service.getWorkoutById(id);
    }
    @PutMapping("/{id}")
    public void updateWorkout(@PathVariable Integer id, @RequestBody UpdateWorkoutRequest newWorkout) {
        service.updateWorkoutById(id, newWorkout);
    }
    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable Integer id) {
        service.deleteWorkoutById(id);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e) {
        log.error(e.getMessage());
        return "Something went wrong!";
    }
}
