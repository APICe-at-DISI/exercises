import it.unibo.nestedenum.SortMonthEnum;
import it.unibo.nestedenum.SortMonthNested;
import it.unibo.nestedenum.SortMonthByOrder;
import it.unibo.nestedenum.SortMonthByDays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.*;

import static it.unibo.nestedenum.SortMonthEnum.Month.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestMonthSorter {
    private final List<String> listOfStrings = Arrays.asList("March", "F", "jan", "dec", "Sep", "AUG", "JUNE", "april", "July");

    @Test
    void testSortMonthByOrder() {
        List<String> expectedByOrder = Arrays.asList("jan", "F", "March", "april", "JUNE", "July", "AUG", "Sep", "dec");
        var toBeOrdered = new ArrayList<>(listOfStrings);
        var sorter = new SortMonthByOrder();
        sorter.sortList(toBeOrdered);
        assertEquals(expectedByOrder, toBeOrdered);
    }

    @Test
    void testSortMonthByDays() {
        List<String> expectedByDays = Arrays.asList("F", "april", "JUNE", "Sep", "July", "AUG", "dec", "jan", "March");
        var toBeOrdered = new ArrayList<>(listOfStrings);
        var sorter = new SortMonthByDays();
        sorter.sortList(toBeOrdered);
        assertEquals(expectedByDays, toBeOrdered);
    }

    @Test
    void testExceptions() {
        var toBeOrdered = new ArrayList<>(listOfStrings);
        toBeOrdered.add("J");
        var sorter = new SortMonthByDays();
        assertThrows(
            IllegalArgumentException.class,
            new Executable() {
                @Override
                public void execute() throws Throwable {
                    sorter.sortList(toBeOrdered);
                }
            }
        );
    }

    @Test
    void testExceptions2() {
        var toBeOrdered = new ArrayList<>(listOfStrings);
        toBeOrdered.add("Sunny");
        var sorter = new SortMonthByDays();
        assertThrows(
            IllegalArgumentException.class,
            new Executable() {
                @Override
                public void execute() throws Throwable {
                    sorter.sortList(toBeOrdered);
                }
            }
        );
    }

    @Test
    void testSortMonthWithStaticComparatorsByOrder() {
        var expected = Arrays.asList("january", "february", "march", "april", "june", "july", "august", "september", "december");
        var toBeOrdered = new ArrayList<>(listOfStrings);
        var sorter = new SortMonthNested();
        assertEquals(
            expected,
            sorter.sortList(toBeOrdered, SortMonthNested.ORDER_COMPARATOR)
        );
    }

    @Test
    void testSortMonthWithStaticComparatorsByDays() {
        var expected = Arrays.asList("february", "april", "june", "september", "july", "august", "december", "january", "march");
        var toBeOrdered = new ArrayList<>(listOfStrings);

        var sorter = new SortMonthNested();

        assertEquals(
            expected,
            sorter.sortList(toBeOrdered, SortMonthNested.DAYS_COMPARATOR)
        );
    }

    @Test
    void testSortMonthEnumByDays() {
        List<SortMonthEnum.Month> monthList = List.of(JUNE, AUGUST, DECEMBER, JANUARY, JULY);
        List<SortMonthEnum.Month> expected = List.of(JANUARY, JUNE, JULY, AUGUST, DECEMBER);
        var sorter = new SortMonthEnum();

        assertEquals(
            expected,
            sorter.sortList(monthList, SortMonthEnum.Month.ORDER_COMPARATOR)
        );
    }
}