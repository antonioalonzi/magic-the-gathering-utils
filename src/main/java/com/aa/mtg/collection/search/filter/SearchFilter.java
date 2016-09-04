package com.aa.mtg.collection.search.filter;

import com.aa.mtg.card.Card;

import java.util.Objects;
import java.util.function.Predicate;

public interface SearchFilter extends Predicate<Card> {

    default SearchFilter and(SearchFilter nextSearchFilter) {
        Objects.requireNonNull(nextSearchFilter);
        return (currentSearchFilter) ->
                this.test(currentSearchFilter) && nextSearchFilter.test(currentSearchFilter);
    }
}
