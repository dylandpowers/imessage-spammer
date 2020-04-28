package com.dylanpowers;

import com.dylanpowers.controller.Controller;
import com.dylanpowers.controller.ControllerImpl;
import com.dylanpowers.executors.AppleScriptExecutor;
import com.dylanpowers.executors.ScriptExecutor;
import com.dylanpowers.view.Display;
import com.dylanpowers.view.JavaFXDisplay;
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
