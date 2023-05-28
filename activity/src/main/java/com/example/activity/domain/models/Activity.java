package com.example.activity.domain.models;

import com.example.activity.domain.enums.Priority;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.enums.Category;
import com.example.sharedkernel.domain.timeManagement.Duration;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "activities")
public class Activity extends AbstractEntity<ActivityId> {

    private String activityName;
    @Enumerated(value = EnumType.STRING)
    private Category category;
    @Enumerated(value = EnumType.STRING)
    private Priority priority;
    private Duration duration;



}
