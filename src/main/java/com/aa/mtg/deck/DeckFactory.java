package com.aa.mtg.deck;

import com.aa.mtg.card.Card;
import com.aa.mtg.deck.shuffler.DeckShuffler;

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
}
