package com.aa.mtg.collection;

import com.aa.mtg.card.Card;

import java.util.List;

public class CardsCollection {

    private final List<Card> cardList;

    public CardsCollection(List<Card> cardList) {
        this.cardList = cardList;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void removeCards(List<Card> cardList) {
        cardList.forEach(this.cardList::remove);
    }
}
