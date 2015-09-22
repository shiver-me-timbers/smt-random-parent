package shiver.me.timbers.data.random;

import java.util.Date;
import java.util.Random;

/**
 * @author Karl Bennett
 */
class SomeDates implements Dates {

    private static final int MILLISECOND_IN_ONE_DAY = 86400000;

    private final Random random;
    private final DateFactory dateFactory;

    public SomeDates(Random random, DateFactory dateFactory) {
        this.random = random;
        this.dateFactory = dateFactory;
    }

    @Override
    public Date someDate() {
        return dateFactory.date(random.nextLong());
    }

    @Override
    public Date somePastDate() {
        return someDateBefore(dateFactory.nowTime());
    }

    @Override
    public Date someFutureDate() {
        return someDateAfter(dateFactory.nowTime());
    }

    @Override
    public Date someDateBefore(Date date) {
        return someDateBefore(date.getTime());
    }

    @Override
    public Date someDateAfter(Date date) {
        return someDateAfter(date.getTime());
    }

    @Override
    public Date someDateBetween(Date min, Date max) {

        final long minTime = min.getTime();
        final long maxTime = max.getTime();

        // Minus 1 of the range to make sure it is upper bound exclusive.
        return dateFactory.date(minTime + nextPositiveLong((maxTime - minTime) - 1));
    }

    @Override
    public Date someDateYesterday() {
        return someDateInDay(dateFactory.yesterdayMidnightTime());
    }

    @Override
    public Date someDateToday() {
        return someDateInDay(dateFactory.todayMidnight());
    }

    @Override
    public Date someDateTomorrow() {
        return someDateInDay(dateFactory.tomorrowMidnightTime());
    }

    private Date someDateBefore(long time) {
        return dateFactory.date(time - nextPositiveLong());
    }

    private Date someDateAfter(long time) {
        return dateFactory.date(time + nextPositiveLong());
    }

    private Date someDateInDay(long midnightTime) {
        return dateFactory.date(midnightTime + nextPositiveInt(MILLISECOND_IN_ONE_DAY));
    }

    private long nextPositiveLong() {

        final long next = random.nextLong();

        if (next >= 0) {
            return next;
        }

        return next * -1;
    }

    private long nextPositiveLong(long bound) {
        return (long) (random.nextDouble() * bound);
    }

    private int nextPositiveInt(int bound) {

        final int next = random.nextInt(bound);

        if (next >= 0) {
            return next;
        }

        return next * -1;
    }
}
