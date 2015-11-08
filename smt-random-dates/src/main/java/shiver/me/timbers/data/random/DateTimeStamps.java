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
    public long someTimeInAMonth() {
        return daysToMilliseconds(integers.someNumberBetween(1, calendars.daysThisMonth()));
    }

    @Override
    public long midnightThisWeekOn(WeekDay weekDay) {
        return calendars.midnightToday().withDayOfWeek(weekDay).toTime();
    }

    @Override
    public long midnightThisMonthOnThe(int date) {
        return calendars.midnightToday().withDateOfMonth(date).toTime();
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

    private long daysToMilliseconds(int days) {
        return (long) days * 24L * 60L * 60L * 1000L;
    }
}
