package com.example.routine.domain.repository;

import com.example.routine.domain.models.Routine;
import com.example.routine.domain.models.RoutineId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineRepository extends JpaRepository<Routine, RoutineId> {
}
