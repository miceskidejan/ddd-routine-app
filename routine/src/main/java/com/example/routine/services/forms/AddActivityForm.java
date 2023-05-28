package com.example.routine.services.forms;

import com.example.routine.domain.models.Routine;
import com.example.routine.domain.valueobjects.Activity;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddActivityForm {

    @NotNull
    private Activity activity;

}
