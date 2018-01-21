package com.aa.mtg.collection.search.filter;

import com.aa.mtg.card.Card;
import com.aa.mtg.card.Edition;
import com.aa.mtg.card.Rarity;

import java.util.List;

import static java.util.Arrays.asList;

public class EditionFilter implements SearchFilter {

    private List<Edition> editions;

    private EditionFilter(Edition ...editions) {
        this.editions = asList(editions);
    }

    public static EditionFilter edition(Edition ...editions) {
        return new EditionFilter(editions);
    }

    public static EditionFilter edition(List<Edition> editions) {
        return new EditionFilter(editions.toArray(new Edition[editions.size()]));
    }

    @Override
    public boolean test(Card card) {
        return editions.stream()
                .map(Edition::getDescription)
                .anyMatch(edition -> edition.equals(card.getEdition().getDescription()));
    }
}
