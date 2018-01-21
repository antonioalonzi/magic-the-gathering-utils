package utils;

import com.aa.mtg.card.Card;

import java.util.ArrayList;
import java.util.List;

import static com.aa.mtg.card.CardBuilder.cardBuilder;
import static com.aa.mtg.card.Rarity.*;
import static com.aa.mtg.card.Type.*;

public class Cards {

    public static final Card ABBOT_OF_KERAL_KEEP = cardBuilder().name("Abbot of Keral Keep").ofTypes(CREATURE).rarity(RARE).edition("Magic Origins").build();
    public static final Card ACCURSED_SPIRIT = cardBuilder().name("Accursed Spirit").ofTypes(CREATURE).rarity(COMMON).edition("Magic 2015 Core Set").build();
    public static final Card ACT_OF_TREASON = cardBuilder().name("Act of Treason").ofTypes(SORCERY).rarity(COMMON).edition("Magic Origins").build();
    public static final Card DWYEN_GILT_LEAF_DEAN = cardBuilder().name("Dwynen, Gilt-Leaf Daen").ofTypes(LEGENDARY_CREATURE).edition("Magic Origins").rarity(RARE).build();
    public static final Card FIELD_CREEPER = cardBuilder().name("Field Creeper").ofTypes(ARTIFACT, CREATURE).rarity(COMMON).edition("Eldritch Moon").build();
    public static final Card HANGARBACK_WALKER = cardBuilder().name("Hangarback Walker").ofTypes(ARTIFACT, CREATURE).rarity(RARE).edition("Magic Origins").build();
    public static final Card SKYRIDER_ELF = cardBuilder().name("Skyrider Elf").ofTypes(CREATURE).rarity(UNCOMMON).edition("Battle for Zendikar").build();
    public static final Card SIEGECRAFT = cardBuilder().name("Siegecraft").ofTypes(ENCHANTMENT).rarity(COMMON).edition("Khans of Tarkir").build();
    public static final Card TAMIYO_FIELD_RESEARCHER = cardBuilder().name("Tamiyo, Field Researcher").ofTypes(PLANESWALKER).rarity(MYTHIC_RARE).edition("Eldritch Moon").build();
    public static final Card SWELL_OF_GROWTH = cardBuilder().name("Swell of Growth").ofTypes(INSTANT).rarity(COMMON).edition("Battle for Zendikar").build();
    public static final Card SWAMP = cardBuilder().name("Swamp").ofTypes(LAND).rarity(BASIC_LAND).edition("Magic Origins").build();
    public static final Card TEMPLE_OF_DECEIT = cardBuilder().name("Temple of Deceit").ofTypes(LAND).rarity(RARE).edition("Theros").build();

    public static List<Card> nCards(Card card, int nCopies) {
        ArrayList<Card> cards = new ArrayList<>();

        for (int i = 0; i < nCopies; i++) {
            cards.add(card);
        }

        return cards;
    }
}
