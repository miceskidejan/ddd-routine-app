package com.example.routine.domain.models;

import com.example.routine.domain.valueobjects.ActivityId;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.base.DomainObjectId;
import com.example.sharedkernel.domain.enums.Category;
import com.example.sharedkernel.domain.timeManagement.Duration;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;

@Entity
@Table(name = "add_activity")
@Getter
public class AddActivity extends AbstractEntity<AddActivityId> {
    private Category category;

    private String name;

    private Duration duration;

    @AttributeOverride(name = "id",column = @Column(name = "activity_id",nullable = false))
    private ActivityId activityId;

    public AddActivity(@NonNull ActivityId activityId,@NonNull String name, @NonNull Duration duration, @NonNull Category category){
        super(DomainObjectId.randomId(AddActivityId.class));
        this.activityId=activityId;
        this.name=name;
        this.duration=duration;
        this.category=category;

    }
}
