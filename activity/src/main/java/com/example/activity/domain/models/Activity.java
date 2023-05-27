package com.example.activity.domain.models;

import com.example.activity.domain.enums.Priority;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.enums.Category;
import com.example.sharedkernel.domain.timeManagement.Duration;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "activity")
public class Activity extends AbstractEntity<ActivityId> {

    private String activityName;
    private Category category;
    private Priority priority;
    private Duration duration;

}
