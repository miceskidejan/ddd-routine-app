package com.example.routine.services.forms;

import com.example.routine.domain.valueobjects.TimeSlot;
import com.example.sharedkernel.domain.enums.Category;
import com.example.sharedkernel.domain.timeManagement.Duration;
import lombok.Data;
import lombok.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class RoutineForm {
    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    private Category category;

    @NotNull
    private Duration duration;

    @NotNull
    private TimeSlot timeSlot;

    @Valid
    @NonNull
    private List<AddActivityForm> activities = new ArrayList<>();
}
