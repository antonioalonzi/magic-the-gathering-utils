package com.aa.mtg.deckbox.parser;

import com.aa.mtg.collection.CardsCollection;
import com.aa.mtg.exception.HandledException;

import java.io.InputStream;

public interface CardsListParser {

    CardsCollection parse(String file) throws HandledException;

    CardsCollection parse(InputStream fileInputStream) throws HandledException;

}
