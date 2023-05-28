package com.example.routine.domain.models;

import com.example.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class RoutineId extends DomainObjectId {
    protected RoutineId(@NonNull String uuid) {
        super(uuid);
    }
}
