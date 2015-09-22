package shiver.me.timbers.data.random;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Simple helper methods for generating random strings of varying size and content.
 *
 * @author Karl Bennett
 */
public class RandomDates {

    private static Dates dates() {

        final Random random = ThreadLocalRandom.current();

        return new SomeDates(random, new UtilDateFactory());
    }

    /**
     * Generate a random date that could be in the past, present, or future.
     */
    public static Date someDate() {
        return dates().someDate();
    }

    /**
     * Generate a random date that could be in the past, or present.
     */
    public static Date somePastDate() {
        return dates().somePastDate();
    }

    /**
     * Generate a random date that could be in the present, or future.
     */
    public static Date someFutureDate() {
        return dates().someFutureDate();
    }

    /**
     * Generate a random date that falls on or before a specific date.
     */
    public static Date someDateBefore(Date date) {
        return dates().someDateBefore(date);
    }

    /**
     * Generate a random date that falls on or after a specific date.
     */
    public static Date someDateAfter(Date date) {
        return dates().someDateAfter(date);
    }

    /**
     * Generate a random date that falls on or after the min date and before the max date.
     */
    public static Date someDateBetween(Date min, Date max) {
        return dates().someDateBetween(min, max);
    }

    /**
     * Generate a random date that could be any time between 12:00:00 and 23:59:59 yesterday.
     */
    public static Date someDateYesterday() {
        return dates().someDateYesterday();
    }

    /**
     * Generate a random date that could be any time between 12:00:00 and 23:59:59 today.
     */
    public static Date someDateToday() {
        return dates().someDateToday();
    }

    /**
     * Generate a random date that could be any time between 12:00:00 and 23:59:59 tomorrow.
     */
    public static Date someDateTomorrow() {
        return dates().someDateTomorrow();
    }
}
