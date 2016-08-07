package com.aa.mtg.collection;

import com.aa.mtg.card.Card;

import java.util.List;

public class CardCollection {

    private final List<Card> cardList;

    public CardCollection(List<Card> cardList) {
        this.cardList = cardList;
    }

    public List<Card> getCardList() {
        return cardList;
    }
}
