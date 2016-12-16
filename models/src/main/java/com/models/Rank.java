package com.models;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Porali_S on 12/15/2016.
 */
public enum Rank {

    _A("A", 1),
    _2("2", 2),
    _3("3", 3),
    _4("4", 4),
    _5("5", 5),
    _6("6", 6),
    _7("7", 7),
    _8("8", 8),
    _9("9", 9),
    _10("10", 10),
    _J("J", 11),
    _Q("Q", 12),
    _K("K", 13);

    private String rankName;
    private int value;

    Rank(String rankName, int value) {
        this.rankName = rankName;
        this.value = value;
    }

    public String getRankName() {
        return rankName;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.rankName;
    }
}
