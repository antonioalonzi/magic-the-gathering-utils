package com.aa.mtg;

import com.aa.mtg.playingset.generators.BoosterGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private BoosterGenerator boosterGenerator;

    /**
     * Run the selected application utility.
     *
     * Not yet properly implemented.
     * Currently arguments can be modified only by modifying the main class.
     * @param args
     *   The first argument is the utility to run.
     *   All the other arguments represent the arguments for that utility.
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    public void run(String... args) throws Exception {
        System.out.println("test");
    }
}
