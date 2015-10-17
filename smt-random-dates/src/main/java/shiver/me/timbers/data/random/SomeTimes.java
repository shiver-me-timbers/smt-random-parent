package shiver.me.timbers.data.random;

import java.util.Date;

import static shiver.me.timbers.data.random.WeekDay.MONDAY;

/**
 * @author Karl Bennett
 */
class SomeTimes implements Times {

    private final TimeStamps timeStamps;
    private final Numbers<Long> longs;
    private final RandomDateBuilder randomDateBuilder;

    public SomeTimes(TimeStamps timeStamps, Numbers<Long> longs, RandomDateBuilder randomDateBuilder) {
        this.timeStamps = timeStamps;
        this.longs = longs;
        this.randomDateBuilder = randomDateBuilder;
    }

    @Override
    public RandomDateBuilder someTime() {
        return randomDateBuilder.create(timeStamps.date(longs.someNumber()));
    }

    @Override
    public RandomDateBuilder someTimeInThePast() {
        return someTimeBefore(timeStamps.now());
    }

    @Override
    public RandomDateBuilder someTimeInTheFuture() {
        return someTimeAfter(timeStamps.now());
    }

    @Override
    public RandomDateBuilder someTimeBefore(Date date) {
        return someTimeBefore(date.getTime());
    }

    @Override
    public RandomDateBuilder someTimeAfter(Date date) {
        return someTimeAfter(date.getTime());
    }

    @Override
    public RandomDateBuilder someTimeBetween(Date min, Date max) {

        final long minTime = min.getTime();
        final long maxTime = max.getTime();

        // Minus 1 off the range to make sure it is upper bound exclusive.
        return randomDateBuilder.create(timeStamps.date(longs.someNumberBetween(minTime, maxTime) - 1));
    }

    @Override
    public RandomDateBuilder someTimeYesterday() {
        return someTimeInDay(timeStamps.yesterdayMidnight());
    }

    @Override
    public RandomDateBuilder someTimeToday() {
        return someTimeInDay(timeStamps.todayMidnight());
    }

    @Override
    public RandomDateBuilder someTimeTomorrow() {
        return someTimeInDay(timeStamps.tomorrowMidnight());
    }

    @Override
    public RandomDateBuilder someTimeLastWeek() {
        return someTimeInWeek(timeStamps.midnightLastWeekOn(MONDAY));
    }

    @Override
    public RandomDateBuilder someTimeThisWeek() {
        return someTimeInWeek(timeStamps.midnightThisWeekOn(MONDAY));
    }

    @Override
    public RandomDateBuilder someTimeNextWeek() {
        return someTimeInWeek(timeStamps.midnightNextWeekOn(MONDAY));
    }

    @Override
    public RandomDateBuilder someTimeLastWeekOn(WeekDay weekDay) {
        return someTimeInDay(timeStamps.midnightLastWeekOn(weekDay));
    }

    @Override
    public RandomDateBuilder someTimeThisWeekOn(WeekDay weekDay) {
        return someTimeInDay(timeStamps.midnightThisWeekOn(weekDay));
    }

    @Override
    public RandomDateBuilder someTimeNextWeekOn(WeekDay weekDay) {
        return someTimeInDay(timeStamps.midnightNextWeekOn(weekDay));
    }

    private RandomDateBuilder someTimeBefore(long time) {
        return randomDateBuilder.create(timeStamps.date(time + (longs.someNegativeNumber() - 1)));
    }

    private RandomDateBuilder someTimeAfter(long time) {
        return randomDateBuilder.create(timeStamps.date(time + (longs.somePositiveNumber() + 1)));
    }

    private RandomDateBuilder someTimeInDay(long midnightTime) {
        return randomDateBuilder.create(timeStamps.date(midnightTime + timeStamps.someTimeInADay()));
    }

    public RandomDateBuilder someTimeInWeek(long midnightTime) {
        return randomDateBuilder.create(timeStamps.date(midnightTime + timeStamps.someTimeInAWeek()));
    }
}
