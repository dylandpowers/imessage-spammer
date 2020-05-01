package com.dylanpowers.imessagespammer.util;

import com.dylanpowers.imessagespammer.exceptions.InvalidInputException;
import com.dylanpowers.imessagespammer.exceptions.InvalidInputException.InputType;
import com.dylanpowers.imessagespammer.model.ExecuteScriptRequest;

/**
 * Utility class for building requests.
 *
 * @author Dylan Powers (dylandpowers@gmail.com)
 */
public final class RequestBuilders {

    public static ExecuteScriptRequest buildExecuteScriptRequest(String phoneNumber,
                                                                 String message,
                                                                 int numTimes)
    {
        if (!Verifiers.verifyPhoneNumber(phoneNumber)) {
            throw new InvalidInputException(InputType.PHONE_NUMBER);
        }

        if (!Verifiers.verifyMessage(message)) {
            throw new InvalidInputException(InputType.MESSAGE);
        }

        if (!Verifiers.verifyNumTimes(numTimes)) {
            throw new InvalidInputException(InputType.NUM_TIMES);
        }

        return ExecuteScriptRequest.build(phoneNumber, message, numTimes);
    }
}
