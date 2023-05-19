package com.kikuke.toy1.intObject.intInterface;

import com.kikuke.toy1.intObject.IntObject;

public interface Deffensible {
    
    /**
     *
     * @param attackObj 공격을 가한 오브젝트
     * @param deffenceObj 방어를 하는 오브젝트
     * @return 방어한 뒤 받게되는 데미지 결과 값 리턴
     */
    float deffence(IntObject attackObj, IntObject deffenceObj);
}
