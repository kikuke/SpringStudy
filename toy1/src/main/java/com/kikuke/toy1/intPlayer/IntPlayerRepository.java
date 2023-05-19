package com.kikuke.toy1.intPlayer;

public interface IntPlayerRepository {

    /**
     * 
     * @param intPlayer
     */
    void save(IntPlayer intPlayer);

    /**
     * 
     * @param id
     * @return 해당 id가 있다면 IntPlayer 리턴, 없다면 NULL 리턴
     */
    IntPlayer findById(Long id);
}