package com.aa.mtg.deckbox.parser;

import com.aa.mtg.collection.CardsCollection;

import java.io.IOException;
import java.io.InputStream;

public interface CardListParser {

    CardsCollection parse(InputStream fileInputStream) throws IOException;

}
