package tests.playingset.generators;

import com.aa.mtg.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tests.MainTestConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MainTestConfiguration.class})
public class BoosterGenerator {

    @Autowired
    private Main main;

    @Test
    public void shouldGenerateABooster() throws Exception {
        main.run("booster-generator");
    }

}