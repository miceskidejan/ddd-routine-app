package com.example.activity.services.impl;

import com.example.activity.domain.models.Activity;
import com.example.activity.domain.models.ActivityId;
import com.example.activity.domain.repository.ActivityRepository;
import com.example.activity.services.ActivityService;
import com.example.activity.services.form.ActivityForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;
    @Override
    public Optional<Activity> findById(ActivityId id) {
        return activityRepository.findById(id);
    }

    @Override
    public Activity createActivity(ActivityForm form) {
        Activity a = Activity.build(form.getActivityName(),form.getCategory(),form.getPriority(),form.getDuration());
        activityRepository.save(a);
        return a;
    }

    @Override
    public List<Activity> getAll() {
        return activityRepository.findAll();
    }
}
