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
                intObject = new IntObject(id, name, 30, 10, 20, 70, 70, 70);
                break;
            case Wizard:
                intObject = new IntObject(id, name, 20, 5, 50, 10, 10, 30);
                break;
            case Warrior:
                intObject = new IntObject(id, name, 100, 30, 15, 30, 20, 50);
                break;
        }
        if(intObject == null)
            return null;

        intPlayer.setIntObject(intObject);
        return intPlayer;
    }
}
