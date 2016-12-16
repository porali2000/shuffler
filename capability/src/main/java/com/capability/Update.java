package com.capability;

import com.models.Deck;

/**
 * Created by Porali_S on 12/15/2016.
 */
public interface Update {

    Deck updateNamedDeck(String deckName, Deck deck);
}
