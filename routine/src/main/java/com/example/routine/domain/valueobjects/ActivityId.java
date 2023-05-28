package com.example.routine.domain.valueobjects;

import com.example.sharedkernel.domain.base.DomainObjectId;
import jakarta.persistence.Embeddable;
import lombok.NonNull;

@Embeddable
public class ActivityId extends DomainObjectId {

    protected ActivityId(@NonNull String uuid) {
        super(uuid);
    }
}
