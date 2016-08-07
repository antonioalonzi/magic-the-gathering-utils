package tests.acceptance;

import com.aa.mtg.Main;
import com.aa.mtg.MainConfiguration;
import com.aa.mtg.console.Console;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class MainTestConfiguration extends MainConfiguration {

    @Bean
    public Main main() {
        return new Main();
    }

    @Bean
    @Override
    public Console console() {
        return mock(Console.class);
    }

}
