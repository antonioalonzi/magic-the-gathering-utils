package com.aa.mtg.deck;

import com.aa.mtg.card.Card;
import com.aa.mtg.deck.shuffler.DeckShuffler;
import com.aa.mtg.deck.shuffler.JavaCollectionsShuffler;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private final List<Card> cards;
    private final DeckShuffler shuffler;

    public Deck(ArrayList<Card> cards, DeckShuffler shuffler) {
        this.cards = cards;
        this.shuffler = shuffler;
        shuffle();
    }

    Deck(ArrayList<Card> cards) {
        this(cards, new JavaCollectionsShuffler());
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

    List<Card> getCards() {
        return cards;
    }
}
