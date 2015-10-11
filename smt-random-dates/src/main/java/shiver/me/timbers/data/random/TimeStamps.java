package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
interface TimeStamps {

    Date date(long date);

    long now();

    long someTimeInADay();

    long yesterdayMidnight();

    long todayMidnight();

    long tomorrowMidnight();

    long someTimeInAWeek();

    long midnightLastWeekOn(WeekDay weekDay);

    long midnightThisWeekOn(WeekDay weekDay);

    long midnightNextWeekOn(WeekDay weekDay);
}
