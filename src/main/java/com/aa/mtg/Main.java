package com.aa.mtg;

import com.aa.mtg.booster.Booster;
import com.aa.mtg.booster.BoosterConsoleHelper;
import com.aa.mtg.collection.CardsCollection;
import com.aa.mtg.console.Console;
import com.aa.mtg.deckbox.parser.CardsListParser;
import com.aa.mtg.playingset.generator.BoostersGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.util.List;

import static com.aa.mtg.playingset.generator.BoostersGenerator.BOOSTER_GENERATOR_COMMAND;
import static java.lang.Integer.parseInt;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final CardsListParser cardsListParser;
    private final BoostersGenerator boostersGenerator;
    private final Console console;

    public Main(CardsListParser cardsListParser, BoostersGenerator boostersGenerator, Console console) {
        this.cardsListParser = cardsListParser;
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
        SpringApplication.run(Main.class, BOOSTER_GENERATOR_COMMAND, "/home/antonio/Downloads/allMyCards.csv", "6");
    }

    public void run(String... args) throws Exception {
        if (args[0].equals(BOOSTER_GENERATOR_COMMAND)) {
            CardsCollection cardsCollection = cardsListParser.parse(new FileInputStream(args[1]));
            List<Booster> boosters = boostersGenerator.generateBoosters(cardsCollection, parseInt(args[2]));
            console.print(BoosterConsoleHelper.toString(boosters));
        }
    }
}
