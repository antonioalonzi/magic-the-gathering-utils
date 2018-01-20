package tests.acceptance.playingset.generator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tests.acceptance.AbstractAcceptanceTest;
import tests.acceptance.MainTestConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MainTestConfiguration.class})
public class BoostersGeneratorUtilityAcceptanceTest extends AbstractAcceptanceTest {

    @Test
    public void shouldGenerateABooster() throws Exception {
        // Given some cards
        given(settings.getCollectionPath()).willReturn(getPath("/playingset/generator/card-collection.csv"));

        // When
        main.run("booster-generator", "1");

        // Then there are 1 rare, 3 uncommons, 10 common, 1 basic land.
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
        // Given some cards
        given(settings.getCollectionPath()).willReturn(getPath("/playingset/generator/card-collection.csv"));

        // When
        main.run("booster-generator", "2");

        // Then there are 1 rare, 3 uncommons, 10 common, 1 basic land.
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
    public void shouldDisplayErrorNumberOfBoosterIsNegative() throws Exception {
        // When
        main.run("booster-generator", "-1");

        // Then
        verify(console).print(consoleArguments.capture());
        assertThat(consoleArguments.getValue()).isEqualTo(
                "numOfBoosters must be a positive number.\n" +
                        "Usage: \n" +
                        "  booster-generator <numOfBoosters>\n" +
                        "     numOfBoosters: number of boosters to generate\n"
        );
    }

    @Test
    public void shouldDisplayErrorIfNotEnoughCads() throws Exception {
        // Given too few cards
        given(settings.getCollectionPath()).willReturn(getPath("/playingset/generator/card-collection-few-cards.csv"));

        // When
        main.run("booster-generator", "1");

        // Then an error is displayed
        verify(console).print(consoleArguments.capture());
        assertThat(consoleArguments.getValue()).isEqualTo(
                "You don't have enough [UNCOMMON] cards in your collection.\n"
        );
    }

    private String getPath(String csvPath) {
        return BoostersGeneratorUtilityAcceptanceTest.class.getResource(csvPath).getPath();
    }
}