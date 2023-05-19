package com.kikuke.toy1;

import com.kikuke.toy1.intObject.IntObject;

public interface EnemyGenerator {

    int getLastEnemyNum();

    /**
     * 생성기를 초기화 합니다.
     */
    void InitGenerator();

    /**
     * 초기화 된 생성기를 이용해 적을 리턴합니다.
     * @param id
     * @return 해당 id의 적 리턴
     */
    IntObject generateEnemyById(Long id);
}
