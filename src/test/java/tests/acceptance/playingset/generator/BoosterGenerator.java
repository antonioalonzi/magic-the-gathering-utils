package tests.acceptance.playingset.generator;

import com.aa.mtg.Main;
import com.aa.mtg.console.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tests.acceptance.MainTestConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MainTestConfiguration.class})
public class BoosterGenerator {

    @Autowired
    private Main main;

    @Autowired
    private Console console;

    @Test
    public void shouldGenerateABooster() throws Exception {
        main.run("booster-generator");
        Mockito.verify(console).print("test\n");
    }

}