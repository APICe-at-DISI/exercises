package it.unibo.mvc;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 *
 */
public final class SimpleController implements Controller {

    private final List<String> stringHistory = new LinkedList<>();
    private String nextString;

    @Override
    public void setNextStringToPrint(final String nextStringToPrint) {
        this.nextString = Objects.requireNonNull(nextStringToPrint, "This method does not accept null values.");
    }

    @Override
    public String getNextStringToPrint() {
        return this.nextString;
    }

    @Override
    public List<String> getPrintedStringsHistory() {
        return Collections.unmodifiableList(stringHistory);
    }

    @Override
    public void printCurrentString() {
        if (this.nextString == null) {
            throw new IllegalStateException("There is no string set");
        }
        stringHistory.add(this.nextString);
        System.out.println(this.nextString); // NOPMD: allowed in exercises
    }

}
