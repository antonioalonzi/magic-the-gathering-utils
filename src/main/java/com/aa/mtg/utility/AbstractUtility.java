package com.aa.mtg.utility;

import com.aa.mtg.exception.HandledException;

public abstract class AbstractUtility implements Utility {

    protected void throwUsageException(String errorMessage) throws HandledException {
        throw new HandledException(errorMessage + "\n" + "Usage: \n" + usage());
    }

}
