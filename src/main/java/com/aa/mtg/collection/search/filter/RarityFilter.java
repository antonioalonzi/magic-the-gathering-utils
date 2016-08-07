package com.aa.mtg.collection.search.filter;

import com.aa.mtg.card.Card;
import com.aa.mtg.card.Rarity;

import java.util.List;

import static java.util.Arrays.asList;

public class RarityFilter implements SearchFilter {

    private List<Rarity> rarity;

    private RarityFilter(Rarity ...rarity) {
        this.rarity = asList(rarity);
    }

    public static RarityFilter rarity(Rarity ...rarity) {
        return new RarityFilter(rarity);
    }

    @Override
    public boolean test(Card card) {
        return rarity.contains(card.getRarity());
    }
}
