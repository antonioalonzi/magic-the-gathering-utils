package com.aa.mtg.utility;

import com.aa.mtg.exception.HandledException;

import java.util.List;

public interface Utility {

    String getCommand();

    String usage();

    void run(List<String> args) throws HandledException;

}
