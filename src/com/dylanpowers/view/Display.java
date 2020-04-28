package com.dylanpowers.view;

/**
 * Interface used for displaying the UI.
 *
 * @author Dylan Powers (dylandpowers@gmail.com)
 */
public interface Display {

    /**
     * Shows the view to the user.
     */
    public void show();

    /**
     * Shows the alert with the given message.
     *
     * @param message the message to display on the alert
     */
    public void displayAlertWithMessage(String message);

    /**
     * Gets the phone number from the display.
     *
     * @return the phone number
     */
    public String getPhoneNumber();

    /**
     * Gets the message from the display.
     *
     * @return the message to send
     */
    public String getMessage();

    /**
     * Gets the number of times to send the message from the display
     *
     * @return the number of times to send the message
     */
    public String getNumTimes();

    /**
     * Set the on submit action for the submit button
     *
     * @param runnable the runnable to run when the submit button is pressed
     */
    public void setOnSubmitAction(Runnable runnable);
}
