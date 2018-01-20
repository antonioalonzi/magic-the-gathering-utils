package tests.acceptance.deckbox.linker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tests.acceptance.AbstractAcceptanceTest;
import tests.acceptance.MainTestConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MainTestConfiguration.class})
public class DeckboxLinkerInfoUtilityTest extends AbstractAcceptanceTest {

    @Test
    public void shouldPrintDeckboxInfo() {
        // Given
        String deckboxId = "aDeckboxId";
        given(settings.getDeckboxId()).willReturn(deckboxId);

        // When
        main.run("show-link-to-deckbox");

        // Then
        verify(console).print(consoleArguments.capture());
        assertThat(consoleArguments.getValue()).isEqualTo(deckboxId);
    }

    @Test
    public void shouldPrintDeckboxMissingInfo() {
        // Given
        given(settings.getDeckboxId()).willReturn(null);

        // When
        main.run("show-link-to-deckbox");

        // Then
        verify(console).print(consoleArguments.capture());
        assertThat(consoleArguments.getValue()).isEqualTo("Not linked to deckbox.");
    }

}