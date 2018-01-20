package com.aa.mtg.deckbox.linker;

import com.aa.mtg.console.Console;
import com.aa.mtg.exception.HandledException;
import com.aa.mtg.settings.Settings;
import com.aa.mtg.utility.AbstractUtility;
import com.aa.mtg.utility.Utility;

import java.util.List;

public class DeckboxLinkerUtility extends AbstractUtility implements Utility {

    private Settings settings;
    private Console console;

    public DeckboxLinkerUtility(Settings settings, Console console) {
        this.settings = settings;
        this.console = console;
    }

    @Override
    public String getCommand() {
        return "link-to-deckbox";
    }

    @Override
    public String usage() {
        return "  link-to-deckbox <DeckboxId>\n" +
               "     DeckboxId: your deckbox id (number in the url)";
    }

    @Override
    public void run(List<String> args) throws HandledException {
        if (args.size() > 0) {
            String deckboxId = args.get(0);
            settings.setDeckboxId(deckboxId);
            settings.save();
            console.print("Deckbox Id set to " + deckboxId);
        }
    }

}
