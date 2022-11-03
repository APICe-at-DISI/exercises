package it.unibo.nestedenum;

import java.util.*;

public class SortMonthNested {

    public static final Comparator<Month> ORDER_COMPARATOR = new Comparator<Month>() {
        @Override
        public int compare(Month m1, Month m2) {
            if (m1.name.equals(m2.name)) {
                return 0;
            } else if (m1.cardinal() > m2.cardinal()) {
                return 1;
            } else {
                return -1;
            }
        }
    };

    public static final Comparator<Month> DAYS_COMPARATOR = new Comparator<Month>() {
        @Override
        public int compare(Month m1, Month m2) {
            if (m1.name.equals(m2.name)) {
                return 0;
            } else if (m1.days > m2.days) {
                return 1;
            } else {
                return -1;
            }
        }
    };

    public static class Month {
        private static List<String> MONTHS = List.of(
            "january",
            "february",
            "march",
            "april",
            "may",
            "june",
            "july",
            "august",
            "september",
            "october",
            "november",
            "december"
        );
        private static List<Integer> DAYS = List.of(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

        private final String name;
        private final int days;

        public Month(String name) {
            Objects.requireNonNull(name);
            this.name = lookup(name.toLowerCase());
            this.days = DAYS.get(MONTHS.indexOf(this.name));
        }

        public int cardinal() {
            return MONTHS.indexOf(this.name) + 1;
        }

        private String lookup(String value) {
            String found = null;
            for (final var elem : MONTHS) {
                if (elem.startsWith(value.toLowerCase())) {
                    if (found != null) {
                        throw new IllegalArgumentException("The value " + value + " could be more than one single Month.");
                    }
                    found = elem;
                }
            }
            if (found == null) {
                throw new IllegalArgumentException(value + " is not a valid month");
            }
            return found;
        }
    }

    public List<String> sortList(List<String> list, Comparator<Month> orderComparator) {
        final var toBeOrdered = transform(list, new Transformer<String, Month>() {
            @Override
            public Month execute(String input) {
                return new Month(input);
            }
        });
        toBeOrdered.sort(orderComparator);
        return transform(toBeOrdered, new Transformer<Month, String>() {
            @Override
            public String execute(Month input) {
                return input.name;
            }
        });
    }

    interface Transformer<I, O> {
        O execute(I input);
    }

    private static <I, O> List<O> transform(Iterable<I> base, Transformer<I, O> transformer) {
        final var result = new ArrayList<O>();
        for (final I input : base) {
            result.add(transformer.execute(input));
        }
        return result;
    }

}
