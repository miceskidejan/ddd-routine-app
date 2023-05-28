package com.example.activity.domain.repository;

import com.example.activity.domain.models.Activity;
import com.example.activity.domain.models.ActivityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, ActivityId> {
}
