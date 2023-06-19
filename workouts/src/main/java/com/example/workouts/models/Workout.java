package com.example.workouts.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_workouts")
public class Workout {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private String coach;
    private String duration;
}
