package com.aa.mtg;

import com.aa.mtg.console.Console;
import com.aa.mtg.deck.DeckFactory;
import com.aa.mtg.deckbox.parser.CardsListCsvParser;
import com.aa.mtg.deckbox.parser.CardsListParser;
import com.aa.mtg.playingset.generator.BoostersGenerator;
import com.aa.mtg.shuffler.CardsShuffler;
import com.aa.mtg.shuffler.JavaCollectionsDeckShuffler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {

    @Bean
    public CardsShuffler javaCollectionsDeckShuffler() {
        return new JavaCollectionsDeckShuffler();
    }

    @Bean
    public DeckFactory deckFactory(CardsShuffler cardsShuffler) {
        return new DeckFactory(cardsShuffler);
    }

    @Bean
    public BoostersGenerator boostersGenerator(CardsShuffler cardsShuffler, CardsListParser cardsListParser, Console console) {
        return new BoostersGenerator(cardsShuffler, cardsListParser, console);
    }

    @Bean
    public CardsListParser cardsListParser() {
        return new CardsListCsvParser();
    }

    @Bean
    public Console console() {
        return new Console();
    }

}
