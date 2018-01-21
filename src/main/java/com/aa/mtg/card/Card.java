package com.aa.mtg.card;

import java.util.List;

public class Card {

    private final String name;
    private final List<Type> types;
    private final Rarity rarity;
    private final Edition edition;

    Card(String name, List<Type> types, Rarity rarity, Edition edition) {
        this.name = name;
        this.types = types;
        this.rarity = rarity;
        this.edition = edition;
    }

    public String getName() {
        return name;
    }

    public List<Type> getTypes() {
        return types;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public Edition getEdition() {
        return edition;
    }
}
