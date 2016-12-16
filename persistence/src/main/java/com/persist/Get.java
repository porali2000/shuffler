package com.persist;

import com.models.Deck;

import java.util.List;

/**
 * Created by Porali_S on 12/15/2016.
 */
public interface Get {
    Deck fetch(String deckName);

    List<String> fetchAll();
}
