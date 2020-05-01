package com.dylanpowers.imessagespammer.exceptions;

/**
 * Exception thrown when there is an error executing the script.
 *
 * @author Dylan Powers (dylandpowers@gmail.com)
 */
public class ScriptExecutionException extends RuntimeException {

    public ScriptExecutionException(Throwable cause) {
        super(cause);
    }
}
