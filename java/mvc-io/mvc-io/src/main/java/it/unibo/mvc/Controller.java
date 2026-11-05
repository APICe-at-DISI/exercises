package it.unibo.mvc;

import java.util.List;

/**
 * This interface represents a controller in the MVC pattern,
 * responsible for managing the flow of data between the model and the view.
 */
public interface Controller {

    /**
     * Sets the next string to print.
     *
     * @param nextString next string to print
     */
    void setNextStringToPrint(String nextString);

    /**
     * Returns the next string to print.
     *
     * @return next string to print
     */
    String getNextStringToPrint();

    /**
     * Returns the history of printed strings.
     *
     * @return history of printed strings as a list
     */
    List<String> getPrintedStringsHistory();

    /**
     * Prints the current string.
     */
    void printCurrentString();
}
