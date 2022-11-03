package it.unibo.nestedenum;

import java.util.*;

public class SortMonthByOrder implements MonthSorter {
    private final List<String> months = List.of("january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december");
    private final Comparator<String> orderComparator = new Comparator<String>() {
        @Override
        public int compare(String s, String t1) {
            if (s.toLowerCase().equals(t1.toLowerCase())) {
                return 0;
            } else if (lookup(s) > lookup(t1)) {
                return 1;
            } else {
                return -1;
            }
        }
    };

    private int lookup(String value) {
        int found = -1;
        for (final var elem : months) {
            if (elem.startsWith(value.toLowerCase())) {
                if (found != -1) {
                    throw new IllegalArgumentException("The value " + value + " could be more than one single Month.");
                }
                found = months.indexOf(elem);
            }
        }
        if (found == -1) {
            throw new IllegalArgumentException(value + " is not a valid month");
        }
        return found;
    }

    @Override
    public void sortList(List<String> listToSort) {
        listToSort.sort(orderComparator);
    }
}
