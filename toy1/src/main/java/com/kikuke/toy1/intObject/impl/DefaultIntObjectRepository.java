package com.kikuke.toy1.intObject.impl;

import com.kikuke.toy1.intObject.IntObject;
import com.kikuke.toy1.intObject.IntObjectRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DefaultIntObjectRepository implements IntObjectRepository {

    private static Map<Long, IntObject> store = new HashMap<>();

    @Override
    public void save(IntObject intObject) {
        store.put(intObject.getId(), intObject);
    }

    @Override
    public IntObject findById(Long id) {
        return store.get(id);
    }
}
