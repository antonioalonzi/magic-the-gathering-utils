package com.aa.mtg.deckbox.card;

import java.util.List;

public class Card {

    private final String name;
    private final List<Type> types;
    private final Rarity rarity;

    Card(String name, List<Type> types, Rarity rarity) {
        this.name = name;
        this.types = types;
        this.rarity = rarity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Card card = (Card) o;

        if (name != null ? !name.equals(card.name) : card.name != null) {
            return false;
        }
        if (types != null ? !types.equals(card.types) : card.types != null) {
            return false;
        }
        return rarity == card.rarity;

    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", types=" + types +
                ", rarity=" + rarity +
                '}';
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (types != null ? types.hashCode() : 0);
        result = 31 * result + (rarity != null ? rarity.hashCode() : 0);
        return result;
    }
}
