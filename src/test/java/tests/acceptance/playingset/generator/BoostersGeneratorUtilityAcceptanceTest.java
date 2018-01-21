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
    public void shouldGenerateABooster() {
        // Given some cards
        given(settings.getCollectionPath()).willReturn(getPath("/playingset/generator/card-collection.csv"));

        // When
        main.run("generate-booster", "1");

        // Then there are 1 rare, 3 uncommons, 10 common, 1 basic land.
        verify(console).print(consoleArguments.capture());
        assertThat(consoleArguments.getValue()).isEqualTo(
                "Booster 1:\n" +
                " - Abbot of Keral Keep                Magic Origins, RARE\n" +
                " - Skyrider Elf                       Battle for Zendikar, UNCOMMON\n" +
                " - Skyrider Elf                       Battle for Zendikar, UNCOMMON\n" +
                " - Skyrider Elf                       Battle for Zendikar, UNCOMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Swamp                              Magic Origins, BASIC_LAND\n" +
                "\n"
        );
    }

    @Test
    public void shouldGenerateABoosterByEditions() {
        // Given some cards
        given(settings.getCollectionPath()).willReturn(getPath("/playingset/generator/card-collection-multiple-editions.csv"));

        // When
        main.run("generate-booster", "1", "Magic Origins,Battle for Zendikar");

        // Then there are 1 rare, 3 uncommons, 10 common, 1 basic land.
        verify(console).print(consoleArguments.capture());
        assertThat(consoleArguments.getValue()).isEqualTo(
                "Booster 1:\n" +
                " - Abbot of Keral Keep                Magic Origins, RARE\n" +
                " - Skyrider Elf                       Battle for Zendikar, UNCOMMON\n" +
                " - Skyrider Elf                       Battle for Zendikar, UNCOMMON\n" +
                " - Skyrider Elf                       Battle for Zendikar, UNCOMMON\n" +
                " - Act of Treason                     Magic Origins, COMMON\n" +
                " - Act of Treason                     Magic Origins, COMMON\n" +
                " - Act of Treason                     Magic Origins, COMMON\n" +
                " - Act of Treason                     Magic Origins, COMMON\n" +
                " - Act of Treason                     Magic Origins, COMMON\n" +
                " - Act of Treason                     Magic Origins, COMMON\n" +
                " - Act of Treason                     Magic Origins, COMMON\n" +
                " - Act of Treason                     Magic Origins, COMMON\n" +
                " - Act of Treason                     Magic Origins, COMMON\n" +
                " - Act of Treason                     Magic Origins, COMMON\n" +
                " - Swamp                              Magic Origins, BASIC_LAND\n" +
                "\n"
        );
    }

    @Test
    public void shouldGenerateMoreThanOneBooster() {
        // Given some cards
        given(settings.getCollectionPath()).willReturn(getPath("/playingset/generator/card-collection.csv"));

        // When
        main.run("generate-booster", "2");

        // Then there are 1 rare, 3 uncommons, 10 common, 1 basic land.
        verify(console).print(consoleArguments.capture());
        assertThat(consoleArguments.getValue()).isEqualTo(
                "Booster 1:\n" +
                " - Abbot of Keral Keep                Magic Origins, RARE\n" +
                " - Skyrider Elf                       Battle for Zendikar, UNCOMMON\n" +
                " - Skyrider Elf                       Battle for Zendikar, UNCOMMON\n" +
                " - Skyrider Elf                       Battle for Zendikar, UNCOMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Swamp                              Magic Origins, BASIC_LAND\n" +
                "\n" +
                "Booster 2:\n" +
                " - Abbot of Keral Keep                Magic Origins, RARE\n" +
                " - Skyrider Elf                       Battle for Zendikar, UNCOMMON\n" +
                " - Skyrider Elf                       Battle for Zendikar, UNCOMMON\n" +
                " - Skyrider Elf                       Battle for Zendikar, UNCOMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Accursed Spirit                    Magic 2015 Core Set, COMMON\n" +
                " - Swamp                              Magic Origins, BASIC_LAND\n" +
                "\n"
        );
    }

    @Test
    public void shouldDisplayErrorNumberOfBoosterIsNegative() {
        // When
        main.run("generate-booster", "-1");

        // Then
        verify(console).print(consoleArguments.capture());
        assertThat(consoleArguments.getValue()).isEqualTo(
                "numOfBoosters must be a positive number.\n" +
                        "Usage: \n" +
                        "  generate-booster <numOfBoosters> <edition>\n" +
                        "     numOfBoosters: number of boosters to generate    (default 1)\n" +
                        "     edition: list of editions comma separated\n" +
                        "              eg. \"Magic Origins, Eldritch Moon\"    (default all editions)\n"
        );
    }

    @Test
    public void shouldDisplayErrorIfNotEnoughCads() {
        // Given too few cards
        given(settings.getCollectionPath()).willReturn(getPath("/playingset/generator/card-collection-few-cards.csv"));

        // When
        main.run("generate-booster", "1");

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