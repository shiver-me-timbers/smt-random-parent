package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
interface RandomTimeCreator<D extends Date> {

    D create(Date date);

    D now();

    D between(Date min, Date max);

    D today();

    D thisWeek();

    D thisWeekOn(WeekDay weekDay);

    D thisMonth();

    D thisMonthOnThe(int date);

    D thisYear();

    D thisYearOnDay(int day);

    D random();
}
