package tests.unit.deckbox.parser;

import com.aa.mtg.collection.CardsCollection;
import com.aa.mtg.deckbox.parser.CardsListCsvParser;
import org.junit.Test;
import utils.Cards;

import java.io.InputStream;
import java.util.ArrayList;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;

public class CardsListCsvParserTest {

    @Test
    public void shouldLoadExportedCardsFromDeckbox() {
        // given
        InputStream fileInputStream = CardsListCsvParserTest.class.getResourceAsStream("/deckbox/parser/extracted-file.csv");

        // when
        CardsCollection cardsCollection = new CardsListCsvParser().parse(fileInputStream);

        // then
        ArrayList<Object> expectedCardList = new ArrayList<>();
        expectedCardList.add(Cards.ABBOT_OF_KERAL_KEEP);
        expectedCardList.add(Cards.ACCURSED_SPIRIT);
        expectedCardList.add(Cards.ACT_OF_TREASON);
        expectedCardList.add(Cards.ACT_OF_TREASON);
        expectedCardList.add(Cards.ACT_OF_TREASON);
        expectedCardList.add(Cards.ACT_OF_TREASON);
        expectedCardList.add(Cards.ACT_OF_TREASON);
        expectedCardList.add(Cards.DWYEN_GILT_LEAF_DEAN);
        expectedCardList.add(Cards.FIELD_CREEPER);
        expectedCardList.add(Cards.HANGARBACK_WALKER);
        expectedCardList.add(Cards.SKYRIDER_ELF);
        expectedCardList.add(Cards.SIEGECRAFT);
        expectedCardList.add(Cards.TAMIYO_FIELD_RESEARCHER);
        expectedCardList.add(Cards.SWELL_OF_GROWTH);
        expectedCardList.add(Cards.SWELL_OF_GROWTH);
        expectedCardList.add(Cards.SWELL_OF_GROWTH);
        expectedCardList.add(Cards.SWELL_OF_GROWTH);
        expectedCardList.add(Cards.SWAMP);
        expectedCardList.add(Cards.SWAMP);
        expectedCardList.add(Cards.SWAMP);
        expectedCardList.add(Cards.SWAMP);
        expectedCardList.add(Cards.SWAMP);
        expectedCardList.add(Cards.TEMPLE_OF_DECEIT);
        assertThat(cardsCollection.getcardsList(), sameBeanAs(expectedCardList));
    }

}