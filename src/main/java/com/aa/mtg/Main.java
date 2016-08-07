package com.aa.mtg;

import com.aa.mtg.booster.Booster;
import com.aa.mtg.booster.BoosterConsoleHelper;
import com.aa.mtg.collection.CardsCollection;
import com.aa.mtg.console.Console;
import com.aa.mtg.deckbox.parser.CardListParser;
import com.aa.mtg.playingset.generator.BoostersGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.util.List;

import static com.aa.mtg.playingset.generator.BoostersGenerator.BOOSTER_GENERATOR_COMMAND;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final CardListParser cardListParser;
    private final BoostersGenerator boostersGenerator;
    private final Console console;

    public Main(CardListParser cardListParser, BoostersGenerator boostersGenerator, Console console) {
        this.cardListParser = cardListParser;
        this.boostersGenerator = boostersGenerator;
        this.console = console;
    }

    /**
     * Run the selected application utility.
     *
     * Not yet properly implemented.
     * Currently arguments can be modified only by modifying the main class.
     * @param args
     *   The first argument is the utility to run.
     *   All the other arguments represent the arguments for that utility.
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, BOOSTER_GENERATOR_COMMAND, "~/Downloads/allMyCards.csv");
    }

    public void run(String... args) throws Exception {
        if (args[0].equals(BOOSTER_GENERATOR_COMMAND)) {
            CardsCollection cardsCollection = cardListParser.parse(new FileInputStream(args[1]));
            List<Booster> boosters = boostersGenerator.generateBoosters(cardsCollection, 1);
            console.print(BoosterConsoleHelper.toString(boosters));
        }
    }
}
