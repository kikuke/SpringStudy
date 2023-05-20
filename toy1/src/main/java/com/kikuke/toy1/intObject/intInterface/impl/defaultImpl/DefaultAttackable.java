package com.kikuke.toy1.intObject.intInterface.impl.defaultImpl;

import com.kikuke.toy1.intObject.IntObject;
import com.kikuke.toy1.intObject.intInterface.Attackable;
import org.springframework.stereotype.Component;

public class DefaultAttackable implements Attackable {
    @Override
    public float attack(IntObject intObject) {
        return intObject.getDamage() * intObject.getCritical();
    }
}
