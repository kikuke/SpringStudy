package com.kikuke.toy1.intPlayer;

public interface IntPlayerService {

    /**
     *
     * @param intPlayer
     * @return intPlayer의 클래스에 맞춰 IntObject의 값을 초기화 후 리턴합니다.
     */
    IntPlayer initIntObject(IntPlayer intPlayer, Long id, String name);
}
