package com.kikuke.toy1.intObject;

public interface IntObjectRepository {

    /**
     * 
     * @param intObject
     * @return 없음
     */
    void save(IntObject intObject);

    /**
     * 
     * @param id
     * @return 성공시 IntObject 객체, 실패시 NULL 리턴
     */
    IntObject findById(Long id);
}
