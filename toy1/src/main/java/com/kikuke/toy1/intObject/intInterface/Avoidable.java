package com.kikuke.toy1.intObject.intInterface;

import com.kikuke.toy1.intObject.IntObject;

public interface Avoidable {

    /**
     *
     * @param attackObj 공격을 가한 오브젝트
     * @param avoidObj 회피를 하는 오브젝트
     * @return 회피 성공시 true, 실패시 false
     */
    boolean avoid(IntObject attackObj, IntObject avoidObj);
}
