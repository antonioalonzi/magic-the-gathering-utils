package com.aa.mtg.playingset.generator;

import com.aa.mtg.booster.Booster;
import com.aa.mtg.card.Card;
import com.aa.mtg.card.Rarity;
import com.aa.mtg.collection.CardsCollection;
import com.aa.mtg.shuffler.CardsShuffler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static com.aa.mtg.card.Rarity.*;
import static com.aa.mtg.collection.search.CardFinder.search;
import static com.aa.mtg.collection.search.filter.RarityFilter.rarity;
import static java.util.Arrays.asList;

public class BoostersGenerator {

    public static final String BOOSTER_GENERATOR_COMMAND = "booster-generator";

    private final CardsShuffler cardsShuffler;

    public BoostersGenerator(CardsShuffler cardsShuffler) {
        this.cardsShuffler = cardsShuffler;
    }

    public List<Booster> generateBoosters(CardsCollection cardsCollection, int numOfBoosters) {
        ArrayList<Booster> boosters = new ArrayList<>();

        for (int i = 0; i < numOfBoosters; i++) {
            Booster booster = generateBooster(cardsCollection);
            cardsCollection.removeCards(booster.getcardsList());
            boosters.add(booster);
        }

        return boosters;
    }

    private Booster generateBooster(CardsCollection cardsCollection) {
        List<Card> boosterCards = new ArrayList<>();

        boosterCards.addAll(selectNCardsByRarity(cardsCollection, 1, MYTHIC_RARE, RARE));
        boosterCards.addAll(selectNCardsByRarity(cardsCollection, 3, UNCOMMON));
        boosterCards.addAll(selectNCardsByRarity(cardsCollection, 10, COMMON));
        boosterCards.addAll(selectNCardsByRarity(cardsCollection, 1, BASIC_LAND));

        return new Booster(boosterCards);
    }

    private List<Card> selectNCardsByRarity(CardsCollection cardsCollection, int n, Rarity...rarity) throws NoSuchElementException {
        List<Card> selectedCards = new ArrayList<>(n);

        List<Card> allCardsByRarity = search(cardsCollection)
                .by(rarity(rarity))
                .fetchAll();

        cardsShuffler.shuffle(allCardsByRarity);

        for (int i = 0; i < n; i++) {
            if (allCardsByRarity.isEmpty()) {
                if (!asList(rarity).contains(BASIC_LAND)) {
                    throw new NoSuchElementException("You don't have enough " + Arrays.toString(rarity) + " cards in your collection.");
                }
            } else {
                selectedCards.add(allCardsByRarity.remove(0));
            }
        }

        return selectedCards;
    }
}
