package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
class SomeTimes implements Times {

    private final RandomTimeCreator<RandomTimeBuilder> randomTimeCreator;

    public SomeTimes(RandomTimeCreator<RandomTimeBuilder> randomTimeCreator) {
        this.randomTimeCreator = randomTimeCreator;
    }

    @Override
    public RandomTimeBuilder someTime() {
        return randomTimeCreator.random();
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
        return randomTimeCreator.between(min, max);
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
        return thisMonth().minusMonths(1);
    }

    @Override
    public RandomTimeBuilder someTimeThisMonth() {
        return thisMonth();
    }

    @Override
    public RandomTimeBuilder someTimeNextMonth() {
        return thisMonth().addMonths(1);
    }

    @Override
    public RandomTimeBuilder someTimeLastMonthOnThe(int date) {
        return thisMonthOnThe(date).minusMonths(1);
    }

    @Override
    public RandomTimeBuilder someTimeThisMonthOnThe(int date) {
        return thisMonthOnThe(date);
    }

    @Override
    public RandomTimeBuilder someTimeNextMonthOnThe(int date) {
        return thisMonthOnThe(date).addMonths(1);
    }

    @Override
    public RandomTimeBuilder someTimeLastYear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public RandomTimeBuilder someTimeThisYear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public RandomTimeBuilder someTimeNextYear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public RandomTimeBuilder someTimeLastYearOnThe(int day) {
        throw new UnsupportedOperationException();
    }

    @Override
    public RandomTimeBuilder someTimeThisYearOnThe(int day) {
        throw new UnsupportedOperationException();
    }

    @Override
    public RandomTimeBuilder someTimeNextYearOnThe(int day) {
        throw new UnsupportedOperationException();
    }

    private RandomTimeBuilder now() {
        return randomTimeCreator.now();
    }

    private RandomTimeBuilder create(Date date) {
        return randomTimeCreator.create(date);
    }

    private RandomTimeBuilder today() {
        return randomTimeCreator.today();
    }

    private RandomTimeBuilder thisWeek() {
        return randomTimeCreator.thisWeek();
    }

    private RandomTimeBuilder thisWeekOn(WeekDay weekDay) {
        return randomTimeCreator.thisWeekOn(weekDay);
    }

    private RandomTimeBuilder thisMonth() {
        return randomTimeCreator.thisMonth();
    }

    private RandomTimeBuilder thisMonthOnThe(int date) {
        return randomTimeCreator.thisMonthOnThe(date);
    }
}
