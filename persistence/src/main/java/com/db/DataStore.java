package com.db;

import com.dto.Dto;
import com.models.Deck;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Porali_S on 12/15/2016.
 */

public interface DataStore {

    Map<String, Deck> STORED_DATAS = new HashMap();

    boolean merge(Dto dto);

    boolean delete(String deckName);

    Deck fetch(String deckName);

    List<String> fetchAll();
}
