package com.capability;

import com.models.Deck;

import java.util.List;

/**
 * Created by Porali_S on 12/15/2016.
 */
public interface Fetch {
    Deck fetchDeckWithName(String deckName);
    List<String> fetchAllDecks();
}
