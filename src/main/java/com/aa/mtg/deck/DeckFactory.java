package com.aa.mtg.deck;

import com.aa.mtg.card.Card;
import com.aa.mtg.shuffler.CardsShuffler;

import java.util.List;

public class DeckFactory {

    private final CardsShuffler cardsShuffler;

    public DeckFactory(CardsShuffler cardsShuffler) {
        this.cardsShuffler = cardsShuffler;
    }

    public Deck createDeck(List<Card> cards) {
        Deck deck = new Deck(cards);
        deck.setShuffler(cardsShuffler);
        deck.shuffle();
        return deck;
    }
}
