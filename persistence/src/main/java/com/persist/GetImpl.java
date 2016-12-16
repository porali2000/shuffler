package com.persist;

import com.db.DB;
import com.dto.DeckDto;
import com.models.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Porali_S on 12/15/2016.
 */
@Component
public class GetImpl implements Get{
    @Autowired
    DB<DeckDto> database;


    public Deck fetch(String deckName){
        return database.fetch(deckName);
    }

    @Override
    public List<String> fetchAll() {
        return database.fetchAll();
    }
}
