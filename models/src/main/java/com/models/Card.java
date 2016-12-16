package com.models;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Porali_S on 12/15/2016.
 */
@Getter
@Setter
public class Card {

    Suit suit;
    Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank.getRankName() + " - " + suit.name();
    }

    @Override
    public Card clone() {
        return new Card(this.suit, this.rank);
    }
}
