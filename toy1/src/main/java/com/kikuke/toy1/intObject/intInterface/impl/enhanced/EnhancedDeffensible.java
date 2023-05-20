package com.kikuke.toy1.intObject.intInterface.impl.enhanced;

import com.kikuke.toy1.intObject.IntObject;
import com.kikuke.toy1.intObject.intInterface.Deffensible;
import org.springframework.stereotype.Component;

@Component
public class EnhancedDeffensible implements Deffensible {
    @Override
    public float deffence(IntObject attackObj, IntObject deffenceObj) {
        return attackObj.getDamage() * (deffenceObj.getDefence() / 100);
    }
}
