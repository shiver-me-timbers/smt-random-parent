package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
interface Times {

    RandomTimeBuilder someTime();

    RandomTimeBuilder someTimeInThePast();

    RandomTimeBuilder someTimeInTheFuture();

    RandomTimeBuilder someTimeBefore(Date date);

    RandomTimeBuilder someTimeAfter(Date date);

    RandomTimeBuilder someTimeBetween(Date min, Date max);

    RandomTimeBuilder someTimeYesterday();

    RandomTimeBuilder someTimeToday();

    RandomTimeBuilder someTimeTomorrow();

    RandomTimeBuilder someTimeLastWeek();

    RandomTimeBuilder someTimeThisWeek();

    RandomTimeBuilder someTimeNextWeek();

    RandomTimeBuilder someTimeLastWeekOn(WeekDay weekDay);

    RandomTimeBuilder someTimeThisWeekOn(WeekDay weekDay);

    RandomTimeBuilder someTimeNextWeekOn(WeekDay weekDay);

    RandomTimeBuilder someTimeLastMonth();

    RandomTimeBuilder someTimeThisMonth();

    RandomTimeBuilder someTimeNextMonth();

    RandomTimeBuilder someTimeLastMonthOnThe(int date);

    RandomTimeBuilder someTimeThisMonthOnThe(int date);

    RandomTimeBuilder someTimeNextMonthOnThe(int date);

    RandomTimeBuilder someTimeLastYear();

    RandomTimeBuilder someTimeThisYear();

    RandomTimeBuilder someTimeNextYear();

    RandomTimeBuilder someTimeLastYearOnDay(int day);

    RandomTimeBuilder someTimeThisYearOnDay(int day);

    RandomTimeBuilder someTimeNextYearOnDay(int day);
}
