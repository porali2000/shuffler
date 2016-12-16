package com.capability;

import com.dto.DeckDto;
import com.models.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.persist.Put;

/**
 * Created by Porali_S on 12/15/2016.
 */
@Component
public class CreateImpl implements Create{

    Put<DeckDto> put;

    @Autowired
    public CreateImpl(Put<DeckDto> put) {
        this.put = put;
    }

    @Override
    public Deck createStandardDeckWithName(String deckName) {
        if(StringUtils.isEmpty(deckName))
            return null;
        Deck newDeck = Deck.getNewDeck();
        put.save(new DeckDto(deckName, newDeck));
        return newDeck;
    }
}
