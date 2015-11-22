package shiver.me.timbers.data.random;

import java.util.Date;

import static shiver.me.timbers.data.random.WeekDay.MONDAY;

/**
 * @author Karl Bennett
 */
class RandomTimeBuilderFactory implements RandomTimeFactory<RandomTimeBuilder> {

    private final TimeStamps timeStamps;
    private final Numbers<Long> longs;

    public RandomTimeBuilderFactory(TimeStamps timeStamps, Numbers<Long> longs) {
        this.timeStamps = timeStamps;
        this.longs = longs;
    }

    @Override
    public RandomTimeBuilder create(Date date) {
        return create(date.getTime());
    }

    @Override
    public RandomTimeBuilder now() {
        return create(timeStamps.now());
    }

    @Override
    public RandomTimeBuilder between(Date min, Date max) {
        final long minTime = min.getTime();
        final long maxTime = max.getTime();
        return create(longs.someNumberBetween(minTime, maxTime));
    }

    @Override
    public RandomTimeBuilder today() {
        return create(timeStamps.todayMidnight() + timeStamps.someTimeInADay());
    }

    @Override
    public RandomTimeBuilder thisWeek() {
        return create(timeStamps.midnightThisWeekOn(MONDAY) + timeStamps.someTimeInAWeek());
    }

    @Override
    public RandomTimeBuilder thisWeekOn(WeekDay weekDay) {
        return create(timeStamps.midnightThisWeekOn(weekDay) + timeStamps.someTimeInADay());
    }

    @Override
    public RandomTimeBuilder lastMonth() {
        return create(timeStamps.midnightLastMonthOnThe(1) + timeStamps.someTimeInAMonth());
    }

    @Override
    public RandomTimeBuilder thisMonth() {
        return create(timeStamps.midnightThisMonthOnThe(1) + timeStamps.someTimeInAMonth());
    }

    @Override
    public RandomTimeBuilder nextMonth() {
        return create(timeStamps.midnightNextMonthOnThe(1) + timeStamps.someTimeInAMonth());
    }

    @Override
    public RandomTimeBuilder lastMonthOnThe(int date) {
        return create(timeStamps.midnightLastMonthOnThe(date) + timeStamps.someTimeInADay());
    }

    @Override
    public RandomTimeBuilder thisMonthOnThe(int date) {
        return create(timeStamps.midnightThisMonthOnThe(date) + timeStamps.someTimeInADay());
    }

    @Override
    public RandomTimeBuilder nextMonthOnThe(int date) {
        return create(timeStamps.midnightNextMonthOnThe(date) + timeStamps.someTimeInADay());
    }

    @Override
    public RandomTimeBuilder lastYear() {
        return create(timeStamps.midnightLastYearOnDay(1) + timeStamps.someTimeInAYear());
    }

    @Override
    public RandomTimeBuilder thisYear() {
        return create(timeStamps.midnightThisYearOnDay(1) + timeStamps.someTimeInAYear());
    }

    @Override
    public RandomTimeBuilder nextYear() {
        return create(timeStamps.midnightNextYearOnDay(1) + timeStamps.someTimeInAYear());
    }

    @Override
    public RandomTimeBuilder lastYearOnDay(int day) {
        return create(timeStamps.midnightLastYearOnDay(day) + timeStamps.someTimeInADay());
    }

    @Override
    public RandomTimeBuilder thisYearOnDay(int day) {
        return create(timeStamps.midnightThisYearOnDay(day) + timeStamps.someTimeInADay());
    }

    @Override
    public RandomTimeBuilder nextYearOnDay(int day) {
        return create(timeStamps.midnightNextYearOnDay(day) + timeStamps.someTimeInADay());
    }

    @Override
    public RandomTimeBuilder random() {
        return create(longs.someNumber());
    }

    private RandomTimeBuilder create(long time) {
        return new RandomTimeBuilder(timeStamps, longs, time);
    }
}
