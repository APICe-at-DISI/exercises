package it.unibo.nestedenum;

import java.util.*;

public class SortMonthEnum {
    public enum Month {
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private final int days;

        Month(int days) {
            this.days = days;
        }

        public static final Comparator<Month> ORDER_COMPARATOR = new Comparator<Month>() {
            @Override
            public int compare(Month m1, Month m2) {
                if (m1.toString().equals(m2.toString())) {
                    return 0;
                } else if (m1.ordinal() > m2.ordinal()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };

        public static final Comparator<Month> DAYS_COMPARATOR = new Comparator<Month>() {
            @Override
            public int compare(Month m1, Month m2) {
                if (m1.toString().equals(m2.toString())) {
                    return 0;
                } else if (m1.days > m2.days) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
    }

    public List<Month> sortList(List<Month> list, Comparator<Month> orderComparator) {
        List<Month> toBeOrdered = new ArrayList<>(list);
        toBeOrdered.sort(orderComparator);
        return toBeOrdered;
    }

}
