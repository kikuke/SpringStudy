package com.kikuke.toy1.intObject.intInterface.impl.enhanced;

import com.kikuke.toy1.intObject.IntObject;
import com.kikuke.toy1.intObject.intInterface.Deadable;
import org.springframework.stereotype.Component;

@Component
public class EnhancedDeadable implements Deadable {
    @Override
    public boolean isDead(IntObject intObject) {
        return intObject.getHp() <= 0;
    }
}
