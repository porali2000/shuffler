package com.db;

import com.dto.Dto;
import com.models.Deck;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Porali_S on 12/15/2016.
 */

//This will leverage us to change to any other data store in feature
@Component("memoryDataStore")
public class MemoryDataStoreImpl implements DataStore {

    static Map<String, Deck> STORED_DATAS = new HashMap();

    public synchronized boolean merge(Dto dto) {
        try {
            STORED_DATAS.put(dto.getDeckName(), dto.getDeck());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public synchronized boolean delete(String deckName) {
        try {
            STORED_DATAS.remove(deckName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public synchronized Deck fetch(String deckName) {
        try {
            return STORED_DATAS.get(deckName);
        } catch (Exception e) {
            return null;
        }
    }

    public synchronized List<String> fetchAll() {
        try {
            return STORED_DATAS.keySet().stream().collect(Collectors.toList());
        } catch (Exception e) {
            return null;
        }
    }
}
