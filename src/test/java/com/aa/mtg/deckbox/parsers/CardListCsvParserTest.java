package com.aa.mtg.deckbox.parsers;

import com.aa.mtg.card.Card;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static com.aa.mtg.cards.Cards.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CardListCsvParserTest {

    @Test
    public void shouldLoadExportedCardsFromDeckbox() throws Exception {
        // given
        InputStream fileInputStream = CardListCsvParserTest.class.getResourceAsStream("/deckbox/extracted-file.csv");

        // when
        List<Card> cardList = new CardListCsvParser().parse(fileInputStream);

        // then
        assertThat(cardList).containsExactly(
                ABBOT_OF_KERAL_KEEP,
                ACCURSED_SPIRIT,
                ACT_OF_TREASON,
                ACT_OF_TREASON,
                ACT_OF_TREASON,
                ACT_OF_TREASON,
                ACT_OF_TREASON,
                DWYEN_GILT_LEAF_DEAN,
                FIELD_CREEPER,
                HANGARBACK_WALKER,
                SKYRIDER_ELF,
                SIEGECRAFT,
                TAMIYO_FIELD_RESEARCHER,
                SWELL_OF_GROWTH,
                SWELL_OF_GROWTH,
                SWELL_OF_GROWTH,
                SWELL_OF_GROWTH,
                SWAMP,
                SWAMP,
                SWAMP,
                SWAMP,
                SWAMP,
                TEMPLE_OF_DECEIT
        );
    }

}