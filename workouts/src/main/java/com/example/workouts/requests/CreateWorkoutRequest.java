package com.example.workouts.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateWorkoutRequest {
    private String name;
    private String description;
    private String coach;
    private String duration;
}
