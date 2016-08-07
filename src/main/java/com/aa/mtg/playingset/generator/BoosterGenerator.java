package com.aa.mtg.playingset.generator;

import com.aa.mtg.booster.Booster;
import com.aa.mtg.card.Card;
import com.aa.mtg.card.Rarity;
import com.aa.mtg.collection.CardCollection;
import com.aa.mtg.shuffler.CardsShuffler;

import java.util.ArrayList;
import java.util.List;

import static com.aa.mtg.card.Rarity.*;
import static com.aa.mtg.collection.search.CardFinder.search;
import static com.aa.mtg.collection.search.filter.RarityFilter.rarity;

public class BoosterGenerator {

    public static final String BOOSTER_GENERATOR_COMMAND = "booster-generator";

    private final CardsShuffler cardsShuffler;

    public BoosterGenerator(CardsShuffler cardsShuffler) {
        this.cardsShuffler = cardsShuffler;
    }

    public List<Booster> generateBoosters(CardCollection cardCollection, int numOfBoosters) {
        ArrayList<Booster> boosters = new ArrayList<>();

        for (int i = 0; i < numOfBoosters; i++) {
            Booster booster = generateBooster(cardCollection);
            cardCollection.removeCards(booster.getCardList());
            boosters.add(booster);
        }

        return boosters;
    }

    private Booster generateBooster(CardCollection cardCollection) {
        List<Card> boosterCards = new ArrayList<>();

        boosterCards.addAll(selectNCardsByRarity(cardCollection, 1, MYTHIC_RARE, RARE));
        boosterCards.addAll(selectNCardsByRarity(cardCollection, 3, UNCOMMON));
        boosterCards.addAll(selectNCardsByRarity(cardCollection, 10, COMMON));
        boosterCards.addAll(selectNCardsByRarity(cardCollection, 1, BASIC_LAND));

        return new Booster(boosterCards);
    }

    private List<Card> selectNCardsByRarity(CardCollection cardCollection, int n, Rarity...rarity) {
        List<Card> selectedCards = new ArrayList<>(n);

        List<Card> allCardsByRarity = search(cardCollection)
                .by(rarity(rarity))
                .fetchAll();

        cardsShuffler.shuffle(allCardsByRarity);

        for (int i = 0; i < n; i++) {
            selectedCards.add(allCardsByRarity.remove(0));
        }

        return selectedCards;
    }
}
