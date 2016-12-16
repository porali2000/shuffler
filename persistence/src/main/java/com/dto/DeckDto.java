package com.dto;

import com.models.Deck;
import org.springframework.stereotype.Component;

/**
 * Created by Porali_S on 12/15/2016.
 */
public class DeckDto implements Dto {
    String deckName;
    Deck deck;

    public DeckDto(String deckName, Deck deck) {
        this.deckName = deckName;
        this.deck = deck;
    }

    @Override
    public String getDeckName() {
        return this.deckName;
    }

    @Override
    public Deck getDeck() {
        return this.deck;
    }
}
