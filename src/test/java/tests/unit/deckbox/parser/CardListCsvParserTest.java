package tests.unit.deckbox.parser;

import com.aa.mtg.card.Card;
import com.aa.mtg.deckbox.parser.CardListCsvParser;
import utils.Cards;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CardListCsvParserTest {

    @Test
    public void shouldLoadExportedCardsFromDeckbox() throws Exception {
        // given
        InputStream fileInputStream = CardListCsvParserTest.class.getResourceAsStream("/deckbox/parser/extracted-file.csv");

        // when
        List<Card> cardList = new CardListCsvParser().parse(fileInputStream);

        // then
        assertThat(cardList).containsExactly(
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