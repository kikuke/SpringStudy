package com.kikuke.toy1.intObject.intInterface;

import com.kikuke.toy1.intObject.IntObject;

public interface Deadable {

    /**
     *
     * @param intObject
     * @return 죽었다면 true, 살았다면 false
     */
    boolean isDead(IntObject intObject);
}
