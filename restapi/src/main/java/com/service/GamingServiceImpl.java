package com.service;

import com.capability.*;
import com.models.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

/**
 * Created by Porali_S on 12/15/2016.
 */
@Service
public class GamingServiceImpl implements GamingService{

    Create create;
    Fetch fetch;
    Purge purge;
    Update update;
    Shuffle shuffle;

    @Autowired
    public GamingServiceImpl(Create create, Fetch fetch, Purge purge, Shuffle shuffle, Update update) {
        this.create = create;
        this.fetch = fetch;
        this.purge = purge;
        this.shuffle = shuffle;
        this.update = update;
    }



    @Override
    public boolean putNewNamedDeck(String deckName) {
        if(StringUtils.isEmpty(deckName))
        return false;
        create.createStandardDeckWithName(deckName);
        return true;
    }

    @Override
    public boolean purgeNamedDeck(String deckName) {
        if(StringUtils.isEmpty(deckName))
            return false;
        return purge.purgeNamedDeck(deckName);
    }

    @Override
    public Deck getNamedDeck(String deckName) {
        if(StringUtils.isEmpty(deckName))
            return null;

        return fetch.fetchDeckWithName(deckName);
    }

    @Override
    public  List<Deck> shuffleExistingNamedDeck(String deckName) {
        if(StringUtils.isEmpty(deckName))
            return null;
        List<Deck> decks = new ArrayList<>();

        //Fetch deck from datastore
        Deck deck = fetch.fetchDeckWithName(deckName);
        if(ObjectUtils.isEmpty(deck)){
            throw new RuntimeException("Deck not found ");
        }
        decks.add(deck);

        //Do shuffle
        List<Deck> shuffle = this.shuffle.shuffle(decks);

        //update shuffled
        this.update.updateNamedDeck(deckName, deck);
        return shuffle;
    }

    @Override
    public List<String> getPersistedDecks() {
        return fetch.fetchAllDecks();
    }
}
