package com.example.routine.domain.models;

import com.example.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class AddActivityId extends DomainObjectId {
    protected AddActivityId(@NonNull String uuid) {
        super(uuid);
    }
}
