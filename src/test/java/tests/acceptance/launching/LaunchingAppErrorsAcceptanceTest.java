package tests.acceptance.launching;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tests.acceptance.AbstractAcceptanceTest;
import tests.acceptance.MainTestConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MainTestConfiguration.class})
public class LaunchingAppErrorsAcceptanceTest extends AbstractAcceptanceTest {

    @Test
    public void applicationLaunchedWithoutArguments() {
        // When
        main.run();

        // Then
        verify(console).print(consoleArguments.capture());
        assertThat(consoleArguments.getValue()).startsWith(
                "Missing first argument: you need to specify an utility to run.\n" +
                "Possible utilities are:\n" +
                " -"
        );
    }

    @Test
    public void applicationLaunchedWithNonExistingUtility() {
        // When
        main.run("non-existing-utility");

        // Then
        verify(console).print(consoleArguments.capture());
        assertThat(consoleArguments.getValue()).startsWith(
                "Utility 'non-existing-utility' not found.\n" +
                "Possible utilities are:\n" +
                " -"
        );
    }
}
