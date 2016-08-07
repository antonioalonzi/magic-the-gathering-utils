package com.aa.mtg;

import com.aa.mtg.console.Console;
import com.aa.mtg.deck.DeckFactory;
import com.aa.mtg.deck.shuffler.DeckShuffler;
import com.aa.mtg.deck.shuffler.JavaCollectionsDeckShuffler;
import com.aa.mtg.deckbox.parser.CardListCsvParser;
import com.aa.mtg.deckbox.parser.CardListParser;
import com.aa.mtg.playingset.generator.BoosterGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {

    @Bean
    public DeckShuffler javaCollectionsDeckShuffler() {
        return new JavaCollectionsDeckShuffler();
    }

    @Bean
    public DeckFactory deckFactory(DeckShuffler deckShuffler) {
        return new DeckFactory(deckShuffler);
    }

    @Bean
    public BoosterGenerator boosterGenerator() {
        return new BoosterGenerator();
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
