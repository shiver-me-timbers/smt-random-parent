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
}
