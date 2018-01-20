package tests.acceptance;

import com.aa.mtg.Main;
import com.aa.mtg.console.Console;
import com.aa.mtg.settings.Settings;
import org.junit.Before;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractAcceptanceTest {

    @Autowired
    protected Main main;

    @Autowired
    protected Console console;

    @Autowired
    protected Settings settings;

    protected ArgumentCaptor<String> consoleArguments = ArgumentCaptor.forClass(String.class);


    @Before
    public void cleanupConsoleMock() {
        Mockito.reset(console);
    }
}
