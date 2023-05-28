package com.example.sharedkernel.domain.timeManagement;

import com.example.sharedkernel.domain.base.ValueObject;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;

@Embeddable
@Getter
public class Duration implements ValueObject {

    private final Integer hours;
    private final Integer minutes;

    protected Duration (){
        this.hours=0;
        this.minutes=0;
    }

    public Duration (@NonNull Integer hours, @NonNull Integer minutes){
        this.minutes=minutes;
        this.hours=hours;
    }

    public static Duration valueOf(Integer hours, Integer minutes){
        while (minutes>=60){
            hours+=1;
            minutes-=60;
        }
        return new Duration(hours,minutes);
    }

    public Duration add(Duration duration){

        return new Duration(hours+duration.hours,minutes+duration.minutes);
    }

    public Duration substract(Duration duration){
        return new Duration(hours-duration.hours,minutes-duration.minutes);
    }
}
