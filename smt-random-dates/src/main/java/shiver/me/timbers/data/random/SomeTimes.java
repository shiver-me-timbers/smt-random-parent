package shiver.me.timbers.data.random;

import java.util.Date;

import static shiver.me.timbers.data.random.WeekDay.MONDAY;

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
        return someTimeBefore(timeStamps.now());
    }

    @Override
    public Date someTimeInTheFuture() {
        return someTimeAfter(timeStamps.now());
    }

    @Override
    public Date someTimeBefore(Date date) {
        return someTimeBefore(date.getTime());
    }

    @Override
    public Date someTimeAfter(Date date) {
        return someTimeAfter(date.getTime());
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
        return someTimeInDay(timeStamps.yesterdayMidnight());
    }

    @Override
    public Date someTimeToday() {
        return someTimeInDay(timeStamps.todayMidnight());
    }

    @Override
    public Date someTimeTomorrow() {
        return someTimeInDay(timeStamps.tomorrowMidnight());
    }

    @Override
    public Date someTimeLastWeek() {
        return someTimeInWeek(timeStamps.midnightLastWeekOn(MONDAY));
    }

    @Override
    public Date someTimeThisWeek() {
        return someTimeInWeek(timeStamps.midnightThisWeekOn(MONDAY));
    }

    @Override
    public Date someTimeNextWeek() {
        return someTimeInWeek(timeStamps.midnightNextWeekOn(MONDAY));
    }

    @Override
    public Date someTimeLastWeekOn(WeekDay weekDay) {
        return someTimeInDay(timeStamps.midnightLastWeekOn(weekDay));
    }

    @Override
    public Date someTimeThisWeekOn(WeekDay weekDay) {
        return someTimeInDay(timeStamps.midnightThisWeekOn(weekDay));
    }

    @Override
    public Date someTimeNextWeekOn(WeekDay weekDay) {
        return someTimeInDay(timeStamps.midnightNextWeekOn(weekDay));
    }

    private Date someTimeBefore(long time) {
        return timeStamps.date(time + (longs.someNegativeNumber() - 1));
    }

    private Date someTimeAfter(long time) {
        return timeStamps.date(time + (longs.somePositiveNumber() + 1));
    }

    private Date someTimeInDay(long midnightTime) {
        return timeStamps.date(midnightTime + timeStamps.someTimeInADay());
    }

    public Date someTimeInWeek(long midnightTime) {
        return timeStamps.date(midnightTime + timeStamps.someTimeInAWeek());
    }
}
