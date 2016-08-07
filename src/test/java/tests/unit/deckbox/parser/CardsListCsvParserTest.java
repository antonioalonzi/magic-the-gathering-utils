package tests.unit.deckbox.parser;

import com.aa.mtg.collection.CardsCollection;
import com.aa.mtg.deckbox.parser.CardsListCsvParser;
import org.junit.Test;
import utils.Cards;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CardsListCsvParserTest {

    @Test
    public void shouldLoadExportedCardsFromDeckbox() throws Exception {
        // given
        InputStream fileInputStream = CardsListCsvParserTest.class.getResourceAsStream("/deckbox/parser/extracted-file.csv");

        // when
        CardsCollection cardsCollection = new CardsListCsvParser().parse(fileInputStream);

        // then
        assertThat(cardsCollection.getcardsList()).containsExactly(
                Cards.ABBOT_OF_KERAL_KEEP,
                Cards.ACCURSED_SPIRIT,
                Cards.ACT_OF_TREASON,
                Cards.ACT_OF_TREASON,
                Cards.ACT_OF_TREASON,
                Cards.ACT_OF_TREASON,
                Cards.ACT_OF_TREASON,
                Cards.DWYEN_GILT_LEAF_DEAN,
                Cards.FIELD_CREEPER,
                Cards.HANGARBACK_WALKER,
                Cards.SKYRIDER_ELF,
                Cards.SIEGECRAFT,
                Cards.TAMIYO_FIELD_RESEARCHER,
                Cards.SWELL_OF_GROWTH,
                Cards.SWELL_OF_GROWTH,
                Cards.SWELL_OF_GROWTH,
                Cards.SWELL_OF_GROWTH,
                Cards.SWAMP,
                Cards.SWAMP,
                Cards.SWAMP,
                Cards.SWAMP,
                Cards.SWAMP,
                Cards.TEMPLE_OF_DECEIT
        );
    }

}