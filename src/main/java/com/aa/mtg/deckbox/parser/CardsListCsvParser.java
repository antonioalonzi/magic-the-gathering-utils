package com.aa.mtg.deckbox.parser;

import com.aa.mtg.card.Card;
import com.aa.mtg.collection.CardsCollection;
import com.aa.mtg.exception.HandledException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.aa.mtg.card.CardBuilder.cardBuilder;

public class CardsListCsvParser implements CardsListParser {

    public CardsCollection parse(String file) {
        try {
            return parse(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new HandledException("File '" + file + "' not found.");
        }
    }

    public CardsCollection parse(InputStream fileInputStream) {
        List<Card> cardsList = new ArrayList<>();

        Iterable<CSVRecord> records = null;
        try {
            records = CSVFormat.DEFAULT.parse(new InputStreamReader(fileInputStream));
        } catch (IOException e) {
            throw new HandledException("File not readable.");
        }

        // skip file header
        records.iterator().next();

        for (CSVRecord record : records) {
            Card card = cardBuilder()
                    .name(record.get(2))
                    .typesFromString(record.get(15))
                    .rarity(record.get(17))
                    .build();

            int count = Integer.parseInt(record.get(0));
            for (int i = 0; i < count; i++){
                cardsList.add(card);
            }
        }

        return new CardsCollection(cardsList);
    }
}
