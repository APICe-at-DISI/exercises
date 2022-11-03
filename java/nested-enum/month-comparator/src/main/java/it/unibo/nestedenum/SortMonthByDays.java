package it.unibo.nestedenum;

import java.util.*;

public class SortMonthByDays implements MonthSorter {

    @Override
    public void sortList(List<String> list) {
        list.sort(new MyComparator());
    }

    private static class MyComparator implements Comparator<String> {

        private final Map<String, Integer> months = new LinkedHashMap<>();

        public MyComparator() {
            months.put("january", 31);
            months.put("february", 28);
            months.put("march", 31);
            months.put("april", 30);
            months.put("may", 31);
            months.put("june", 30);
            months.put("july", 31);
            months.put("august", 31);
            months.put("september", 30);
            months.put("october", 31);
            months.put("november", 30);
            months.put("december", 31);
        }

        private int lookup(String value) {
            int found = -1;
            for (final var elem : months.entrySet()) {
                if (elem.getKey().startsWith(value.toLowerCase())) {
                    if (found != -1) {
                        throw new IllegalArgumentException("The value " + value + " could be more than one single Month.");
                    }
                    found = elem.getValue();
                }
            }
            if (found == -1) {
                throw new IllegalArgumentException(value + " is not a valid month");
            }
            return found;
        }

        @Override
        public int compare(String s, String t1) {
            if (s.equals(t1.toLowerCase())) {
                return 0;
            } else if (lookup(s) > lookup(t1)) {
                return 1;
            } else {
                return -1;
            }
        }
    }


}
