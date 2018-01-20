package com.aa.mtg.settings;

import com.aa.mtg.console.Console;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Properties;

public class Settings {

    private static final String HOME_FOLDER = ".magic-the-gathering-utils";
    private static final String PROPERTIES = "magic-the-gathering-utils.properties";
    private static final String DECKBOX_ID = "deckbox-id";
    private static final String COLLECTION_FILE = "collection.csv";

    private final Console console;
    private Properties properties;

    public Settings(Console console) {
        this.console = console;
    }

    public void initialize() {
        initializeHomeFolder();
        read();
    }

    public void read() {
        Resource resource = new FileSystemResource(getPropertiesPath());
        if (resource.exists()) {
            try {
                properties = PropertiesLoaderUtils.loadProperties(resource);
            } catch (IOException e) {
                console.print("ERROR: cannot read properties at: " + getPropertiesPath());
            }
        } else {
            properties = new Properties();
            save();
        }
    }

    public void save() {
        try {
            File propertiesFile = new File(getPropertiesPath());
            OutputStream out = new FileOutputStream(propertiesFile);
            properties.store(out, "");
        } catch (IOException e) {
            console.print("ERROR: cannot read properties at: " + getPropertiesPath());
        }
    }

    public String getHomePath() {
        return System.getProperty("user.home") + File.separator + HOME_FOLDER;
    }

    public String getPropertiesPath() {
        return getHomePath() + File.separator + PROPERTIES;
    }
    
    public String getDeckboxId() {
        return properties.getProperty(DECKBOX_ID);
    }

    public void setDeckboxId(String deckboxId) {
        properties.setProperty(DECKBOX_ID, deckboxId);
    }

    public String getCollectionPath() {
        return getHomePath() + File.separator + COLLECTION_FILE;
    }

    private void initializeHomeFolder() {
        File home = new File(getHomePath());
        if (!home.exists()) {
            boolean homeCreated = home.mkdir();
            if (!homeCreated) {
                console.print("ERROR: Could not created folder " + home.getAbsolutePath());
            }
        }
    }

}
