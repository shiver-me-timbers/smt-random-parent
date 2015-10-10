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

    private static final int RETRY_AMOUNT = 10000;

    private static Times times() {

        final Random random = ThreadLocalRandom.current();

        return new SomeTimes(
            new DateTimeStamps(random, new CalendarDays()),
            new BoundNumbers<>(Long.class, new LongOperations(random), RETRY_AMOUNT, random)
        );
    }

    /**
     * Generate a random time that could be in the past, present, or future.
     */
    public static Date someTime() {
        return times().someTime();
    }

    /**
     * Generate a random time in the past.
     */
    public static Date someTimeInThePast() {
        return times().someTimeInThePast();
    }

    /**
     * Generate a random time in the future.
     */
    public static Date someTimeInTheFuture() {
        return times().someTimeInTheFuture();
    }

    /**
     * Generate a random time that falls before a specific date.
     */
    public static Date someTimeBefore(Date date) {
        return times().someTimeBefore(date);
    }

    /**
     * Generate a random time that falls after a specific date.
     */
    public static Date someTimeAfter(Date date) {
        return times().someTimeAfter(date);
    }

    /**
     * Generate a random time that falls on or after the min date and before the max date.
     */
    public static Date someTimeBetween(Date min, Date max) {
        return times().someTimeBetween(min, max);
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 23:59:59 yesterday.
     */
    public static Date someTimeYesterday() {
        return times().someTimeYesterday();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 23:59:59 today.
     */
    public static Date someTimeToday() {
        return times().someTimeToday();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 23:59:59 tomorrow.
     */
    public static Date someTimeTomorrow() {
        return times().someTimeTomorrow();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 Monday and 23:59:59 Sunday last week.
     */
    public static Date someTimeLastWeek() {
        return times().someTimeLastWeek();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 Monday and 23:59:59 Sunday this week.
     */
    public static Date someTimeThisWeek() {
        return times().someTimeThisWeek();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 Monday and 23:59:59 Sunday next week.
     */
    public static Date someTimeNextWeek() {
        return times().someTimeNextWeek();
    }
}
