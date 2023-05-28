package com.example.activity.domain.models;

import com.example.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class ActivityId extends DomainObjectId {
    protected ActivityId(@NonNull String uuid) {
        super(uuid);
    }
}
