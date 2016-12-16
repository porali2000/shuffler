package com.capability;

import com.dto.DeckDto;
import com.models.Deck;
import com.persist.Put;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * Created by Porali_S on 12/15/2016.
 */
@Component
public class UpdateImpl implements Update{

    Put<DeckDto> put;

    @Autowired
    public UpdateImpl(Put<DeckDto> put) {
        this.put = put;
    }

    public Deck updateNamedDeck(String deckName, Deck deck){
        if(StringUtils.isEmpty(deckName) || ObjectUtils.isEmpty(deck))
            return null;
        Deck newDeck = Deck.getNewDeck();
        if(!put.save(new DeckDto(deckName, deck)))
            throw new RuntimeException("Update failed");
        return newDeck;
    }
}
