package com.service;

import com.models.Deck;

import java.util.List;

/**
 * Created by Porali_S on 12/15/2016.
 */
public interface GamingService {

    /**
     * Method to create a new deck
     * @param deckName
     * @return
     */
    boolean putNewNamedDeck(String deckName);

    /**
     * Method to purge a named deck
     * @param deckName
     * @return
     */
    boolean purgeNamedDeck(String deckName);

    /**
     * Method to get named deck
     * @param deckName
     * @return
     */
    Deck getNamedDeck(String deckName);

    /**
     * Method to shuffle a named deck
     * @param deckName
     * @return
     */
    List<Deck> shuffleExistingNamedDeck(String deckName);

    /**
     * Method to get all decks
     * @return
     */
    List<String> getPersistedDecks();
}
