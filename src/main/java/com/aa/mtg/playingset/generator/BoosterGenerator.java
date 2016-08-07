package com.aa.mtg.playingset.generator;

import com.aa.mtg.collection.Booster;
import com.aa.mtg.collection.CardCollection;

import java.util.ArrayList;
import java.util.List;

public class BoosterGenerator {

    public static final String BOOSTER_GENERATOR_COMMAND = "booster-generator";

    public List<Booster> generateBoosters(CardCollection cardCollection, int i) {
        ArrayList<Booster> boosters = new ArrayList<>();

        boosters.add(generateBooster(cardCollection));

        return boosters;
    }

    private Booster generateBooster(CardCollection cardCollection) {
        return null;
    }
}
