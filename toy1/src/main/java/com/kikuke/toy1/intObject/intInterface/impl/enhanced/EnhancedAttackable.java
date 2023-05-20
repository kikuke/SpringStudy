package com.kikuke.toy1.intObject.intInterface.impl.enhanced;

import com.kikuke.toy1.intObject.IntObject;
import com.kikuke.toy1.intObject.intInterface.Attackable;
import org.springframework.stereotype.Component;

@Component
public class EnhancedAttackable implements Attackable {
    @Override
    public float attack(IntObject intObject) {
        float finalDamage = intObject.getDamage();
        float rand = (float) Math.random() * 100;

        if(rand < intObject.getCritical()){
            finalDamage *= 2;
            if(rand < intObject.getCritical() / 10) {
                finalDamage *= 2;
                System.out.println("더블 크리티컬!");
            } else {
                System.out.println("크리티컬!");
            }
        }

        rand = (float) Math.random() * 100;
        if(rand > intObject.getHitRate()) {
            finalDamage = 0;
            System.out.println("빗나감");
        }

        return finalDamage;
    }
}
