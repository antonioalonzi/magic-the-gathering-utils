package com.aa.mtg.deck;

import com.aa.mtg.card.Card;
import com.aa.mtg.deck.shuffler.DeckShuffler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.aa.mtg.cards.Cards.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DeckTest {

    @Test
    public void shouldCreateAndDrawCards() throws Exception {
        // create a deck with four cards and a shuffler
        DeckShuffler shufflerMock = mock(DeckShuffler.class);
        ArrayList<Card> deckCards = newArrayList(
                ABBOT_OF_KERAL_KEEP,
                DWYEN_GILT_LEAF_DEAN,
                SWAMP,
                SWAMP
        );
        Deck deck = new Deck(deckCards, shufflerMock);

        // assert its size and that was shuffled
        verify(shufflerMock).shuffle(deck.getCards());
        assertThat(deck.size()).isEqualTo(4);

        // extract one card and assert that the size decreased
        List<Card> extractedCards = new ArrayList<Card>();
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
}