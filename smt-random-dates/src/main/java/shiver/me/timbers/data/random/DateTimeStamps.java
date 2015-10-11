package shiver.me.timbers.data.random;

import java.util.Date;
import java.util.Random;

/**
 * @author Karl Bennett
 */
class DateTimeStamps implements TimeStamps {

    private static final int MILLISECOND_IN_ONE_DAY = 86400000;
    private static final int MILLISECOND_IN_ONE_WEEK = 604800000;

    private final Random random;
    private final Days days;

    public DateTimeStamps(Random random, Days days) {
        this.random = random;
        this.days = days;
    }

    @Override
    public Date date(long date) {
        return new Date(date);
    }

    @Override
    public long now() {
        return new Date().getTime();
    }

    @Override
    public long someTimeInADay() {
        return random.nextInt(MILLISECOND_IN_ONE_DAY);
    }

    @Override
    public long yesterdayMidnight() {
        return days.yesterday().getTime();
    }

    @Override
    public long todayMidnight() {
        return days.today().getTime();
    }

    @Override
    public long tomorrowMidnight() {
        return days.tomorrow().getTime();
    }

    @Override
    public long someTimeInAWeek() {
        return random.nextInt(MILLISECOND_IN_ONE_WEEK);
    }

    @Override
    public long midnightMondayLastWeek() {
        return days.mondayLastWeek().getTime();
    }

    @Override
    public long midnightMondayThisWeek() {
        return days.mondayThisWeek().getTime();
    }

    @Override
    public long midnightMondayNextWeek() {
        return days.mondayNextWeek().getTime();
    }
}
