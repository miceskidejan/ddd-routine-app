package com.example.activity.domain.models;

import com.example.activity.domain.enums.Priority;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.enums.Category;
import com.example.sharedkernel.domain.timeManagement.Duration;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;

@Entity
@Table(name = "activities")
@Getter
public class Activity extends AbstractEntity<ActivityId> {

    private String activityName;
    @Enumerated(value = EnumType.STRING)
    private Category category;
    @Enumerated(value = EnumType.STRING)
    private Priority priority;
    private Duration duration;

    private Activity(){
        super(ActivityId.randomId(ActivityId.class));
    }
    public static Activity build(String activityName, Category category, Priority priority, Duration duration){
        Activity a = new Activity();
        a.activityName=activityName;
        a.category=category;
        a.priority=priority;
        a.duration=duration;
        return a;
    }

}
