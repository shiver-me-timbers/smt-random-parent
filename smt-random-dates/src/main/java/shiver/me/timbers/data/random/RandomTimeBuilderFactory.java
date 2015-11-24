package shiver.me.timbers.data.random;

import java.util.Date;

import static shiver.me.timbers.data.random.WeekDay.MONDAY;

/**
 * @author Karl Bennett
 */
class RandomTimeBuilderFactory implements RandomTimeFactory<RandomTimeBuilder> {

    private final Calendars calendars;
    private final RandomDurations randomDurations;
    private final Numbers<Long> longs;

    public RandomTimeBuilderFactory(Calendars calendars, RandomDurations randomDurations, Numbers<Long> longs) {
        this.calendars = calendars;
        this.randomDurations = randomDurations;
        this.longs = longs;
    }

    @Override
    public RandomTimeBuilder create(Date date) {
        return create(date.getTime());
    }

    @Override
    public RandomTimeBuilder now() {
        return create(calendars.now().getTime());
    }

    @Override
    public RandomTimeBuilder between(Date min, Date max) {
        final long minTime = min.getTime();
        final long maxTime = max.getTime();
        return create(longs.someNumberBetween(minTime, maxTime));
    }

    @Override
    public RandomTimeBuilder today() {
        return create(calendars.midnightToday().getTime() + randomDurations.someTimeInADay());
    }

    @Override
    public RandomTimeBuilder thisWeek() {
        return create(dayInWeek(MONDAY) + randomDurations.someTimeInAWeek());
    }

    @Override
    public RandomTimeBuilder thisWeekOn(WeekDay weekDay) {
        return create(dayInWeek(weekDay) + randomDurations.someTimeInADay());
    }

    @Override
    public RandomTimeBuilder lastMonth() {
        return createWithinMonth(calendars.midnightToday().minusMonths(1));
    }

    @Override
    public RandomTimeBuilder thisMonth() {
        return createWithinMonth(calendars.midnightToday());
    }

    @Override
    public RandomTimeBuilder nextMonth() {
        return createWithinMonth(calendars.midnightToday().addMonths(1));
    }

    @Override
    public RandomTimeBuilder lastMonthOnThe(int date) {
        return createInMonthOnThe(calendars.midnightToday().minusMonths(1), date);
    }

    @Override
    public RandomTimeBuilder thisMonthOnThe(int date) {
        return createInMonthOnThe(calendars.midnightToday(), date);
    }

    @Override
    public RandomTimeBuilder nextMonthOnThe(int date) {
        return createInMonthOnThe(calendars.midnightToday().addMonths(1), date);
    }

    @Override
    public RandomTimeBuilder lastYear() {
        return createWithinYear(calendars.midnightToday().minusYears(1));
    }

    @Override
    public RandomTimeBuilder thisYear() {
        return createWithinYear(calendars.midnightToday());
    }

    @Override
    public RandomTimeBuilder nextYear() {
        return createWithinYear(calendars.midnightToday().addYears(1));
    }

    @Override
    public RandomTimeBuilder lastYearOnDay(int day) {
        return createInYearOnDay(calendars.midnightToday().minusYears(1), day);
    }

    @Override
    public RandomTimeBuilder thisYearOnDay(int day) {
        return createInYearOnDay(calendars.midnightToday(), day);
    }

    @Override
    public RandomTimeBuilder nextYearOnDay(int day) {
        return createInYearOnDay(calendars.midnightToday().addYears(1), day);
    }

    @Override
    public RandomTimeBuilder random() {
        return create(longs.someNumber());
    }

    @Override
    public RandomTimeBuilder thisHour() {
        return create(calendars.startOfThisHour().getTime() + randomDurations.someTimeInAnHour());
    }

    private RandomTimeBuilder create(long time) {
        return new RandomTimeBuilder(calendars, longs, time);
    }

    private long dayInWeek(WeekDay weekDay) {
        return calendars.midnightToday().withDayOfWeek(weekDay).getTime();
    }

    private RandomTimeBuilder createWithinMonth(Calendar month) {
        return create(month.withDateOfMonth(1).getTime() + randomDurations.someTimeInDays(month.daysInMonth()));
    }

    private RandomTimeBuilder createInMonthOnThe(Calendar month, int date) {
        return create(month.withDateOfMonth(date).getTime() + randomDurations.someTimeInADay());
    }

    private RandomTimeBuilder createWithinYear(Calendar year) {
        return create(year.withDayOfYear(1).getTime() + randomDurations.someTimeInDays(year.daysInYear()));
    }

    private RandomTimeBuilder createInYearOnDay(Calendar year, int day) {
        return create(year.withDayOfYear(day).getTime() + randomDurations.someTimeInADay());
    }
}
