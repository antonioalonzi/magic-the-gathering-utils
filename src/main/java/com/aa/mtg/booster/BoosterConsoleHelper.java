package com.aa.mtg.booster;

import com.aa.mtg.card.Card;

import java.util.List;

public class BoosterConsoleHelper {

    public static String toString(List<Booster> boosters) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < boosters.size(); i++) {
            stringBuilder.append("Booster ").append(i+1).append(":\n");
            stringBuilder.append(toString(boosters.get(i)));
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    private static String toString(Booster booster) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Card card : booster.getCardList()) {
            stringBuilder.append(" - ").append(card.getName()).append("\n");
        }

        return stringBuilder.toString();
    }
}
