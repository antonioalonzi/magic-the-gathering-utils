package tests.unit.deck;

import com.aa.mtg.card.Card;
import com.aa.mtg.deck.Deck;
import com.aa.mtg.deck.DeckFactory;
import com.aa.mtg.shuffler.CardsShuffler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import utils.Cards;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DeckTest.DeckTestConfiguration.class})
public class DeckTest {

    @Autowired
    private DeckFactory deckFactory;

    @Autowired
    private CardsShuffler shufflerMock;

    @Test
    public void shouldCreateAndDrawCards() throws Exception {
        // create a deck with four cards and a shuffler
        ArrayList<Card> deckCards = newArrayList(
                Cards.ABBOT_OF_KERAL_KEEP,
                Cards.DWYEN_GILT_LEAF_DEAN,
                Cards.SWAMP,
                Cards.SWAMP
        );
        Deck deck = deckFactory.createDeck(deckCards);

        // assert its size and that was shuffled
        verify(shufflerMock).shuffle(deckCards);
        assertThat(deck.size()).isEqualTo(4);

        // extract one card and assert that the size decreased
        List<Card> extractedCards = new ArrayList<>();
        extractedCards.add(deck.draw());
        assertThat(deck.size()).isEqualTo(3);

        // extract all remaining cards and assert that are all correct
        extractedCards.add(deck.draw());
        extractedCards.add(deck.draw());
        extractedCards.add(deck.draw());
        assertThat(extractedCards).containsAll(deckCards);

        // assert that size is 0
        assertThat(deck.size()).isEqualTo(0);
    }

    @Configuration
    static class DeckTestConfiguration {

        @Bean
        public CardsShuffler mockCardsShuffler() {
            return mock(CardsShuffler.class);
        }

        @Bean
        public DeckFactory deckFactory(CardsShuffler cardsShuffler) {
            return new DeckFactory(cardsShuffler);
        }

    }

}