package com.aa.mtg.deckbox.linker;

import com.aa.mtg.console.Console;
import com.aa.mtg.exception.HandledException;
import com.aa.mtg.settings.Settings;
import com.aa.mtg.utility.AbstractUtility;
import com.aa.mtg.utility.Utility;
import org.springframework.util.StringUtils;

import java.util.List;

public class DeckboxLinkerInfoUtility extends AbstractUtility implements Utility {

    private Settings settings;
    private Console console;

    public DeckboxLinkerInfoUtility(Settings settings, Console console) {
        this.settings = settings;
        this.console = console;
    }

    @Override
    public String getCommand() {
        return "show-link-to-deckbox";
    }

    @Override
    public String usage() {
        return "  show-link-to-deckbox";
    }

    @Override
    public void run(List<String> args) throws HandledException {
        String deckboxId = settings.getDeckboxId();
        if (StringUtils.hasText(deckboxId)) {
            console.print(deckboxId);
        } else {
            console.print("Not linked to deckbox.");
        }
    }

}
