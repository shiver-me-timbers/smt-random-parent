package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
interface RandomTimeFactory<D extends Date> {

    D create(Date date);

    D now();

    D between(Date min, Date max);

    D thisMinute();

    D thisHour();

    D today();

    D thisWeek();

    D thisWeekOn(WeekDay weekDay);

    D lastMonth();

    D thisMonth();

    D nextMonth();

    D lastMonthOnThe(int date);

    D thisMonthOnThe(int date);

    D nextMonthOnThe(int date);

    D lastYear();

    D thisYear();

    D nextYear();

    D lastYearOnDay(int day);

    D thisYearOnDay(int day);

    D nextYearOnDay(int day);

    D random();
}
