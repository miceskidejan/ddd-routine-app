package com.example.routine.domain.models;

import com.example.routine.domain.valueobjects.ActivityId;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.enums.Category;
import com.example.sharedkernel.domain.timeManagement.Duration;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "add_activity")
public class AddActivity extends AbstractEntity<AddActivityId> {
    private Category category;
    private Duration duration;
    @AttributeOverride(name = "id",column = @Column(name = "activity_id",nullable = false))
    private ActivityId activityId;
}
