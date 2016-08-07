package tests;

import com.aa.mtg.Main;
import com.aa.mtg.MainConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainTestConfiguration extends MainConfiguration {

    @Bean
    public Main main() {
        return new Main();
    }

}
