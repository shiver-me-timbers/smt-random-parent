package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
class DateTimeStamps implements TimeStamps {

    private static final int MILLISECONDS_IN_ONE_DAY = 86400000;
    private static final int MILLISECONDS_IN_ONE_WEEK = 604800000;

    private final Numbers<Integer> integers;
    private final Calendars calendars;

    public DateTimeStamps(Numbers<Integer> integers, Calendars calendars) {
        this.integers = integers;
        this.calendars = calendars;
    }

    @Override
    public long now() {
        return new Date().getTime();
    }

    @Override
    public long todayMidnight() {
        return calendars.midnightToday().toTime();
    }

    @Override
    public long someTimeInADay() {
        return integers.someNumberBetween(0, MILLISECONDS_IN_ONE_DAY);
    }

    @Override
    public long someTimeInAWeek() {
        return integers.someNumberBetween(0, MILLISECONDS_IN_ONE_WEEK);
    }

    @Override
    public long someTimeInDays(int days) {
        return (long) integers.someNumberBetween(0, days) * MILLISECONDS_IN_ONE_DAY;
    }

    @Override
    public long someTimeInAMonth() {
        return daysToMilliseconds(integers.someNumberBetween(1, calendars.daysThisMonth()));
    }

    @Override
    public long someTimeInAYear() {
        return daysToMilliseconds(integers.someNumberBetween(1, calendars.daysThisYear()));
    }

    @Override
    public long midnightThisWeekOn(WeekDay weekDay) {
        return calendars.midnightToday().withDayOfWeek(weekDay).toTime();
    }

    @Override
    public long midnightLastMonthOnThe(int date) {
        return calendars.midnightToday().minusMonths(1).withDateOfMonth(date).toTime();
    }

    @Override
    public long midnightThisMonthOnThe(int date) {
        return calendars.midnightToday().withDateOfMonth(date).toTime();
    }

    @Override
    public long midnightNextMonthOnThe(int date) {
        return calendars.midnightToday().addMonths(1).withDateOfMonth(date).toTime();
    }

    @Override
    public long midnightLastYearOnDay(int day) {
        return calendars.midnightToday().minusYears(1).withDayOfYear(day).toTime();
    }

    @Override
    public long midnightThisYearOnDay(int day) {
        return calendars.midnightToday().withDayOfYear(day).toTime();
    }

    @Override
    public long midnightNextYearOnDay(int day) {
        return calendars.midnightToday().addYears(1).withDayOfYear(day).toTime();
    }

    @Override
    public long minusDays(long time, int days) {
        return calendars.create(time).minusDays(days).toTime();
    }

    @Override
    public long addDays(long time, int days) {
        return calendars.create(time).addDays(days).toTime();
    }

    @Override
    public long minusWeeks(long time, int weeks) {
        return calendars.create(time).minusWeeks(weeks).toTime();
    }

    @Override
    public long addWeeks(long time, int weeks) {
        return calendars.create(time).addWeeks(weeks).toTime();
    }

    @Override
    public long minusMonths(long time, int months) {
        return calendars.create(time).minusMonths(months).toTime();
    }

    @Override
    public long addMonths(long time, int months) {
        return calendars.create(time).addMonths(months).toTime();
    }

    @Override
    public long minusYears(long time, int years) {
        return calendars.create(time).minusYears(years).toTime();
    }

    @Override
    public long addYears(long time, int years) {
        return calendars.create(time).addYears(years).toTime();
    }

    private long daysToMilliseconds(int days) {
        return (long) days * MILLISECONDS_IN_ONE_DAY;
    }
}
