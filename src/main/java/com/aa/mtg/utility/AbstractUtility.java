package com.aa.mtg.utility;

import com.aa.mtg.exception.HandledException;

public abstract class AbstractUtility implements Utility {

    protected HandledException usageException(String errorMessage) {
        return new HandledException(errorMessage + "\n" + "Usage: \n" + usage());
    }

}
