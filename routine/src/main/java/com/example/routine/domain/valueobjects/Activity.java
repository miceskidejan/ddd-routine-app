package com.example.routine.domain.valueobjects;

import com.example.sharedkernel.domain.base.ValueObject;
import com.example.sharedkernel.domain.enums.Category;
import com.example.sharedkernel.domain.timeManagement.Duration;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class Activity implements ValueObject {
    private final ActivityId id;
    private final String name;
    private final Category category;
    private final Duration duration;

    private Activity(Category category){
        this.category = category;
        this.id=ActivityId.randomId(ActivityId.class);
        this.name=null;
        this.duration=null;
    }

    @JsonCreator
    public Activity(ActivityId id, String name, Category category, Duration duration) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.duration = duration;
    }
}
