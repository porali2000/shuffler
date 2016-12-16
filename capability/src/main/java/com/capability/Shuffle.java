package com.capability;

import com.models.Deck;

import java.util.List;

/**
 * Created by Porali_S on 12/15/2016.
 */
public interface Shuffle {

    List<Deck> shuffle(List<Deck> decks);
}
