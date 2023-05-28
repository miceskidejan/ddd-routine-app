package com.example.routine.domain.models;

import com.example.routine.domain.valueobjects.Activity;
import com.example.sharedkernel.domain.enums.Category;
import com.example.routine.domain.valueobjects.Quantity;
import com.example.routine.domain.valueobjects.TimeSlot;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.timeManagement.Duration;
import jakarta.persistence.*;
import lombok.NonNull;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "routine")
public class Routine extends AbstractEntity<RoutineId> {

    private String routineName;

    private String routineDescription;

    @Enumerated(EnumType.STRING)
    private Category category;

    private TimeSlot timeSlot;

    private Quantity totalActivities;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<AddActivity> activityList;

    private Routine(){
        super(RoutineId.randomId(RoutineId.class));
    }

    public Routine(String name, String desc, Category cat, TimeSlot timeSlot) {
        super(RoutineId.randomId(RoutineId.class));
        this.routineName=name;
        this.routineDescription=desc;
        this.category=cat;
        this.timeSlot=timeSlot;
    }

    public Duration duration(){
        return activityList.stream().map(AddActivity::getDuration).reduce(new Duration(0,0),Duration::add);
    }

    public AddActivity addActivity(@NonNull Activity activity){
        Objects.requireNonNull(activity,"activity must not be null");
        var item = new AddActivity(activity.getId(),activity.getName(),activity.getDuration(),activity.getCategory());
        activityList.add(item);
        return item;
    }

    public void removeActivity(@NonNull AddActivityId addActivityId){
        activityList.removeIf(v->v.getId().equals(addActivityId));
    }



}
