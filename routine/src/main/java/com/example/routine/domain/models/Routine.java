package com.example.routine.domain.models;

import com.example.sharedkernel.domain.enums.Category;
import com.example.routine.domain.valueobjects.Quantity;
import com.example.routine.domain.valueobjects.TimeSlot;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.timeManagement.Duration;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "routine")
public class Routine extends AbstractEntity<RoutineId> {

    private String routineName;

    private String routineDescription;

    @Enumerated(EnumType.STRING)
    private Category category;

    private TimeSlot timeSlot;

    private Duration duration;

    private Quantity totalActivities;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<AddActivity> activityList;
}
