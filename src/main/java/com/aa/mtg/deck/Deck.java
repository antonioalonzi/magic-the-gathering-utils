package com.aa.mtg.deck;

import com.aa.mtg.card.Card;
import com.aa.mtg.shuffler.CardsShuffler;

import java.util.List;

public class Deck {

    private CardsShuffler shuffler;

    private final List<Card> cards;

    Deck(List<Card> cards) {
        this.cards = cards;
    }

    void shuffle() {
        shuffler.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(0);
    }

    public int size() {
        return cards.size();
    }

    void setShuffler(CardsShuffler shuffler) {
        this.shuffler = shuffler;
    }
}
