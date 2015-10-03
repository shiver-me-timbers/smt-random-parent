package shiver.me.timbers.data.random;

import java.util.Date;
import java.util.Random;

/**
 * @author Karl Bennett
 */
class DateTimeStamps implements TimeStamps {

    private static final int MILLISECOND_IN_ONE_DAY = 86400000;

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
}
