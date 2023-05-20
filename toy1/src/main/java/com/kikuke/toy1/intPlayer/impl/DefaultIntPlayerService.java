package com.kikuke.toy1.intPlayer.impl;

import com.kikuke.toy1.intObject.IntObject;
import com.kikuke.toy1.intPlayer.IntPlayer;
import com.kikuke.toy1.intPlayer.IntPlayerService;
import org.springframework.stereotype.Component;

@Component
public class DefaultIntPlayerService implements IntPlayerService {
    @Override
    public IntPlayer initIntObject(IntPlayer intPlayer, Long id, String name) {
        IntObject intObject = null;

        switch (intPlayer.getIntClass()) {
            case Archer:
                intObject = new IntObject(id, name, 70, 10, 30, 90, 70, 90);
                break;
            case Wizard:
                intObject = new IntObject(id, name, 10, 3, 100, 70, 50, 70);
                break;
            case Warrior:
                intObject = new IntObject(id, name, 300, 50, 70, 30, 30, 95);
                break;
        }
        if(intObject == null)
            return null;

        intPlayer.setIntObject(intObject);
        return intPlayer;
    }
}
