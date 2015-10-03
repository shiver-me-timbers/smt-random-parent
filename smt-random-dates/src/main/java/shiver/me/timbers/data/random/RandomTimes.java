package shiver.me.timbers.data.random;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Simple helper methods for generating random strings of varying size and content.
 *
 * @author Karl Bennett
 */
public class RandomTimes {

    private static Times dates() {

        final Random random = ThreadLocalRandom.current();

        return new SomeTimes(random, new UtilTimeStamps());
    }

    /**
     * Generate a random date that could be in the past, present, or future.
     */
    public static Date someTime() {
        return dates().someTime();
    }

    /**
     * Generate a random date that could be in the past, or present.
     */
    public static Date someTimeInThePast() {
        return dates().someTimeInThePast();
    }

    /**
     * Generate a random date that could be in the present, or future.
     */
    public static Date someTimeInTheFuture() {
        return dates().someTimeInTheFuture();
    }

    /**
     * Generate a random date that falls on or before a specific date.
     */
    public static Date someTimeBefore(Date date) {
        return dates().someTimeBefore(date);
    }

    /**
     * Generate a random date that falls on or after a specific date.
     */
    public static Date someTimeAfter(Date date) {
        return dates().someTimeAfter(date);
    }

    /**
     * Generate a random date that falls on or after the min date and before the max date.
     */
    public static Date someTimeBetween(Date min, Date max) {
        return dates().someTimeBetween(min, max);
    }

    /**
     * Generate a random date that could be any time between 12:00:00 and 23:59:59 yesterday.
     */
    public static Date someTimeYesterday() {
        return dates().someTimeYesterday();
    }

    /**
     * Generate a random date that could be any time between 12:00:00 and 23:59:59 today.
     */
    public static Date someTimeToday() {
        return dates().someTimeToday();
    }

    /**
     * Generate a random date that could be any time between 12:00:00 and 23:59:59 tomorrow.
     */
    public static Date someTimeTomorrow() {
        return dates().someTimeTomorrow();
    }
}
