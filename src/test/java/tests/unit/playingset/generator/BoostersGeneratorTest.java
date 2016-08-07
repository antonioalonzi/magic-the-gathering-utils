package tests.unit.playingset.generator;

import com.aa.mtg.booster.Booster;
import com.aa.mtg.card.Card;
import com.aa.mtg.collection.CardsCollection;
import com.aa.mtg.playingset.generator.BoostersGenerator;
import com.aa.mtg.shuffler.CardsShuffler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static utils.Cards.*;

@RunWith(MockitoJUnitRunner.class)
public class BoostersGeneratorTest {

    @InjectMocks
    private BoostersGenerator boostersGenerator;

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
        List<Booster> boosters = boostersGenerator.generateBoosters(cardsCollection, numOfBoosters);

        // Then: deck has been shuffled before each card selection
        int numOfShufflePerBooster = 4; // one for each rarity: MythicRare/Rare, Uncommon, Common, BasicLand
        verify(cardsShuffler, times(numOfBoosters * numOfShufflePerBooster)).shuffle(Matchers.anyList());

        // And: boosters have correct sizes
        assertThat(boosters).hasSize(numOfBoosters);
        assertThat(boosters.get(0).getcardsList()).hasSize(15);
        assertThat(boosters.get(1).getcardsList()).hasSize(15);

        // And: Collection has been reduced of 30 cards
        assertThat(cardsCollection.getcardsList()).hasSize(370);
    }
}