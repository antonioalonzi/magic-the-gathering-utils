package com.aa.mtg.deck;

import com.aa.mtg.card.Card;
import com.aa.mtg.deck.shuffler.DeckShuffler;

import java.util.ArrayList;
import java.util.List;

public class DeckFactory {

    private final DeckShuffler defaultDeckShuffler;

    public DeckFactory(DeckShuffler deckShuffler) {
        this.defaultDeckShuffler = deckShuffler;
    }

    public Deck createDeck(List<Card> cards) {
        Deck deck = new Deck(cards);
        deck.setShuffler(defaultDeckShuffler);
        deck.shuffle();
        return deck;
    }

    public Deck createDeck(ArrayList<Card> cards, DeckShuffler deckShuffler) {
        Deck deck = new Deck(cards);
        deck.setShuffler(deckShuffler);
        deck.shuffle();
        return deck;
    }
}
