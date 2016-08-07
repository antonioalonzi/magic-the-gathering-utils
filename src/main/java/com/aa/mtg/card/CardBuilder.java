package com.aa.mtg.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.aa.mtg.card.Type.*;

public class CardBuilder {

    private String name;
    private List<Type> types = new ArrayList<>();
    private Rarity rarity;

    public static CardBuilder cardBuilder() {
        return new CardBuilder();
    }

    public Card build() {
        return new Card(name, types, rarity);
    }

    public CardBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CardBuilder typesFromString(String typeString) {
        if (typeString.contains(LAND.getDescription())) {
            types.add(LAND);
        }

        if (typeString.contains(INSTANT.getDescription())) {
            types.add(INSTANT);
        }

        if (typeString.contains(SORCERY.getDescription())) {
            types.add(SORCERY);
        }

        if (typeString.contains(ENCHANTMENT.getDescription())) {
            types.add(ENCHANTMENT);
        }

        if (typeString.contains(ARTIFACT.getDescription())) {
            types.add(ARTIFACT);
        }

        if (typeString.contains(LEGENDARY_CREATURE.getDescription())) {
            types.add(LEGENDARY_CREATURE);
        } else if (typeString.contains(CREATURE.getDescription())) {
            types.add(CREATURE);
        }

        if (typeString.contains(PLANESWALKER.getDescription())) {
            types.add(PLANESWALKER);
        }

        return this;
    }

    public CardBuilder ofTypes(Type...type) {
        types = Arrays.asList(type);
        return this;
    }

    public CardBuilder rarity(Rarity rarity) {
        this.rarity = rarity;
        return this;
    }

    public CardBuilder rarity(String rarity) {
        for (Rarity rarityValue : Rarity.values()) {
            if (rarity.equals(rarityValue.getDescription())) {
                this.rarity = rarityValue;
            }
        }
        return this;
    }
}
