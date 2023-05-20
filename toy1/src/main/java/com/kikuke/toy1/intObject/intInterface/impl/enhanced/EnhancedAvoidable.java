package com.kikuke.toy1.intObject.intInterface.impl.enhanced;

import com.kikuke.toy1.intObject.IntObject;
import com.kikuke.toy1.intObject.intInterface.Avoidable;
import org.springframework.stereotype.Component;

@Component
public class EnhancedAvoidable implements Avoidable {
    @Override
    public boolean avoid(IntObject attackObj, IntObject avoidObj) {
        float rand = (float) Math.random() * 100;

        return rand < avoidObj.getAvoidance();
    }
}
