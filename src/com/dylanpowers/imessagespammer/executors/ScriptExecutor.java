package com.dylanpowers.imessagespammer.executors;

import com.dylanpowers.imessagespammer.model.ExecuteScriptRequest;

/**
 * Interface for executing the spamming script.
 *
 * @author Dylan Powers (dylandpowers@gmail.com)
 */
public interface ScriptExecutor {

    /**
     * Executes the spam script based upon the given request.
     *
     * @param req the request to execute the script for
     */
    public void executeScript(ExecuteScriptRequest req);
}
