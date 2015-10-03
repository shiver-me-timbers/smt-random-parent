package shiver.me.timbers.data.random;

import java.util.Date;
import java.util.Random;

/**
 * @author Karl Bennett
 */
class SomeTimes implements Times {

    private static final int MILLISECOND_IN_ONE_DAY = 86400000;

    private final Random random;
    private final TimeStamps timeStamps;

    public SomeTimes(Random random, TimeStamps timeStamps) {
        this.random = random;
        this.timeStamps = timeStamps;
    }

    @Override
    public Date someTime() {
        return timeStamps.date(random.nextLong());
    }

    @Override
    public Date someTimeInThePast() {
        return someDateBefore(timeStamps.now());
    }

    @Override
    public Date someTimeInTheFuture() {
        return someDateAfter(timeStamps.now());
    }

    @Override
    public Date someTimeBefore(Date date) {
        return someDateBefore(date.getTime());
    }

    @Override
    public Date someTimeAfter(Date date) {
        return someDateAfter(date.getTime());
    }

    @Override
    public Date someTimeBetween(Date min, Date max) {

        final long minTime = min.getTime();
        final long maxTime = max.getTime();

        // Minus 1 off the range to make sure it is upper bound exclusive.
        return timeStamps.date(minTime + nextPositiveLong((maxTime - minTime) - 1));
    }

    @Override
    public Date someTimeYesterday() {
        return someDateInDay(timeStamps.yesterdayMidnight());
    }

    @Override
    public Date someTimeToday() {
        return someDateInDay(timeStamps.todayMidnight());
    }

    @Override
    public Date someTimeTomorrow() {
        return someDateInDay(timeStamps.tomorrowMidnight());
    }

    private Date someDateBefore(long time) {
        return timeStamps.date(time - nextPositiveLong());
    }

    private Date someDateAfter(long time) {
        return timeStamps.date(time + nextPositiveLong());
    }

    private Date someDateInDay(long midnightTime) {
        return timeStamps.date(midnightTime + nextPositiveInt(MILLISECOND_IN_ONE_DAY));
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
