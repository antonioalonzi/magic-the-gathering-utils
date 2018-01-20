package com.aa.mtg.playingset.generator;

import com.aa.mtg.booster.Booster;
import com.aa.mtg.booster.BoosterConsoleHelper;
import com.aa.mtg.card.Card;
import com.aa.mtg.card.Rarity;
import com.aa.mtg.collection.CardsCollection;
import com.aa.mtg.console.Console;
import com.aa.mtg.deckbox.parser.CardsListParser;
import com.aa.mtg.exception.HandledException;
import com.aa.mtg.settings.Settings;
import com.aa.mtg.shuffler.CardsShuffler;
import com.aa.mtg.utility.AbstractUtility;
import com.aa.mtg.utility.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static com.aa.mtg.card.Rarity.*;
import static com.aa.mtg.collection.search.CardFinder.search;
import static com.aa.mtg.collection.search.filter.RarityFilter.rarity;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;

public class BoostersGeneratorUtility extends AbstractUtility implements Utility {

    private final Settings settings;
    private final CardsShuffler cardsShuffler;
    private final CardsListParser cardsListParser;
    private final Console console;

    public BoostersGeneratorUtility(Settings settings, CardsShuffler cardsShuffler, CardsListParser cardsListParser, Console console) {
        this.settings = settings;
        this.cardsShuffler = cardsShuffler;
        this.cardsListParser = cardsListParser;
        this.console = console;
    }

    @Override
    public String getCommand() {
        return "booster-generator";
    }

    @Override
    public String usage() {
        return "  booster-generator <numOfBoosters>\n" +
               "     numOfBoosters: number of boosters to generate";
    }

    @Override
    public void run(List<String> args) throws HandledException {
        CardsCollection cardsCollection;
        String collectionFile = settings.getCollectionPath();
        int numOfBoosters = getNumOfBoosters(args);
        cardsCollection = cardsListParser.parse(collectionFile);
        List<Booster> boosters = generateBoosters(cardsCollection, numOfBoosters);
        console.print(BoosterConsoleHelper.toString(boosters));
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
                    throw new HandledException("You don't have enough " + Arrays.toString(rarity) + " cards in your collection.");
                }
            } else {
                selectedCards.add(allCardsByRarity.remove(0));
            }
        }

        return selectedCards;
    }

    private int getNumOfBoosters(List<String> args) {
        if (args.size() <= 0) {
            return 1;
        }

        try {
            int numOfBoosters = parseInt(args.get(0));
            if (numOfBoosters <= 0) {
                throw usageException("numOfBoosters must be a positive number.");
            }

            return numOfBoosters;
        } catch (NumberFormatException e) {
            throw usageException("numOfBoosters is not a valid number.");
        }
    }

}
