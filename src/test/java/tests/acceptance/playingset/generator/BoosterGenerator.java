package tests.acceptance.playingset.generator;

import com.aa.mtg.Main;
import com.aa.mtg.console.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tests.acceptance.MainTestConfiguration;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static utils.Cards.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MainTestConfiguration.class})
public class BoosterGenerator {

    @Autowired
    private Main main;

    @Autowired
    private Console console;

    @Test
    public void shouldGenerateABooster() throws Exception {
        // generate a booster for a collection with one card per rarity type
        String cardCollectionPath = BoosterGenerator.class.getResource("/playingset/generator/card-collection.csv").getPath();
        main.run("booster-generator", cardCollectionPath);

        // assert that there 1 rare, 3 uncommons, 11 common, 1 basic land.
        verify(console, times(1)).print(ABBOT_OF_KERAL_KEEP.getName() + "\n");
        verify(console, times(3)).print(SKYRIDER_ELF.getName() + "\n");
        verify(console, times(10)).print(ACCURSED_SPIRIT.getName() + "\n");
        verify(console, times(1)).print(SWAMP.getName() + "\n");
    }

}