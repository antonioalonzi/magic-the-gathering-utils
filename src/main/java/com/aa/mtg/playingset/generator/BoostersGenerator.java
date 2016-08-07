package com.aa.mtg.playingset.generator;

import com.aa.mtg.booster.Booster;
import com.aa.mtg.card.Card;
import com.aa.mtg.card.Rarity;
import com.aa.mtg.collection.CardsCollection;
import com.aa.mtg.shuffler.CardsShuffler;

import java.util.ArrayList;
import java.util.List;

import static com.aa.mtg.card.Rarity.*;
import static com.aa.mtg.collection.search.CardFinder.search;
import static com.aa.mtg.collection.search.filter.RarityFilter.rarity;

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
            cardsCollection.removeCards(booster.getCardList());
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

    private List<Card> selectNCardsByRarity(CardsCollection cardsCollection, int n, Rarity...rarity) {
        List<Card> selectedCards = new ArrayList<>(n);

        List<Card> allCardsByRarity = search(cardsCollection)
                .by(rarity(rarity))
                .fetchAll();

        cardsShuffler.shuffle(allCardsByRarity);

        for (int i = 0; i < n; i++) {
            selectedCards.add(allCardsByRarity.remove(0));
        }

        return selectedCards;
    }
}
