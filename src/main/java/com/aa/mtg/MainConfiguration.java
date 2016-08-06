package com.aa.mtg;

import com.aa.mtg.deck.DeckFactory;
import com.aa.mtg.deck.shuffler.DeckShuffler;
import com.aa.mtg.deck.shuffler.JavaCollectionsDeckShuffler;
import com.aa.mtg.playingsetgenerators.BoosterGenerator;
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

}