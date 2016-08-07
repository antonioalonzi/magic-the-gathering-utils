package com.aa.mtg.deckbox.parser;

import com.aa.mtg.collection.CardCollection;

import java.io.IOException;
import java.io.InputStream;

public interface CardListParser {

    CardCollection parse(InputStream fileInputStream) throws IOException;

}
