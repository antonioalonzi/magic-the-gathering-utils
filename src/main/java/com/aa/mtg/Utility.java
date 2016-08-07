package com.aa.mtg;

import com.aa.mtg.exception.HandledException;

import java.util.List;

public interface Utility {

    String getCommand();

    void run(List<String> args) throws HandledException;

}
