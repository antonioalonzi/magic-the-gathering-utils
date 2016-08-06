package com.aa.mtg.deckbox.parsers;

import com.aa.mtg.deckbox.card.Card;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static com.aa.mtg.deckbox.card.CardBuilder.cardBuilder;
import static com.aa.mtg.deckbox.card.Rarity.COMMON;
import static com.aa.mtg.deckbox.card.Rarity.MYTHIC_RARE;
import static com.aa.mtg.deckbox.card.Rarity.RARE;
import static com.aa.mtg.deckbox.card.Rarity.UNCOMMON;
import static com.aa.mtg.deckbox.card.Type.ARTIFACT;
import static com.aa.mtg.deckbox.card.Type.BASIC_LAND;
import static com.aa.mtg.deckbox.card.Type.CREATURE;
import static com.aa.mtg.deckbox.card.Type.ENCHANTMENT;
import static com.aa.mtg.deckbox.card.Type.INSTANT;
import static com.aa.mtg.deckbox.card.Type.LAND;
import static com.aa.mtg.deckbox.card.Type.LEGENDARY_CREATURE;
import static com.aa.mtg.deckbox.card.Type.PLANESWALKER;
import static com.aa.mtg.deckbox.card.Type.SORCERY;
import static org.assertj.core.api.Assertions.assertThat;

public class CardListCsvParserTest {

    private static final Card ABBOT_OF_KERAL_KEEP = cardBuilder().name("Abbot of Keral Keep").ofTypes(CREATURE).rarity(RARE).build();
    private static final Card ACCURSED_SPIRIT = cardBuilder().name("Accursed Spirit").ofTypes(CREATURE).rarity(COMMON).build();
    private static final Card ACT_OF_TREASON = cardBuilder().name("Act of Treason").ofTypes(SORCERY).rarity(COMMON).build();
    private static final Card DWYEN_GILT_LEAF_DEAN = cardBuilder().name("Dwynen, Gilt-Leaf Daen").ofTypes(LEGENDARY_CREATURE).rarity(RARE).build();
    private static final Card FIELD_CREEPER = cardBuilder().name("Field Creeper").ofTypes(ARTIFACT, CREATURE).rarity(COMMON).build();
    private static final Card HANGARBACK_WALKER = cardBuilder().name("Hangarback Walker").ofTypes(ARTIFACT, CREATURE).rarity(RARE).build();
    private static final Card SKYRIDER_ELF = cardBuilder().name("Skyrider Elf").ofTypes(CREATURE).rarity(UNCOMMON).build();
    private static final Card SIEGECRAFT = cardBuilder().name("Siegecraft").ofTypes(ENCHANTMENT).rarity(COMMON).build();
    private static final Card TAMIYO_FIELD_RESEARCHER = cardBuilder().name("Tamiyo, Field Researcher").ofTypes(PLANESWALKER).rarity(MYTHIC_RARE).build();
    private static final Card SWELL_OF_GROWTH = cardBuilder().name("Swell of Growth").ofTypes(INSTANT).rarity(COMMON).build();
    private static final Card SWAMP = cardBuilder().name("Swamp").ofTypes(BASIC_LAND).build();
    private static final Card TEMPLE_OF_DECEIT = cardBuilder().name("Temple of Deceit").ofTypes(LAND).rarity(RARE).build();

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