package com.dylanpowers.imessagespammer.controller;

import com.dylanpowers.imessagespammer.exceptions.InvalidInputException;
import com.dylanpowers.imessagespammer.exceptions.ScriptExecutionException;
import com.dylanpowers.imessagespammer.executors.ScriptExecutor;
import com.dylanpowers.imessagespammer.model.ExecuteScriptRequest;
import com.dylanpowers.imessagespammer.util.RequestBuilders;
import com.dylanpowers.imessagespammer.view.Display;

/**
 * Implementation of {@link Controller}
 *
 * @author Dylan Powers (dylandpowers@gmail.com)
 */
public class ControllerImpl implements Controller {

    private final Display display;
    private final ScriptExecutor scriptExecutor;

    public ControllerImpl(Display display,
                          ScriptExecutor scriptExecutor)
    {
        this.display = display;
        this.scriptExecutor = scriptExecutor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showViewAndProcessRequests() {
        display.setOnSubmitAction(this::executeScript);
        display.show();
    }

    private void executeScript() {
        String phoneNumber = display.getPhoneNumber();
        String message = display.getMessage();
        String numTimesStr = display.getNumTimes();

        int numTimes = 0;
        try {
            numTimes = Integer.parseInt(numTimesStr);
        } catch (NumberFormatException ex) {
            display.displayAlertWithMessage("Number of times must be an integer greater than 0");
            return;
        }

        try {
            ExecuteScriptRequest req = RequestBuilders
                .buildExecuteScriptRequest(phoneNumber, message, numTimes);

            scriptExecutor.executeScript(req);
        } catch (InvalidInputException ex) {
            display.displayAlertWithMessage(ex.getMessage());
        } catch (ScriptExecutionException ex) {
            display.displayAlertWithMessage("Error running script");
        }
    }
}
