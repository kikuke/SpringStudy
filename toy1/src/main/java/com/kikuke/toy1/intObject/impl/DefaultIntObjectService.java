package com.kikuke.toy1.intObject.impl;

import com.kikuke.toy1.intObject.IntObject;
import com.kikuke.toy1.intObject.IntObjectService;
import com.kikuke.toy1.intObject.intInterface.Attackable;
import com.kikuke.toy1.intObject.intInterface.Avoidable;
import com.kikuke.toy1.intObject.intInterface.Deadable;
import com.kikuke.toy1.intObject.intInterface.Deffensible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultIntObjectService implements IntObjectService {

    private final Attackable attackable;
    private final Avoidable avoidable;
    private final Deadable deadable;
    private final Deffensible deffensible;

    @Autowired
    public DefaultIntObjectService(Attackable attackable, Avoidable avoidable, Deadable deadable, Deffensible deffensible) {
        this.attackable = attackable;
        this.avoidable = avoidable;
        this.deadable = deadable;
        this.deffensible = deffensible;
    }

    @Override
    public float attack(IntObject intObject) {
        return attackable.attack(intObject);
    }

    @Override
    public boolean avoid(IntObject attackObj, IntObject avoidObj) {
        return avoidable.avoid(attackObj, avoidObj);
    }

    @Override
    public boolean isDead(IntObject intObject) {
        return deadable.isDead(intObject);
    }

    @Override
    public float deffence(IntObject attackObj, IntObject deffenceObj) {
        return deffensible.deffence(attackObj, deffenceObj);
    }
}
