package com.example.activity.services.form;

import com.example.activity.domain.enums.Priority;
import com.example.sharedkernel.domain.enums.Category;
import com.example.sharedkernel.domain.timeManagement.Duration;
import lombok.Data;

@Data
public class ActivityForm {
    private String activityName;
    private Duration duration;
    private Category category;
    private Priority priority;


}
