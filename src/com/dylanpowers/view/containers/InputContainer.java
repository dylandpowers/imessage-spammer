package com.dylanpowers.view.containers;

/**
 * Interface for defining an input container, which should include a label and a text field.
 *
 * @author Dylan Powers (dylanpowers@gmail.com)
 */
public interface InputContainer<T> {

    /**
     * Gets the text inside of the text field.
     *
     * @return the text inside of the text field
     */
    public String getInputText();

    /**
     * Gets the root view object associated with this input container.
     *
     * @return the root view object
     */
    public T getRootViewObject();
}
