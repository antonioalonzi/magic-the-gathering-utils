# Magic: The Gathering Utils (magic-the-gathering-utils)



## General Info

This project contains a set of utilities that help you organizing your card collection and playing 
**Magic: The Gathering** with your friends.



## Features

 * Extracting your card collection from [deckbox](https://deckbox.org)
 * Generating random Booster from your collection



## Usage

To run the application download the latest jar from [release page](https://github.com/antonioalonzi/magic-the-gathering-utils/releases).

Run the jar with:

    java -jar magic-the-gathering-utils-1.0.0.jar <utility> [args...]

### booster-generator

BoosterGenerator utility allow to generates random boosters from your deckbox cards collection.

You can then search the real cards from your collection, distribute to your friends and simulated a constructed game.

 1. Export to CSV your collection
    * Go on [deckbox](https://deckbox.org)
    * Go on Inventory (on the left menu)
    * On the Top Right bar click on Tools -> export
    * Columns to include: select all columns as extra columns
    * Click 'Export'
 2. Run the booster-generator command as follow
    
    java -jar magic-the-gathering-utils-1.0.0.jar booster-generator <NumOfBoosters>

This will print to screen a list of boosters randomly generated from your card set.

Boosters are composed of:

 * 1 Mythic or Rare card
 * 3 Uncommon cards
 * 10 Uncommon cards
 * 1 Basic land
 
You probably won't need basic lands in the booster generation if your purpose is to play constructed.

If you don't have basic lands then your booster will be of 14 cards and not containing basic land.

## Developer's guide

### Build a runnable jar

The runnable jar is created with [spring-boot-maven-plugin](http://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html). 

    mvn clean package

The jar will be created into target folder.
