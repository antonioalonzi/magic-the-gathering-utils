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
public class StartingAppErrorsAcceptanceTest extends AbstractAcceptanceTest {

    @Test
    public void applicationLaunchedWithoutArguments() throws Exception {
        main.run(new String[0]);

        verify(console).print(consoleArguments.capture());
        assertThat(consoleArguments.getValue()).isEqualTo(
                "Missing first argument: you need to specify an utility to run.\n"
        );
    }
}
