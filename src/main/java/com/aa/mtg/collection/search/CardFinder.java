package com.aa.mtg.collection.search;

import com.aa.mtg.card.Card;
import com.aa.mtg.collection.CardsCollection;
import com.aa.mtg.collection.search.filter.SearchFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CardFinder {

    private List<SearchFilter> filters;
    private List<Card> cards;

    private CardFinder(List<Card> cards) {
        this.cards = cards;
        this.filters = new ArrayList<>();
    }

    public CardFinder by(SearchFilter filter) {
        if (!filters.isEmpty()) {
            throw new RuntimeException("Using 'by' but a filter has already been defined. Use 'and' method.");
        }

        filters.add(filter);
        return this;
    }

    public CardFinder and(SearchFilter filter) {
        if (filters.isEmpty()) {
            throw new RuntimeException("Using 'and' but no filter have been defined yet. Use 'by' method instead.");
        }

        filters.add(filter);
        return this;
    }

    public static CardFinder search(CardsCollection cardsCollection) {
        return new CardFinder(cardsCollection.getcardsList());
    }

    public static CardFinder search(List<Card> cards) {
        return new CardFinder(cards);
    }

    public List<Card> fetchAll() {
        return cards.stream()
                .filter(filters.stream().reduce(SearchFilter::and).orElse(card -> true))
                .collect(Collectors.toList());
    }
}
