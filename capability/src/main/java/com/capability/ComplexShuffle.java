package com.capability;

import com.models.Card;
import com.models.Deck;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Porali_S on 12/15/2016.
 */
@Component
@Profile("complex")
public class ComplexShuffle implements Shuffle {


    /**
     * This method stimulates the human hand shuffling nature
     * It splits approx by middle and start recursively split until the hand reaches least capacity
     *
     * @param decks
     * @return
     */
    @Override
    public List<Deck> shuffle(List<Deck> decks) {

        //For each deck we have
        decks.forEach(deck -> {
            List<Card> cards = deck.getCards();
            Random random = new Random(System.currentTimeMillis());

            //Rifle shuffle
            cards = rifleShuffle(cards.subList(0, (cards.size() / 2)), cards.subList(cards.size() / 2, cards.size()));

            int randomShuffleTimes = 7 + random.nextInt(3);
            for (int i = 0; i < randomShuffleTimes; i++){

                //Make the split
                int randomSplitPoint = random.nextInt(52); //selecting a random number to split the deck of cards
                List<Card> secondHalf = cards.subList(randomSplitPoint, cards.size());
                List<Card> firstHalf = cards.subList(0, randomSplitPoint);

                //Keep splitting the cards
                secondHalf = recursiveSplit(secondHalf);

                //Stack the splits bottom to top
                List<Card> tempCards = new ArrayList<>();
                tempCards.addAll(secondHalf);
                tempCards.addAll(firstHalf);
                cards = tempCards;
            }

            //Do Riffle Shuffle
            cards = rifleShuffle(cards.subList(0, (cards.size() / 2)), cards.subList(cards.size() / 2, cards.size()));
            deck.setCards(cards);
        });
        return decks;
    }

    /**
     * Method used to simulate the riffle shuffle
     *
     * @param firstHalf
     * @param secondHalf
     * @return
     */
    private List<Card> rifleShuffle(List<Card> firstHalf, List<Card> secondHalf) {
        List<Card> shuffledCards = new ArrayList<>();
        for (int i = 0, k = 0; i < firstHalf.size(); i++) {
            shuffledCards.add(k++, firstHalf.get(i));
            shuffledCards.add(k++, secondHalf.get(i));
        }
        return shuffledCards;
    }

    /**
     * Method used to simulate the hand split recursively and apply the shuffle
     *
     * @param secondHalf
     * @return
     */
    private List<Card> recursiveSplit(List<Card> secondHalf) {
        Random random = new Random();
        int leastCapacity = random.nextInt(3);

        //If the hand capacity is least return whatever we got
        if (secondHalf.size() < leastCapacity) {
            return secondHalf;
        } else {
            int splitPoint = random.nextInt(secondHalf.size());
            List<Card> seconds_firstHalf = secondHalf.subList(0, splitPoint);
            List<Card> seconds_secondHalf = secondHalf.subList(splitPoint, secondHalf.size());
            seconds_secondHalf = recursiveSplit(seconds_secondHalf);

            List<Card> tempCards = new ArrayList<>();
            tempCards.addAll(seconds_secondHalf);
            tempCards.addAll(seconds_firstHalf);
            return tempCards;
        }
    }
}
