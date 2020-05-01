package com.dylanpowers.imessagespammer.exceptions;

import java.util.Map;

/**
 * Exception thrown when the user tries to submit the form with an invalid input.
 *
 * @author Dylan Powers (dylandpowers@gmail.com)
 */
public class InvalidInputException extends RuntimeException {

    public enum InputType {
        PHONE_NUMBER,
        MESSAGE,
        NUM_TIMES
    }

    private static Map<InputType, String> inputTypeToDisplayMessage = Map.of(
        InputType.PHONE_NUMBER, "Invalid phone number entered",
        InputType.MESSAGE, "Message must be non-empty",
        InputType.NUM_TIMES, "Number of times must be greater than zero"
    );

    public InvalidInputException(InputType cause) {
        super(inputTypeToDisplayMessage.get(cause));
    }
}
