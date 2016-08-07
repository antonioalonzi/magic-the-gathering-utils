package com.aa.mtg.collection;

import com.aa.mtg.card.Card;

import java.util.List;

public class CardsCollection {

    private final List<Card> cardsList;

    public CardsCollection(List<Card> cardsList) {
        this.cardsList = cardsList;
    }

    public List<Card> getcardsList() {
        return cardsList;
    }

    public void removeCards(List<Card> cardsList) {
        cardsList.forEach(this.cardsList::remove);
    }
}
