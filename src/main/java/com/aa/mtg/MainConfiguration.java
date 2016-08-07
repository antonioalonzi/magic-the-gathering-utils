package com.aa.mtg;

import com.aa.mtg.console.Console;
import com.aa.mtg.deck.DeckFactory;
import com.aa.mtg.deckbox.parser.CardListCsvParser;
import com.aa.mtg.deckbox.parser.CardListParser;
import com.aa.mtg.playingset.generator.BoosterGenerator;
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
    public BoosterGenerator boosterGenerator(CardsShuffler cardsShuffler) {
        return new BoosterGenerator(cardsShuffler);
    }

    @Bean
    public CardListParser cardListParser() {
        return new CardListCsvParser();
    }

    @Bean
    public Console console() {
        return new Console();
    }

}
