package com.dylanpowers.executors;

import com.dylanpowers.exceptions.ScriptExecutionException;
import com.dylanpowers.model.ExecuteScriptRequest;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

/**
 * AppleScript implementation of {@link ScriptExecutor}
 *
 * @author Dylan Powers (dylandpowers@gmail.com)
 */
public class AppleScriptExecutor implements ScriptExecutor {

    private static final String APPLESCRIPT_ENGINE_NAME = "AppleScript";

    private static final String SCRIPT_TEMPLATE = "repeat %d times\n" +
        "tell application \"Messages\"\n" +
        "set targetService to 1st service whose service type = iMessage\n" +
        "set targetBuddy to buddy \"%s\" of targetService\n" +
        "send \"%s\" to targetBuddy\n" +
        "end tell\n" +
        "end repeat";

    /**
     * {@inheritDoc}
     */
    @Override
    public void executeScript(ExecuteScriptRequest req) {
        String script = String.format(SCRIPT_TEMPLATE,
            req.getNumMessages(),
            req.getPhoneNumber(),
            req.getMessage());

        String[] args = { "osascript", "-e", script };

        try {
            ProcessBuilder pb = new ProcessBuilder(args);
            pb.redirectError(Redirect.INHERIT);
            pb.redirectOutput(Redirect.INHERIT);
            pb.start();
        } catch (IOException e) {
            throw new ScriptExecutionException(e);
        }
    }
}
