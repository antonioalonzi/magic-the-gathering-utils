package com.aa.mtg.deck;

import com.aa.mtg.card.Card;
import com.aa.mtg.deck.shuffler.DeckShuffler;

import java.util.List;

public class DeckFactory {

    private final DeckShuffler deckShuffler;

    public DeckFactory(DeckShuffler deckShuffler) {
        this.deckShuffler = deckShuffler;
    }

    public Deck createDeck(List<Card> cards) {
        Deck deck = new Deck(cards);
        deck.setShuffler(deckShuffler);
        deck.shuffle();
        return deck;
    }
}
