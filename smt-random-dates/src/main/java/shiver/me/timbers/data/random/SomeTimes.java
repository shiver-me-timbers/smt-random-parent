package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
class SomeTimes implements Times {

    private final TimeStamps timeStamps;
    private final Numbers<Long> longs;

    public SomeTimes(TimeStamps timeStamps, Numbers<Long> longs) {
        this.timeStamps = timeStamps;
        this.longs = longs;
    }

    @Override
    public Date someTime() {
        return timeStamps.date(longs.someNumber());
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
        return timeStamps.date(longs.someNumberBetween(minTime, maxTime) - 1);
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

    @Override
    public Date someTimeLastWeek() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Date someTimeThisWeek() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Date someTimeNextWeek() {
        throw new UnsupportedOperationException();
    }

    private Date someDateBefore(long time) {
        return timeStamps.date(time + (longs.someNegativeNumber() - 1));
    }

    private Date someDateAfter(long time) {
        return timeStamps.date(time + (longs.somePositiveNumber() + 1));
    }

    private Date someDateInDay(long midnightTime) {
        return timeStamps.date(midnightTime + timeStamps.someTimeInADay());
    }
}
