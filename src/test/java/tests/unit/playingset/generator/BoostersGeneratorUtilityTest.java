package tests.unit.playingset.generator;

import com.aa.mtg.booster.Booster;
import com.aa.mtg.card.Card;
import com.aa.mtg.collection.CardsCollection;
import com.aa.mtg.exception.HandledException;
import com.aa.mtg.playingset.generator.BoostersGeneratorUtility;
import com.aa.mtg.shuffler.CardsShuffler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static utils.Cards.*;

@RunWith(MockitoJUnitRunner.class)
public class BoostersGeneratorUtilityTest {

    @InjectMocks
    private BoostersGeneratorUtility boostersGeneratorUtility;

    @Mock
    private CardsShuffler cardsShuffler;

    @Test
    public void whenCreatingBoostersCardsAreShuffledThenRemovedFromTheCardsCollection() throws Exception {
        // Given
        List<Card> cardsList = new ArrayList<>();
        cardsList.addAll(nCards(ABBOT_OF_KERAL_KEEP, 100));
        cardsList.addAll(nCards(SKYRIDER_ELF, 100));
        cardsList.addAll(nCards(ACCURSED_SPIRIT, 100));
        cardsList.addAll(nCards(SWAMP, 100));
        CardsCollection cardsCollection = new CardsCollection(cardsList);

        // When
        int numOfBoosters = 2;
        List<Booster> boosters = boostersGeneratorUtility.generateBoosters(cardsCollection, numOfBoosters);

        // Then: deck has been shuffled before each card selection
        int numOfShufflePerBooster = 4; // one for each rarity: MythicRare/Rare, Uncommon, Common, BasicLand
        verify(cardsShuffler, times(numOfBoosters * numOfShufflePerBooster)).shuffle(anyListOf(Card.class));

        // And: boosters have correct sizes
        assertThat(boosters).hasSize(numOfBoosters);
        assertThat(boosters.get(0).getcardsList()).hasSize(15);
        assertThat(boosters.get(1).getcardsList()).hasSize(15);

        // And: Collection has been reduced of 30 cards
        assertThat(cardsCollection.getcardsList()).hasSize(370);
    }

    @Test
    public void boosterWithoutBasicLand() throws Exception {
        // Given
        List<Card> cardsList = new ArrayList<>();
        cardsList.addAll(nCards(ABBOT_OF_KERAL_KEEP, 100));
        cardsList.addAll(nCards(SKYRIDER_ELF, 100));
        cardsList.addAll(nCards(ACCURSED_SPIRIT, 100));
        CardsCollection cardsCollection = new CardsCollection(cardsList);

        // When
        List<Booster> boosters = boostersGeneratorUtility.generateBoosters(cardsCollection, 1);

        // Then: boosters have correct sizes
        assertThat(boosters).hasSize(1);
        assertThat(boosters.get(0).getcardsList()).hasSize(14);
    }

    @Test(expected = HandledException.class)
    public void boosterWithNotEnoughCommons() throws Exception {
        // Given
        List<Card> cardsList = new ArrayList<>();
        cardsList.addAll(nCards(ABBOT_OF_KERAL_KEEP, 100));
        cardsList.addAll(nCards(SKYRIDER_ELF, 2));
        cardsList.addAll(nCards(ACCURSED_SPIRIT, 100));
        cardsList.addAll(nCards(SWAMP, 100));
        CardsCollection cardsCollection = new CardsCollection(cardsList);

        // When
        List<Booster> boosters = boostersGeneratorUtility.generateBoosters(cardsCollection, 1);

        // Then: boosters have correct sizes
        assertThat(boosters).hasSize(1);
        assertThat(boosters.get(0).getcardsList()).hasSize(14);
    }
}
