package com.dylanpowers.imessagespammer.util;

import java.util.regex.Pattern;

/**
 * Utility class for verifying inputs.
 *
 * @author Dylan Powers (dylandpowers@gmail.com)
 */
public final class Verifiers {

    private static final Pattern PHONE_NUMBER_REGEX = Pattern.compile("^\\D?(\\d{3})\\D?\\D?(\\d{3})\\D?(\\d{4})$");

    public static boolean verifyPhoneNumber(String phoneNumber) {
        return PHONE_NUMBER_REGEX.matcher(phoneNumber).matches();
    }

    public static boolean verifyMessage(String message) {
        return !message.isEmpty();
    }

    public static boolean verifyNumTimes(int numTimes) {
        return numTimes > 0;
    }
}
