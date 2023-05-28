package com.example.activity.services;

import com.example.activity.domain.models.Activity;
import com.example.activity.domain.models.ActivityId;
import com.example.activity.services.form.ActivityForm;

import java.util.List;
import java.util.Optional;

public interface ActivityService {
    Optional<Activity> findById(ActivityId id);
    Activity createActivity(ActivityForm form);
    List<Activity> getAll();
}
