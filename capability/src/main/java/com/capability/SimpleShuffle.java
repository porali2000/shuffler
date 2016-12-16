package com.capability;

import com.models.Deck;
import com.models.Card;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by Porali_S on 12/15/2016.
 */
@Component
@Profile("simple")
public class SimpleShuffle implements Shuffle  {

    @Override
    public List<Deck> shuffle(List<Deck> decks) {

        //For `n` no of decks, collect all cards in to a list
        decks.parallelStream()
                .map(deck -> deck.getCards())
                .collect(Collectors.toList()).forEach(cards -> {
                swap(cards);
        });
        return decks;
    }


    /**
     * Method used to swap the card
     *
     * @param cards
     */
    private void swap(List<Card> cards) {
        for(Card card:cards){
            int randomIndex = new Random().nextInt(52);
            //Pick random card from deck
            Card randomCard = cards.get(randomIndex);
            //Swap random card from deck
            Card tempCard = randomCard.clone();
            randomCard.setRank(card.getRank());
            randomCard.setSuit(card.getSuit());
            //Swap the card
            card.setRank(tempCard.getRank());
            card.setSuit(tempCard.getSuit());
        }
    }
}
