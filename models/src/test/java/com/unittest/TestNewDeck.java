package com.unittest;

import com.init.TestRunner;
import com.models.Deck;
import com.models.Card;
import com.models.Rank;
import com.models.Suit;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Porali_S on 12/15/2016.
 */
public class TestNewDeck extends TestRunner {

    @Test
    public void testDeckCreation() {
        Deck newDeck = Deck.getNewDeck();
        assertNotNull(newDeck);
    }

    @Test
    public void testDeckIsCreatedInSortedOrder() {
        Deck newDeck = Deck.getNewDeck();
        assertNotNull(newDeck);

        //Verify all spades are sorted
        List<Card> spadePips = newDeck.getCards().stream().filter(card -> card.getSuit().equals(Suit.Spade)).collect(Collectors.toList());
        assertNotNull(spadePips);
        List<Rank> ranks = Arrays.asList(Rank.values());
        for (int i = 0; i < spadePips.size(); i++) {
            assertTrue(ranks.get(i).equals(spadePips.get(i).getRank()));
        }

        //Verify all hearts are sorted
        List<Card> heartPips = newDeck.getCards().stream().filter(card -> card.getSuit().equals(Suit.Hearts)).collect(Collectors.toList());
        assertNotNull(heartPips);
        for (int i = 0; i < heartPips.size(); i++) {
            assertTrue(ranks.get(i).equals(heartPips.get(i).getRank()));
        }

        //Verify all Diamonds are sorted
        List<Card> diamondPips = newDeck.getCards().stream().filter(card -> card.getSuit().equals(Suit.Diamond)).collect(Collectors.toList());
        assertNotNull(diamondPips);
        for (int i = 0; i < diamondPips.size(); i++) {
            assertTrue(ranks.get(i).equals(diamondPips.get(i).getRank()));
        }

        //Verify all Clubs are sorted
        List<Card> clubPips = newDeck.getCards().stream().filter(card -> card.getSuit().equals(Suit.Club)).collect(Collectors.toList());
        assertNotNull(clubPips);
        for (int i = 0; i < clubPips.size(); i++) {
            assertTrue(ranks.get(i).equals(clubPips.get(i).getRank()));
        }
    }
}
