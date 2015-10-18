package shiver.me.timbers.data.random;

import java.util.Date;
import java.util.Random;

/**
 * @author Karl Bennett
 */
class DateTimeStamps implements TimeStamps {

    private static final int MILLISECONDS_IN_ONE_DAY = 86400000;
    private static final int MILLISECONDS_IN_ONE_WEEK = 604800000;

    private final Random random;
    private final Calendars calendars;

    public DateTimeStamps(Random random, Calendars calendars) {
        this.random = random;
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
        return random.nextInt(MILLISECONDS_IN_ONE_DAY);
    }

    @Override
    public long someTimeInAWeek() {
        return random.nextInt(MILLISECONDS_IN_ONE_WEEK);
    }

    @Override
    public long midnightThisWeekOn(WeekDay weekDay) {
        return calendars.midnightToday().withDayOfWeek(weekDay).toTime();
    }

    @Override
    public long minusDays(Long time, int days) {
        return calendars.create(time).minusDays(days).toTime();
    }

    @Override
    public long addDays(Long time, int days) {
        return calendars.create(time).addDays(days).toTime();
    }

    @Override
    public long minusWeeks(Long time, int weeks) {
        return calendars.create(time).minusWeeks(weeks).toTime();
    }

    @Override
    public long addWeeks(Long time, int weeks) {
        return calendars.create(time).addWeeks(weeks).toTime();
    }
}
