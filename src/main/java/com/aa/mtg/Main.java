package com.aa.mtg;

import com.aa.mtg.console.Console;
import com.aa.mtg.deckbox.parser.CardsListParser;
import com.aa.mtg.exception.HandledException;
import com.aa.mtg.utility.Utility;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final CardsListParser cardsListParser;
    private final List<Utility> utilities;
    private final Console console;

    public Main(CardsListParser cardsListParser, List<Utility> utilities, Console console) {
        this.cardsListParser = cardsListParser;
        this.utilities = utilities;
        this.console = console;
    }

    /**
     * Run the selected application utility.
     * Check "README.md usage" for more info.
     * @param args
     */
    public static void main(String[] args) {
        //SpringApplication.run(Main.class, BOOSTER_GENERATOR_COMMAND, "/home/antonio/Downloads/allMyCards.csv", "6");
        SpringApplication.run(Main.class, args);
    }

    public void run(String ...args) {
        System.out.println("\n\n");
        run(asList(args));
        System.out.println("\n\n");
    }

    private void run(List<String> args) {
        if (args.size() <= 0) {
            console.print(
                    "Missing first argument: you need to specify an utility to run.\n" +
                    possibleUtilities()
            );
            return;
        }

        String utilityCommand = args.get(0);
        List<String> utilityArguments = args.subList(1, args.size());

        // find utility
        Optional<Utility> selectedUtility = utilities
                .stream()
                .filter(utility -> utility.getCommand().equals(utilityCommand))
                .findFirst();

        // run utility
        if (selectedUtility.isPresent()) {
            try {
                selectedUtility.get().run(utilityArguments);

            } catch (HandledException e) {
                console.print(e.getMessage() + "\n");
            }

        } else {
            printUtilityNotFoundError(utilityCommand);
        }
    }

    private void printUtilityNotFoundError(String utilityCommand) {
        console.print(
                "Utility '" + utilityCommand + "' not found.\n" +
                 possibleUtilities()
        );
    }

    private String possibleUtilities() {
        StringBuilder stringBuilder = new StringBuilder("Possible utilities are:\n");

        for (Utility utility : utilities) {
            stringBuilder.append(" - ").append(utility.getCommand()).append("\n");
        }

        return stringBuilder.toString();
    }
}
