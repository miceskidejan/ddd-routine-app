package com.example.routine.services.impl;

import com.example.routine.domain.exceptions.AddActivityIdNotExistsException;
import com.example.routine.domain.exceptions.RoutineIdNotExistsException;
import com.example.routine.domain.models.AddActivityId;
import com.example.routine.domain.models.Routine;
import com.example.routine.domain.models.RoutineId;
import com.example.routine.domain.repository.RoutineRepository;
import com.example.routine.services.RoutineService;
import com.example.routine.services.forms.AddActivityForm;
import com.example.routine.services.forms.RoutineForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class RoutineServiceImpl implements RoutineService {

    private final RoutineRepository routineRepository;

    @Override
    public RoutineId createRoutine(RoutineForm routineForm) {
        Objects.requireNonNull(routineForm,"routine must not be null");
//        var constraintViolations = validator.validate(routineForm);
//        if(constraintViolations.size()>0){
//            throw new ConstraintViolationException("The routine form is not valid.", constraintViolations);
//        }
        var newRoutine = routineRepository.saveAndFlush(toDomainObject(routineForm));
        return newRoutine.getId();
    }

    @Override
    public List<Routine> findAll() {
        return routineRepository.findAll();
    }

    @Override
    public Optional<Routine> findById(RoutineId routineId) {
        return Optional.empty();
    }

    @Override
    public void addActivity(RoutineId routineId, AddActivityForm addActivityForm) throws RoutineIdNotExistsException {
        Routine routine = routineRepository.findById(routineId).orElseThrow(RoutineIdNotExistsException::new);
        routine.addActivity(addActivityForm.getActivity());
        routineRepository.saveAndFlush(routine);
    }

    @Override
    public void deleteActivity(RoutineId routineId, AddActivityId addActivityId) throws RoutineIdNotExistsException, AddActivityIdNotExistsException {
        Routine routine = routineRepository.findById(routineId).orElseThrow(RoutineIdNotExistsException::new);
        routine.removeActivity(addActivityId);
        routineRepository.saveAndFlush(routine);
    }

    private Routine toDomainObject(RoutineForm routineForm){
        var routine = new Routine(routineForm.getName(), routineForm.getDescription(), routineForm.getCategory(), routineForm.getTimeSlot());
        routineForm.getActivities().forEach(activity->routine.addActivity(activity.getActivity()));
        return routine;
    }
}
