package tests.acceptance;

import com.aa.mtg.Main;
import com.aa.mtg.MainConfiguration;
import com.aa.mtg.utility.Utility;
import com.aa.mtg.console.Console;
import com.aa.mtg.deckbox.parser.CardsListParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static org.mockito.Mockito.mock;

@Configuration
public class MainTestConfiguration extends MainConfiguration {

    /**
     * The Main bean is used to startup the application in tests.
     * @return main application
     */
    @Bean
    public Main main(CardsListParser cardsListParser, List<Utility> utilities, Console console) {
        return new Main(cardsListParser, utilities, console);
    }

    /**
     * Although those are Acceptance Tests the Console bean is defined as mock so it is easier
     * to assert on the application output
     * @return mock for console
     */
    @Bean
    @Override
    public Console console() {
        return mock(Console.class);
    }

}
