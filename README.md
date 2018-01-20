# Magic: The Gathering Utils (magic-the-gathering-utils)



## General Info

This project contains a set of utilities that help you organizing your card collection and playing 
**Magic: The Gathering** with your friends.



## Features

 * Extracting your card collection from [deckbox](https://deckbox.org)
 * Generating random Boosters from your collection
 * Local data is stored into .magic-the-gathering-utils folder in your home



## Usage

To run the application download the latest jar from [release page](https://github.com/antonioalonzi/magic-the-gathering-utils/releases).

Run the jar with:

    java -jar magic-the-gathering-utils-1.0.0.jar link-to-deckbox <YourDeckboxId>
        # Link the app to deckbox (YourDeckboxId is the number in deckbox url)

    java -jar magic-the-gathering-utils-1.0.0.jar show-link-to-deckbox
        # Display your deckbox id

    java -jar magic-the-gathering-utils-1.0.0.jar update-collection
        # Update your card collection

    java -jar magic-the-gathering-utils-1.0.0.jar booster-generator <NumOfBoosters>
        # Generate some boosters that you can assemble to play with your friends
        # Booster are composed of 1 Mythic or Rare card, 3 Uncommon cards, 10 Uncommon cards, 1 Basic land.



## Developer's guide

### Build a runnable jar

The runnable jar is created with [spring-boot-maven-plugin](http://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html). 

    mvn clean package

The jar will be created into target folder.
