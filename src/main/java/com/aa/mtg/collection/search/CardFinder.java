package com.aa.mtg.collection.search;

import com.aa.mtg.card.Card;
import com.aa.mtg.collection.CardCollection;
import com.aa.mtg.collection.search.filter.SearchFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardFinder {

    private List<SearchFilter> filters;
    private CardCollection cardCollection;

    private CardFinder(CardCollection cardCollection) {
        this.cardCollection = cardCollection;
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

    public static CardFinder search(CardCollection cardCollection) {
        return new CardFinder(cardCollection);
    }

    public List<Card> fetchAll() {
        Stream<Card> stream = cardCollection.getCardList().stream();

        for (SearchFilter filter : filters) {
            stream = stream.filter(filter);
        }

        return stream.collect(Collectors.toList());
    }
}
