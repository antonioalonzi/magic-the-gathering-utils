package tests.acceptance.deckbox.linker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tests.acceptance.AbstractAcceptanceTest;
import tests.acceptance.MainTestConfiguration;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MainTestConfiguration.class})
public class DeckboxLinkerUtilityTest extends AbstractAcceptanceTest {

    @Test
    public void shouldLinkDeckboxAccount() {
        // Given
        String deckboxId = "aDeckboxId";

        // When
        main.run("link-to-deckbox", deckboxId);

        // Then
        verify(settings).setDeckboxId(deckboxId);
    }

}