package com.kikuke.toy1.impl;

import com.kikuke.toy1.EnemyGenerator;
import com.kikuke.toy1.intObject.IntObject;
import com.kikuke.toy1.intObject.IntObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultEnemyGenerator implements EnemyGenerator {

    private final IntObjectRepository intObjectRepository;
    private final int lastEnemyNum = 5;

    private IntObject[] enemies= {
            new IntObject(1L, "야생의 적 1", 100, 1, 5, 10, 20, 40),
            new IntObject(2L, "야생의 적 2", 200, 3, 10, 30, 30, 50),
            new IntObject(3L, "중간보스", 500, 5, 20, 50, 40, 70),
            new IntObject(4L, "야생의 적 3", 300, 5, 15, 40, 30, 50),
            new IntObject(5L, "최종보스", 1000, 10, 30, 70, 50, 70),
    };

    @Autowired
    public DefaultEnemyGenerator(IntObjectRepository intObjectRepository) {
        this.intObjectRepository = intObjectRepository;
    }

    @Override
    public void InitGenerator() {
        for(int i = 0; i < lastEnemyNum; i++) {
            intObjectRepository.save(enemies[i]);
        }
    }

    @Override
    public int getLastEnemyNum() {
        return lastEnemyNum;
    }

    @Override
    public IntObject generateEnemyById(Long id) {
        return intObjectRepository.findById(id);
    }
}
