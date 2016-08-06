package com.aa.mtg.card;

public enum Type {
    BASIC_LAND("Basic Land"),
    LAND("Land"),
    INSTANT("Instant"),
    SORCERY("Sorcery"),
    ENCHANTMENT("Enchantment"),
    ARTIFACT("Artifact"),
    LEGENDARY_CREATURE("Legendary Creature"),
    CREATURE("Creature"),
    PLANESWALKER("Planeswalker");

    private String description;

    Type(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
