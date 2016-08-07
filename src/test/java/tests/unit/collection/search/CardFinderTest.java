package tests.unit.collection.search;

import com.aa.mtg.card.Card;
import com.aa.mtg.collection.CardsCollection;
import org.junit.Test;

import java.util.List;

import static com.aa.mtg.card.Rarity.MYTHIC_RARE;
import static com.aa.mtg.card.Rarity.RARE;
import static com.aa.mtg.collection.search.CardFinder.search;
import static com.aa.mtg.collection.search.filter.NameFilter.name;
import static com.aa.mtg.collection.search.filter.RarityFilter.rarity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static utils.Cards.*;

public class CardFinderTest {

    @Test
    public void searchRareCards() throws Exception {
        // Given
        CardsCollection cardsCollection = new CardsCollection(newArrayList(
                ABBOT_OF_KERAL_KEEP,
                ACCURSED_SPIRIT,
                HANGARBACK_WALKER
        ));

        // When
        List<Card> cards = search(cardsCollection)
                .by(rarity(RARE))
                .fetchAll();

        // Then
        assertThat(cards).containsExactly(ABBOT_OF_KERAL_KEEP, HANGARBACK_WALKER);
    }

    @Test
    public void searchRareOrMythicCards() throws Exception {
        // Given
        CardsCollection cardsCollection = new CardsCollection(newArrayList(
                ABBOT_OF_KERAL_KEEP,
                ACCURSED_SPIRIT,
                HANGARBACK_WALKER,
                TAMIYO_FIELD_RESEARCHER
        ));

        // When
        List<Card> cards = search(cardsCollection)
                .by(rarity(RARE, MYTHIC_RARE))
                .fetchAll();

        // Then
        assertThat(cards).containsExactly(ABBOT_OF_KERAL_KEEP, HANGARBACK_WALKER, TAMIYO_FIELD_RESEARCHER);
    }

    @Test
    public void searchCardsByTextAndRarity() throws Exception {
        // Given
        CardsCollection cardsCollection = new CardsCollection(newArrayList(
                ABBOT_OF_KERAL_KEEP,
                ACCURSED_SPIRIT,
                HANGARBACK_WALKER
        ));

        // When
        List<Card> cards = search(cardsCollection)
                .by(rarity(RARE))
                .and(name("c"))
                .fetchAll();

        // Then
        assertThat(cards).containsExactly(HANGARBACK_WALKER);
    }

    @Test(expected = RuntimeException.class)
    public void errorWhenConstructingAndWithoutBy() throws Exception {
        search(new CardsCollection(newArrayList()))
                .and(rarity(RARE));
    }

    @Test(expected = RuntimeException.class)
    public void errorWhenCallingTwiceBy() throws Exception {
        search(new CardsCollection(newArrayList()))
                .by(rarity(RARE))
                .by(rarity(RARE));
    }
}
