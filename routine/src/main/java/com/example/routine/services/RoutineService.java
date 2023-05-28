package com.example.routine.services;

import com.example.routine.domain.exceptions.AddActivityIdNotExistsException;
import com.example.routine.domain.exceptions.RoutineIdNotExistsException;
import com.example.routine.domain.models.AddActivity;
import com.example.routine.domain.models.AddActivityId;
import com.example.routine.domain.models.Routine;
import com.example.routine.domain.models.RoutineId;
import com.example.routine.services.forms.AddActivityForm;
import com.example.routine.services.forms.RoutineForm;

import java.util.List;
import java.util.Optional;

public interface RoutineService {
    RoutineId createRoutine(RoutineForm routineForm);
    List<Routine> findAll();
    Optional<Routine> findById(RoutineId routineId);
    void addActivity(RoutineId routineId, AddActivityForm addActivityForm) throws
            RoutineIdNotExistsException;
    void deleteActivity(RoutineId routineId, AddActivityId addActivityId)throws
            RoutineIdNotExistsException, AddActivityIdNotExistsException;
}
