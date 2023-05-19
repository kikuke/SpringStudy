package com.kikuke.toy1.intObject.intInterface.impl.defaultImpl;

import com.kikuke.toy1.intObject.IntObject;
import com.kikuke.toy1.intObject.intInterface.Avoidable;
import org.springframework.stereotype.Component;

@Component
public class DefaultAvoidable implements Avoidable {
    @Override
    public boolean avoid(IntObject attackObj, IntObject avoidObj) {
        float avoidPerHit = avoidObj.getAvoidance() / attackObj.getHitRate() * 100;
        
        //랜덤으로 하면 좋지만
        //위 퍼센트가 0.7를 넘어가면 회피로 판정
        if(avoidPerHit > 0.7)
            return true;
        return false;
    }
}
