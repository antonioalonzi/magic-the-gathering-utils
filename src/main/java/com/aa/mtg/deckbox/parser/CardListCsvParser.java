package com.aa.mtg.deckbox.parser;

import com.aa.mtg.card.Card;
import com.aa.mtg.collection.CardCollection;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.aa.mtg.card.CardBuilder.cardBuilder;

public class CardListCsvParser implements CardListParser {

    public CardCollection parse(InputStream fileInputStream) throws IOException {
        List<Card> cardList = new ArrayList<>();

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(new InputStreamReader(fileInputStream));

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
                cardList.add(card);
            }
        }

        return new CardCollection(cardList);
    }
}
