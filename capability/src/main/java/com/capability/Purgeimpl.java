package com.capability;


import com.db.DB;
import com.dto.DeckDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Porali_S on 12/15/2016.
 */
@Component
public class Purgeimpl implements Purge{

    DB<DeckDto> database;

    @Autowired
    public Purgeimpl(DB<DeckDto> database) {
        this.database = database;
    }

    public boolean purgeNamedDeck(String deckName){
        return this.database.purge(deckName);
    }
}
