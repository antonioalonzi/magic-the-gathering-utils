package tests.acceptance.playingset.generator;

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
public class BoostersGeneratorAcceptanceTest {

    @Autowired
    private Main main;

    @Autowired
    private Console console;

    private ArgumentCaptor<String> consoleArguments = ArgumentCaptor.forClass(String.class);

    @Test
    public void shouldGenerateABooster() throws Exception {
        // generate a booster for a collection with one card per rarity type
        String cardsCollectionPath = BoostersGeneratorAcceptanceTest.class.getResource("/playingset/generator/card-collection.csv").getPath();
        main.run("booster-generator", cardsCollectionPath);

        // assert that there 1 rare, 3 uncommons, 10 common, 1 basic land.
        verify(console).print(consoleArguments.capture());

        assertThat(consoleArguments.getValue()).isEqualTo(
                "Booster 1:\n" +
                " - Abbot of Keral Keep\n" +
                " - Skyrider Elf\n" +
                " - Skyrider Elf\n" +
                " - Skyrider Elf\n" +
                " - Accursed Spirit\n" +
                " - Accursed Spirit\n" +
                " - Accursed Spirit\n" +
                " - Accursed Spirit\n" +
                " - Accursed Spirit\n" +
                " - Accursed Spirit\n" +
                " - Accursed Spirit\n" +
                " - Accursed Spirit\n" +
                " - Accursed Spirit\n" +
                " - Accursed Spirit\n" +
                " - Swamp\n" +
                "\n"
        );
    }

}