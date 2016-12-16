package com.unittest;

import com.capability.Create;
import com.capability.Fetch;
import com.capability.Shuffle;
import com.capability.SimpleShuffle;
import com.init.TestRunner;
import com.models.Deck;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Porali_S on 12/15/2016.
 */
@ActiveProfiles(profiles = "simple")
public class TestSimpleShuffleCapability extends TestRunner {

    @Autowired
    Create create;
    @Autowired
    Fetch fetch;
    @Autowired
    Shuffle shuffle;


    @Test
    public void test_dependency_injection() {
        assertNotNull(create);
        assertNotNull(fetch);
        assertNotNull(shuffle);
    }

    @Test
    public void simple_shuffle_algo_should_be_injected() {
        assertTrue(shuffle instanceof SimpleShuffle);
    }

    @Test
    public void shuffle_the_card_and_verify() {
        try {
            List decks = new ArrayList();
            decks.add(create.createStandardDeckWithName("SimpleShuffleDeck"));
            assertNotNull(fetch.fetchDeckWithName("SimpleShuffleDeck"));
            verifyDeck(this.shuffle.shuffle(decks));
        }catch (Exception e){
            fail("Unexpected exception occurred with error message : " +  e.getMessage());
        }
    }

    @Test
    public void reshuffle_the_card_and_verify() {
        try {
            List decks = new ArrayList();
            decks.add(create.createStandardDeckWithName("SimpleShuffleDeck"));
            assertNotNull(fetch.fetchDeckWithName("SimpleShuffleDeck"));
            List<Deck> shuffledDecks = this.shuffle.shuffle(decks);
            assertNotNull(shuffledDecks);
            verifyDeck(this.shuffle.shuffle(decks));
            System.out.println(shuffledDecks);
            System.out.println("[                           ] ");
            verifyDeck(this.shuffle.shuffle(decks));
            System.out.println(shuffledDecks);
            System.out.println("[                           ] ");
            verifyDeck(this.shuffle.shuffle(decks));
            System.out.println(shuffledDecks);
            System.out.println("[                           ] ");
            verifyDeck(this.shuffle.shuffle(decks));
            System.out.println(shuffledDecks);
            System.out.println("[                           ] ");
        }catch (Exception e){
            fail("Unexpected exception occurred with error message : " +  e.getMessage());
        }
    }


}
