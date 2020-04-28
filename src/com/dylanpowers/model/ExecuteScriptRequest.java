package com.dylanpowers.model;

/**
 * Model object for a request to execute a script.
 *
 * @author Dylan Powers (dylandpowers@gmail.com)
 */
public final class ExecuteScriptRequest {

    private String phoneNumber;
    private String message;
    private int numMessages;

    private ExecuteScriptRequest() { }

    public static ExecuteScriptRequest build(String phoneNumber,
                                             String message,
                                             int numMessages)
    {
        ExecuteScriptRequest req = new ExecuteScriptRequest();
        req.setPhoneNumber(phoneNumber);
        req.setMessage(message);
        req.setNumMessages(numMessages);
        return req;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNumMessages() {
        return numMessages;
    }

    public void setNumMessages(int numMessages) {
        this.numMessages = numMessages;
    }
}
