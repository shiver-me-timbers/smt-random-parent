package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
interface Times {

    RandomDateBuilder someTime();

    RandomDateBuilder someTimeInThePast();

    RandomDateBuilder someTimeInTheFuture();

    RandomDateBuilder someTimeBefore(Date date);

    RandomDateBuilder someTimeAfter(Date date);

    RandomDateBuilder someTimeBetween(Date min, Date max);

    RandomDateBuilder someTimeYesterday();

    RandomDateBuilder someTimeToday();

    RandomDateBuilder someTimeTomorrow();

    RandomDateBuilder someTimeLastWeek();

    RandomDateBuilder someTimeThisWeek();

    RandomDateBuilder someTimeNextWeek();

    RandomDateBuilder someTimeLastWeekOn(WeekDay weekDay);

    RandomDateBuilder someTimeThisWeekOn(WeekDay weekDay);

    RandomDateBuilder someTimeNextWeekOn(WeekDay weekDay);
}
