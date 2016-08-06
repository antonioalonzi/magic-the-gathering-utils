package com.aa.mtg.card;

public enum Rarity {
    UNCOMMON("Uncommon"),
    COMMON("Common"),
    RARE("Rare"),
    MYTHIC_RARE("MythicRare");



    private String description;

    Rarity(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
