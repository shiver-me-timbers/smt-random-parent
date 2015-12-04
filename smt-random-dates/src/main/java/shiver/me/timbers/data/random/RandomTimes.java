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
            new RandomTimeBuilderFactory(
                new JavaCalendars(),
                new NumbersRandomDurations(
                    new BoundNumbers<>(Integer.class, new IntegerOperations(random), RETRY_AMOUNT, random)
                ),
                new BoundNumbers<>(Long.class, new LongOperations(random), RETRY_AMOUNT, random)
            )
        );
    }

    /**
     * Generate a random time that could be in the past, present, or future.
     */
    public static RandomTimeBuilder someTime() {
        return times().someTime();
    }

    /**
     * Generate a random time in the past.
     */
    public static RandomTimeBuilder someTimeInThePast() {
        return times().someTimeInThePast();
    }

    /**
     * Generate a random time in the future.
     */
    public static RandomTimeBuilder someTimeInTheFuture() {
        return times().someTimeInTheFuture();
    }

    /**
     * Generate a random time that falls before a specific date.
     */
    public static RandomTimeBuilder someTimeBefore(Date date) {
        return times().someTimeBefore(date);
    }

    /**
     * Generate a random time that falls after a specific date.
     */
    public static RandomTimeBuilder someTimeAfter(Date date) {
        return times().someTimeAfter(date);
    }

    /**
     * Generate a random time that falls on or after the min date and before the max date.
     */
    public static RandomTimeBuilder someTimeBetween(Date min, Date max) {
        return times().someTimeBetween(min, max);
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 00:00:59 last minute.
     */
    public static RandomTimeBuilder someTimeLastMinute() {
        return times().someTimeLastMinute();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 00:00:59 this minute.
     */
    public static RandomTimeBuilder someTimeThisMinute() {
        return times().someTimeThisMinute();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 00:00:59 next minute.
     */
    public static RandomTimeBuilder someTimeNextMinute() {
        return times().someTimeNextMinute();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 00:59:59 last hour.
     */
    public static RandomTimeBuilder someTimeLastHour() {
        return times().someTimeLastHour();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 00:59:59 this hour.
     */
    public static RandomTimeBuilder someTimeThisHour() {
        return times().someTimeThisHour();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 00:59:59 next hour.
     */
    public static RandomTimeBuilder someTimeNextHour() {
        return times().someTimeNextHour();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 23:59:59 yesterday.
     */
    public static RandomTimeBuilder someTimeYesterday() {
        return times().someTimeYesterday();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 23:59:59 today.
     */
    public static RandomTimeBuilder someTimeToday() {
        return times().someTimeToday();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 23:59:59 tomorrow.
     */
    public static RandomTimeBuilder someTimeTomorrow() {
        return times().someTimeTomorrow();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 Monday and 23:59:59 Sunday last week.
     */
    public static RandomTimeBuilder someTimeLastWeek() {
        return times().someTimeLastWeek();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 Monday and 23:59:59 Sunday this week.
     */
    public static RandomTimeBuilder someTimeThisWeek() {
        return times().someTimeThisWeek();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 Monday and 23:59:59 Sunday next week.
     */
    public static RandomTimeBuilder someTimeNextWeek() {
        return times().someTimeNextWeek();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 23:59:59 of a given day last week.
     */
    public static RandomTimeBuilder someTimeLastWeekOn(WeekDay weekDay) {
        return times().someTimeLastWeekOn(weekDay);
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 23:59:59 of a given day this week.
     */
    public static RandomTimeBuilder someTimeThisWeekOn(WeekDay weekDay) {
        return times().someTimeThisWeekOn(weekDay);
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 23:59:59 of a given day next week.
     */
    public static RandomTimeBuilder someTimeNextWeekOn(WeekDay weekDay) {
        return times().someTimeNextWeekOn(weekDay);
    }

    /**
     * Generate a random time that could be any time between 00:00:00 the 1st and 23:59:59 on the last day of last month.
     */
    public static RandomTimeBuilder someTimeLastMonth() {
        return times().someTimeLastMonth();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 the 1st and 23:59:59 on the last day of this month.
     */
    public static RandomTimeBuilder someTimeThisMonth() {
        return times().someTimeThisMonth();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 the 1st and 23:59:59 on the last day of next month.
     */
    public static RandomTimeBuilder someTimeNextMonth() {
        return times().someTimeNextMonth();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 23:59:59 of a given date last month.
     */
    public static RandomTimeBuilder someTimeLastMonthOnThe(int date) {
        return times().someTimeLastMonthOnThe(date);
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 23:59:59 of a given date this month.
     */
    public static RandomTimeBuilder someTimeThisMonthOnThe(int date) {
        return times().someTimeThisMonthOnThe(date);
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 23:59:59 of a given date next month.
     */
    public static RandomTimeBuilder someTimeNextMonthOnThe(int date) {
        return times().someTimeNextMonthOnThe(date);
    }

    /**
     * Generate a random time that could be any time between 00:00:00 the 1st of January and 23:59:59 the 31st of
     * December last year.
     */
    public static RandomTimeBuilder someTimeLastYear() {
        return times().someTimeLastYear();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 the 1st of January and 23:59:59 the 31st of
     * December this year.
     */
    public static RandomTimeBuilder someTimeThisYear() {
        return times().someTimeThisYear();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 the 1st of January and 23:59:59 the 31st of
     * December next year.
     */
    public static RandomTimeBuilder someTimeNextYear() {
        return times().someTimeNextYear();
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 23:59:59 of a given day last year.
     */
    public static RandomTimeBuilder someTimeLastYearOnDay(int day) {
        return times().someTimeLastYearOnDay(day);
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 23:59:59 of a given day this year.
     */
    public static RandomTimeBuilder someTimeThisYearOnDay(int day) {
        return times().someTimeThisYearOnDay(day);
    }

    /**
     * Generate a random time that could be any time between 00:00:00 and 23:59:59 of a given day next year.
     */
    public static RandomTimeBuilder someTimeNextYearOnDay(int day) {
        return times().someTimeNextYearOnDay(day);
    }
}
