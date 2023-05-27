package com.example.routine.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.sql.Time;
import java.time.LocalTime;

@Embeddable
@Getter
public class TimeSlot {
    private final LocalTime startTime;
    private final LocalTime endTime;

    protected TimeSlot(){
        this.endTime=LocalTime.of(0,0);
        this.startTime=LocalTime.of(0,0);
    }
}
