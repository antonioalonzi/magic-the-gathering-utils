package com.aa.mtg.deck;

import com.aa.mtg.card.Card;
import com.aa.mtg.deck.shuffler.DeckShuffler;

import java.util.List;

public class Deck {

    private DeckShuffler shuffler;

    private final List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public void shuffle() {
        shuffler.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(0);
    }

    public int size() {
        return cards.size();
    }

    void setShuffler(DeckShuffler shuffler) {
        this.shuffler = shuffler;
    }

    List<Card> getCards() {
        return cards;
    }
}
