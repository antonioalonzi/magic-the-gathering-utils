package tests.acceptance.playingset.generator;

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
public class BoostersGeneratorAcceptanceTest extends AbstractAcceptanceTest {

    @Test
    public void shouldGenerateABooster() throws Exception {
        // generate a booster for a collection with one card per rarity type
        String cardsCollectionPath = BoostersGeneratorAcceptanceTest.class.getResource("/playingset/generator/card-collection.csv").getPath();
        main.run("booster-generator", cardsCollectionPath, "1");

        // assert that there are 1 rare, 3 uncommons, 10 common, 1 basic land.
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

    @Test
    public void shouldGenerateMoreThanOneBooster() throws Exception {
        // generate two boosters for a collection with one card per rarity type
        String cardsCollectionPath = BoostersGeneratorAcceptanceTest.class.getResource("/playingset/generator/card-collection.csv").getPath();
        main.run("booster-generator", cardsCollectionPath, "2");

        // assert that there are 1 rare, 3 uncommons, 10 common, 1 basic land.
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
                        "\n" +
                "Booster 2:\n" +
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

    @Test
    public void shouldDisplayErrorIfNotExistingFile() throws Exception {
        main.run("booster-generator", "non-existing-file", "1");
        verify(console).print(consoleArguments.capture());

        assertThat(consoleArguments.getValue()).isEqualTo(
                "File 'non-existing-file' not found.\n"
        );
    }

    @Test
    public void shouldDisplayErrorIfNotEnoughCads() throws Exception {
        // try generate a booster with a file that a very few cards
        String cardsCollectionPath = BoostersGeneratorAcceptanceTest.class.getResource("/playingset/generator/card-collection-few-cards.csv").getPath();
        main.run("booster-generator", cardsCollectionPath, "1");

        // assert that there are 1 rare, 3 uncommons, 10 common, 1 basic land.
        verify(console).print(consoleArguments.capture());

        assertThat(consoleArguments.getValue()).isEqualTo(
                "You don't have enough [UNCOMMON] cards in your collection.\n"
        );
    }

}