package com.aa.mtg.deck.shuffler;

import com.aa.mtg.card.Card;

import java.util.Collections;
import java.util.List;

public class JavaCollectionsDeckShuffler implements DeckShuffler {

    public void shuffle(List<Card> cards) {
        Collections.shuffle(cards);
    }

}
