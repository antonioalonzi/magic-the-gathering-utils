package com.aa.mtg.deckbox.parser;

import com.aa.mtg.card.Card;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface CardListParser {

    List<Card> parse(InputStream fileInputStream) throws IOException;

}
