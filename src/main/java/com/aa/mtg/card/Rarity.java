package com.aa.mtg.card;

public enum Rarity {
    BASIC_LAND("BasicLand"),
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
