package com.dylanpowers.view;

import com.dylanpowers.model.FieldLabels;
import com.dylanpowers.view.containers.InputContainer;
import com.dylanpowers.view.containers.JavaFXInputContainer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX implementation of {@link Display}
 *
 * @author Dylan Powers (dylandpowers@gmail.com)
 */
public class JavaFXDisplay implements Display {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    private final GridPane root;
    private final Stage stage;
    private final Button submitButton;

    private InputContainer<VBox> phoneNumberInput;
    private InputContainer<VBox> messageInput;
    private InputContainer<VBox> numTimesInput;

    public JavaFXDisplay(Stage stage) {
        this.stage = stage;
        this.root = new GridPane();
        this.submitButton = new Button("Send!");
        buildSceneAndSetOnStage();
    }

    private void buildSceneAndSetOnStage() {
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        root.setVgap(20);
        root.setAlignment(Pos.CENTER);

        phoneNumberInput = new JavaFXInputContainer(FieldLabels.PHONE_NUMBER_FIELD_LABEL);
        messageInput = new JavaFXInputContainer(FieldLabels.MESSAGE_FIELD_LABEL);
        numTimesInput = new JavaFXInputContainer(FieldLabels.NUM_TIMES_FIELD_LABEL);

        VBox inputPane = new VBox();
        inputPane.setSpacing(20);
        inputPane.setAlignment(Pos.CENTER);

        inputPane.getChildren().addAll(phoneNumberInput.getRootViewObject(),
            messageInput.getRootViewObject(),
            numTimesInput.getRootViewObject(),
            submitButton);

        root.getChildren().add(inputPane);

        stage.setScene(scene);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void show() {
        stage.show();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayAlertWithMessage(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPhoneNumber() {
        return phoneNumberInput.getInputText();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return messageInput.getInputText();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNumTimes() {
        return numTimesInput.getInputText();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOnSubmitAction(Runnable runnable) {
        submitButton.setOnAction(e -> runnable.run());
    }
}
