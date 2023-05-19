package com.kikuke.toy1.intPlayer;

import com.kikuke.toy1.intObject.IntObject;

public class IntPlayer {

    IntClass intClass;
    IntObject intObject;

    public IntPlayer() {}
    public IntPlayer(IntClass intClass, IntObject intObject) {
        this.intClass = intClass;
        this.intObject = intObject;
    }

    public IntClass getIntClass() {
        return intClass;
    }

    public void setIntClass(IntClass intClass) {
        this.intClass = intClass;
    }

    public IntObject getIntObject() {
        return intObject;
    }

    public void setIntObject(IntObject intObject) {
        this.intObject = intObject;
    }

    @Override
    public String toString() {
        return "IntPlayer{" +
                "intClass=" + intClass +
                ", intObject=" + intObject +
                '}';
    }
}
