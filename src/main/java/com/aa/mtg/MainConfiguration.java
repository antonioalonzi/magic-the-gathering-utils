package com.aa.mtg;

import com.aa.mtg.console.Console;
import com.aa.mtg.deck.DeckFactory;
import com.aa.mtg.deckbox.downloader.DeckboxDownloaderUtility;
import com.aa.mtg.deckbox.linker.DeckboxLinkerInfoUtility;
import com.aa.mtg.deckbox.linker.DeckboxLinkerUtility;
import com.aa.mtg.deckbox.parser.CardsListCsvParser;
import com.aa.mtg.deckbox.parser.CardsListParser;
import com.aa.mtg.playingset.generator.BoostersGeneratorUtility;
import com.aa.mtg.settings.Settings;
import com.aa.mtg.shuffler.CardsShuffler;
import com.aa.mtg.shuffler.JavaCollectionsDeckShuffler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {

    @Bean
    public Settings settings(Console console) {
        return new Settings(console);
    }

    @Bean
    public CardsShuffler javaCollectionsDeckShuffler() {
        return new JavaCollectionsDeckShuffler();
    }

    @Bean
    public DeckFactory deckFactory(CardsShuffler cardsShuffler) {
        return new DeckFactory(cardsShuffler);
    }

    @Bean
    public BoostersGeneratorUtility boostersGenerator(Settings settings, CardsShuffler cardsShuffler, CardsListParser cardsListParser, Console console) {
        return new BoostersGeneratorUtility(settings, cardsShuffler, cardsListParser, console);
    }

    @Bean
    public DeckboxLinkerUtility deckboxLinkerUtility(Settings settings, Console console) {
        return new DeckboxLinkerUtility(settings, console);
    }

    @Bean
    public DeckboxLinkerInfoUtility deckboxLinkerInfoUtility(Settings settings, Console console) {
        return new DeckboxLinkerInfoUtility(settings, console);
    }

    @Bean
    public DeckboxDownloaderUtility deckboxDownloaderUtility(Settings settings, Console console) {
        return new DeckboxDownloaderUtility(settings, console);
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
