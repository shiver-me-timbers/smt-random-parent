package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
class SomeTimes implements Times {

    private final RandomTimeFactory<RandomTimeBuilder> randomTimeFactory;

    public SomeTimes(RandomTimeFactory<RandomTimeBuilder> randomTimeFactory) {
        this.randomTimeFactory = randomTimeFactory;
    }

    @Override
    public RandomTimeBuilder someTime() {
        return randomTimeFactory.random();
    }

    @Override
    public RandomTimeBuilder someTimeInThePast() {
        return now().inThePast();
    }

    @Override
    public RandomTimeBuilder someTimeInTheFuture() {
        return now().inTheFuture();
    }

    @Override
    public RandomTimeBuilder someTimeBefore(Date date) {
        return create(date).inThePast();
    }

    @Override
    public RandomTimeBuilder someTimeAfter(Date date) {
        return create(date).inTheFuture();
    }

    @Override
    public RandomTimeBuilder someTimeBetween(Date min, Date max) {
        return randomTimeFactory.between(min, max);
    }

    @Override
    public RandomTimeBuilder someTimeYesterday() {
        return today().minusDays(1);
    }

    @Override
    public RandomTimeBuilder someTimeToday() {
        return today();
    }

    @Override
    public RandomTimeBuilder someTimeTomorrow() {
        return today().addDays(1);
    }

    @Override
    public RandomTimeBuilder someTimeLastWeek() {
        return thisWeek().minusWeeks(1);
    }

    @Override
    public RandomTimeBuilder someTimeThisWeek() {
        return thisWeek();
    }

    @Override
    public RandomTimeBuilder someTimeNextWeek() {
        return thisWeek().addWeeks(1);
    }

    @Override
    public RandomTimeBuilder someTimeLastWeekOn(WeekDay weekDay) {
        return thisWeekOn(weekDay).minusWeeks(1);
    }

    @Override
    public RandomTimeBuilder someTimeThisWeekOn(WeekDay weekDay) {
        return thisWeekOn(weekDay);
    }

    @Override
    public RandomTimeBuilder someTimeNextWeekOn(WeekDay weekDay) {
        return thisWeekOn(weekDay).addWeeks(1);
    }

    @Override
    public RandomTimeBuilder someTimeLastMonth() {
        return randomTimeFactory.lastMonth();
    }

    @Override
    public RandomTimeBuilder someTimeThisMonth() {
        return thisMonth();
    }

    @Override
    public RandomTimeBuilder someTimeNextMonth() {
        return randomTimeFactory.nextMonth();
    }

    @Override
    public RandomTimeBuilder someTimeLastMonthOnThe(int date) {
        return randomTimeFactory.lastMonthOnThe(date);
    }

    @Override
    public RandomTimeBuilder someTimeThisMonthOnThe(int date) {
        return thisMonthOnThe(date);
    }

    @Override
    public RandomTimeBuilder someTimeNextMonthOnThe(int date) {
        return randomTimeFactory.nextMonthOnThe(date);
    }

    @Override
    public RandomTimeBuilder someTimeLastYear() {
        return randomTimeFactory.lastYear();
    }

    @Override
    public RandomTimeBuilder someTimeThisYear() {
        return thisYear();
    }

    @Override
    public RandomTimeBuilder someTimeNextYear() {
        return randomTimeFactory.nextYear();
    }

    @Override
    public RandomTimeBuilder someTimeLastYearOnDay(int day) {
        return randomTimeFactory.lastYearOnDay(day);
    }

    @Override
    public RandomTimeBuilder someTimeThisYearOnDay(int day) {
        return thisYearOn(day);
    }

    @Override
    public RandomTimeBuilder someTimeNextYearOnDay(int day) {
        return randomTimeFactory.nextYearOnDay(day);
    }

    private RandomTimeBuilder now() {
        return randomTimeFactory.now();
    }

    private RandomTimeBuilder create(Date date) {
        return randomTimeFactory.create(date);
    }

    private RandomTimeBuilder today() {
        return randomTimeFactory.today();
    }

    private RandomTimeBuilder thisWeek() {
        return randomTimeFactory.thisWeek();
    }

    private RandomTimeBuilder thisWeekOn(WeekDay weekDay) {
        return randomTimeFactory.thisWeekOn(weekDay);
    }

    private RandomTimeBuilder thisMonth() {
        return randomTimeFactory.thisMonth();
    }

    private RandomTimeBuilder thisMonthOnThe(int date) {
        return randomTimeFactory.thisMonthOnThe(date);
    }

    private RandomTimeBuilder thisYear() {
        return randomTimeFactory.thisYear();
    }

    private RandomTimeBuilder thisYearOn(int day) {
        return randomTimeFactory.thisYearOnDay(day);
    }
}
