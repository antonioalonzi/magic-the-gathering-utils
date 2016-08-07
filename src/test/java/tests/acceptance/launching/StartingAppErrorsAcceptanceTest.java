package tests.acceptance.launching;

import com.aa.mtg.Main;
import com.aa.mtg.console.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tests.acceptance.MainTestConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MainTestConfiguration.class})
public class StartingAppErrorsAcceptanceTest {

    @Autowired
    private Main main;

    @Autowired
    private Console console;

    private ArgumentCaptor<String> consoleArguments = ArgumentCaptor.forClass(String.class);

    @Test
    public void applicationLaunchedWithoutArguments() throws Exception {
        main.run();

        verify(console).print(consoleArguments.capture());
        assertThat(consoleArguments.getValue()).isEqualTo(
                "Argument"
        );
    }
}
