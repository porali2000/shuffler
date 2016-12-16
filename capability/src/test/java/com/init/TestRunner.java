package com.init;

import com.models.Deck;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Porali_S on 12/15/2016.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public abstract class TestRunner {

    protected void verifyDeck(List<Deck> shuffledDecks){
        assertNotNull(shuffledDecks);
        shuffledDecks.forEach(deck -> {
            assertNotNull(deck);
            assertEquals( "Deck size is not 52", 52,deck.getCards().size());
            Set<String> distinctCards = new HashSet<>();
            assertNotNull(deck.getCards());
            deck.getCards().forEach(card ->{
                distinctCards.add(card.toString());
            });
            assertEquals( "Deck size is not 52", 52,distinctCards.size());
        });
    }
}
