package com.aa.mtg;

import com.aa.mtg.collection.CardCollection;
import com.aa.mtg.console.Console;
import com.aa.mtg.deckbox.parser.CardListParser;
import com.aa.mtg.playingset.generator.BoosterGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;

import static com.aa.mtg.playingset.generator.BoosterGenerator.BOOSTER_GENERATOR_COMMAND;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private CardListParser cardListParser;

    @Autowired
    private BoosterGenerator boosterGenerator;

    @Autowired
    private Console console;

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
        SpringApplication.run(Main.class, args);
    }

    public void run(String... args) throws Exception {
        if (args[0].equals(BOOSTER_GENERATOR_COMMAND)) {
            CardCollection cardCollection = cardListParser.parse(new FileInputStream(args[1]));
            boosterGenerator.generateBoosters(cardCollection, 1);
        }
    }
}
