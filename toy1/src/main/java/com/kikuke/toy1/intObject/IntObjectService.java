package com.kikuke.toy1.intObject;

import com.kikuke.toy1.intObject.intInterface.Attackable;
import com.kikuke.toy1.intObject.intInterface.Avoidable;
import com.kikuke.toy1.intObject.intInterface.Deadable;
import com.kikuke.toy1.intObject.intInterface.Deffensible;

public interface IntObjectService extends Attackable, Avoidable, Deadable, Deffensible {
}
