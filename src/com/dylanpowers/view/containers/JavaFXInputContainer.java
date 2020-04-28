package com.dylanpowers.view.containers;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Implementation of {@link InputContainer}
 *
 * @author Dylan Powers (dylandpowers@gmail.com)
 */
public class JavaFXInputContainer implements InputContainer<VBox> {

    private final VBox root;
    private final Label label;
    private final TextField inputField;

    public JavaFXInputContainer(String labelText) {
        this.label = new Label(labelText);
        this.inputField = new TextField();
        this.root = new VBox(label, inputField);
        configureView();
    }

    private void configureView() {
        root.setSpacing(5);
        root.setAlignment(Pos.CENTER_LEFT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getInputText() {
        return inputField.getText();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VBox getRootViewObject() {
        return root;
    }
}
