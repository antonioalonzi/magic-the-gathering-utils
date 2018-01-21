package com.aa.mtg.playingset.generator;

import com.aa.mtg.booster.Booster;
import com.aa.mtg.booster.BoosterConsoleHelper;
import com.aa.mtg.card.Card;
import com.aa.mtg.card.Edition;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.aa.mtg.card.Rarity.*;
import static com.aa.mtg.collection.search.CardFinder.search;
import static com.aa.mtg.collection.search.filter.EditionFilter.edition;
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
        return "generate-booster";
    }

    @Override
    public String usage() {
        return "  generate-booster <numOfBoosters> <editions>\n" +
               "     numOfBoosters: number of boosters to generate    (default 1)\n" +
               "     editions: list of editions comma separated\n" +
               "               eg. \"Magic Origins, Eldritch Moon\"    (default all editions)";
    }

    @Override
    public void run(List<String> args) throws HandledException {
        String collectionFile = settings.getCollectionPath();
        CardsCollection cardsCollection = cardsListParser.parse(collectionFile);

        int numOfBoosters = getNumOfBoosters(args);
        List<Edition> editions = getEditions(args);

        List<Booster> boosters = generateBoosters(cardsCollection, numOfBoosters, editions);

        console.print(BoosterConsoleHelper.toString(boosters));
    }

    public List<Booster> generateBoosters(CardsCollection cardsCollection, int numOfBoosters, List<Edition> editions) {
        ArrayList<Booster> boosters = new ArrayList<>();

        for (int i = 0; i < numOfBoosters; i++) {
            Booster booster = generateBooster(cardsCollection.getcardsList(), editions);
            cardsCollection.removeCards(booster.getcardsList());
            boosters.add(booster);
        }

        return boosters;
    }

    private Booster generateBooster(List<Card> cards, List<Edition> editions) {
        List<Card> boosterCards = new ArrayList<>();

        List<Card> cardsByEdition = selectCardsByEdition(cards, editions);

        boosterCards.addAll(selectNCardsByRarity(cardsByEdition, 1, MYTHIC_RARE, RARE));
        boosterCards.addAll(selectNCardsByRarity(cardsByEdition, 3, UNCOMMON));
        boosterCards.addAll(selectNCardsByRarity(cardsByEdition, 10, COMMON));
        boosterCards.addAll(selectNCardsByRarity(cardsByEdition, 1, BASIC_LAND));

        return new Booster(boosterCards);
    }

    private List<Card> selectCardsByEdition(List<Card> cards, List<Edition> editions) {
        if (editions.size() == 0) {
            return cards;
        } else {
            return search(cards)
                    .by(edition(editions))
                    .fetchAll();
        }
    }

    private List<Card> selectNCardsByRarity(List<Card> cards, int n, Rarity...rarity) throws NoSuchElementException {
        List<Card> selectedCards = new ArrayList<>(n);

        List<Card> cardsByRarity = search(cards)
                .by(rarity(rarity))
                .fetchAll();

        cardsShuffler.shuffle(cardsByRarity);

        for (int i = 0; i < n; i++) {
            if (cardsByRarity.isEmpty()) {
                if (!asList(rarity).contains(BASIC_LAND)) {
                    throw new HandledException("You don't have enough " + Arrays.toString(rarity) + " cards in your collection.");
                }
            } else {
                selectedCards.add(cardsByRarity.remove(0));
            }
        }

        return selectedCards;
    }

    private int getNumOfBoosters(List<String> args) {
        if (args.size() < 1) {
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

    private List<Edition> getEditions(List<String> args) {
        if (args.size() < 2) {
            return new ArrayList<>();

        } else {
            return Stream.of(args.get(1).split(","))
                    .map(Edition::new)
                    .collect(Collectors.toList());
        }
    }
}
