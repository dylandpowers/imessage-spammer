package com.dylanpowers.imessagespammer;

import com.dylanpowers.imessagespammer.controller.Controller;
import com.dylanpowers.imessagespammer.controller.ControllerImpl;
import com.dylanpowers.imessagespammer.executors.AppleScriptExecutor;
import com.dylanpowers.imessagespammer.executors.ScriptExecutor;
import com.dylanpowers.imessagespammer.view.Display;
import com.dylanpowers.imessagespammer.view.JavaFXDisplay;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Used for configuring and launching the application
 *
 * @author Dylan Powers (dylandpowers@gmail.com)
 */
public class App extends Application {

    private static final String TITLE = "iMessage Spammer!";

    @Override
    public void start(Stage stage) throws Exception {
        Display display = new JavaFXDisplay(stage);
        stage.setTitle(TITLE);

        ScriptExecutor scriptExecutor = new AppleScriptExecutor();

        Controller controller = new ControllerImpl(display, scriptExecutor);
        controller.showViewAndProcessRequests();
    }

    public static void run(String[] args) {
        Application.launch(App.class, args);
    }
}
