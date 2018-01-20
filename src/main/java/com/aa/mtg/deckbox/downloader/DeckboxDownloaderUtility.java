package com.aa.mtg.deckbox.downloader;

import com.aa.mtg.console.Console;
import com.aa.mtg.exception.HandledException;
import com.aa.mtg.settings.Settings;
import com.aa.mtg.utility.AbstractUtility;
import com.aa.mtg.utility.Utility;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;

public class DeckboxDownloaderUtility extends AbstractUtility implements Utility {

    private Settings settings;
    private Console console;

    public DeckboxDownloaderUtility(Settings settings, Console console) {
        this.settings = settings;
        this.console = console;
    }

    @Override
    public String getCommand() {
        return "update-collection";
    }

    @Override
    public String usage() {
        return "  update-collection";
    }

    @Override
    public void run(List<String> args) throws HandledException {
        try {
            String deckboxId = settings.getDeckboxId();
            URL website = new URL("https://deckbox.org/sets/export/" + deckboxId +"?format=csv&columns=Type,Cost,Rarity");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(settings.getCollectionPath());
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            console.print("Collection updated.");

        } catch (Exception e) {
            console.print("ERROR: could not download collection.");
        }
    }

}
