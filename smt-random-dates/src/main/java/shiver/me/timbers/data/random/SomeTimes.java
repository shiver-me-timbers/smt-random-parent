package shiver.me.timbers.data.random;

import java.util.Date;

import static shiver.me.timbers.data.random.WeekDay.MONDAY;

/**
 * @author Karl Bennett
 */
class SomeTimes implements Times {

    private final TimeStamps timeStamps;
    private final Numbers<Long> longs;
    private final RandomTimeCreator<RandomTimeBuilder> randomTimeCreator;

    public SomeTimes(
        TimeStamps timeStamps, Numbers<Long> longs,
        RandomTimeCreator<RandomTimeBuilder> randomTimeCreator
    ) {
        this.timeStamps = timeStamps;
        this.longs = longs;
        this.randomTimeCreator = randomTimeCreator;
    }

    @Override
    public RandomTimeBuilder someTime() {
        return randomTimeCreator.create(timeStamps.date(longs.someNumber()));
    }

    @Override
    public RandomTimeBuilder someTimeInThePast() {
        return someTimeBefore(timeStamps.now());
    }

    @Override
    public RandomTimeBuilder someTimeInTheFuture() {
        return someTimeAfter(timeStamps.now());
    }

    @Override
    public RandomTimeBuilder someTimeBefore(Date date) {
        return someTimeBefore(date.getTime());
    }

    @Override
    public RandomTimeBuilder someTimeAfter(Date date) {
        return someTimeAfter(date.getTime());
    }

    @Override
    public RandomTimeBuilder someTimeBetween(Date min, Date max) {

        final long minTime = min.getTime();
        final long maxTime = max.getTime();

        // Minus 1 off the range to make sure it is upper bound exclusive.
        return randomTimeCreator.create(timeStamps.date(longs.someNumberBetween(minTime, maxTime) - 1));
    }

    @Override
    public RandomTimeBuilder someTimeYesterday() {
        return someTimeInDay(timeStamps.yesterdayMidnight());
    }

    @Override
    public RandomTimeBuilder someTimeToday() {
        return someTimeInDay(timeStamps.todayMidnight());
    }

    @Override
    public RandomTimeBuilder someTimeTomorrow() {
        return someTimeInDay(timeStamps.tomorrowMidnight());
    }

    @Override
    public RandomTimeBuilder someTimeLastWeek() {
        return someTimeInWeek(timeStamps.midnightLastWeekOn(MONDAY));
    }

    @Override
    public RandomTimeBuilder someTimeThisWeek() {
        return someTimeInWeek(timeStamps.midnightThisWeekOn(MONDAY));
    }

    @Override
    public RandomTimeBuilder someTimeNextWeek() {
        return someTimeInWeek(timeStamps.midnightNextWeekOn(MONDAY));
    }

    @Override
    public RandomTimeBuilder someTimeLastWeekOn(WeekDay weekDay) {
        return someTimeInDay(timeStamps.midnightLastWeekOn(weekDay));
    }

    @Override
    public RandomTimeBuilder someTimeThisWeekOn(WeekDay weekDay) {
        return someTimeInDay(timeStamps.midnightThisWeekOn(weekDay));
    }

    @Override
    public RandomTimeBuilder someTimeNextWeekOn(WeekDay weekDay) {
        return someTimeInDay(timeStamps.midnightNextWeekOn(weekDay));
    }

    private RandomTimeBuilder someTimeBefore(long time) {
        return randomTimeCreator.create(timeStamps.date(time + (longs.someNegativeNumber() - 1)));
    }

    private RandomTimeBuilder someTimeAfter(long time) {
        return randomTimeCreator.create(timeStamps.date(time + (longs.somePositiveNumber() + 1)));
    }

    private RandomTimeBuilder someTimeInDay(long midnightTime) {
        return randomTimeCreator.create(timeStamps.date(midnightTime + timeStamps.someTimeInADay()));
    }

    public RandomTimeBuilder someTimeInWeek(long midnightTime) {
        return randomTimeCreator.create(timeStamps.date(midnightTime + timeStamps.someTimeInAWeek()));
    }
}
