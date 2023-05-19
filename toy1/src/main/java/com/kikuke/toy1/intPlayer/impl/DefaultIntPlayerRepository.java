package com.kikuke.toy1.intPlayer.impl;

import com.kikuke.toy1.intObject.IntObject;
import com.kikuke.toy1.intObject.IntObjectRepository;
import com.kikuke.toy1.intPlayer.IntPlayer;
import com.kikuke.toy1.intPlayer.IntPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DefaultIntPlayerRepository implements IntPlayerRepository {

    private IntObjectRepository intObjectRepository;
    private static Map<Long, IntPlayer> store = new HashMap<>();

    @Autowired
    public DefaultIntPlayerRepository(IntObjectRepository intObjectRepository) {
        this.intObjectRepository = intObjectRepository;
    }

    @Override
    public void save(IntPlayer intPlayer) {
        intObjectRepository.save(intPlayer.getIntObject());
        store.put(intPlayer.getIntObject().getId(), intPlayer);
    }

    @Override
    public IntPlayer findById(Long id) {
        IntObject intObject = intObjectRepository.findById(id);
        IntPlayer intPlayer = store.get(intObject.getId());
        intPlayer.setIntObject(intObject);

        return intPlayer;
    }
}
