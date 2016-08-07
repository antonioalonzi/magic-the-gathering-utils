package com.aa.mtg.collection.search.filter;

import com.aa.mtg.card.Card;

public class NameFilter implements SearchFilter {

    private String name;

    private NameFilter(String name) {
        this.name = name;
    }

    public static NameFilter name(String name) {
        return new NameFilter(name);
    }

    @Override
    public boolean test(Card card) {
        return card.getName().toLowerCase().contains(name.toLowerCase());
    }
}
