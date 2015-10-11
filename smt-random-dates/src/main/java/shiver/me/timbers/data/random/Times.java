package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
interface Times {

    Date someTime();

    Date someTimeInThePast();

    Date someTimeInTheFuture();

    Date someTimeBefore(Date date);

    Date someTimeAfter(Date date);

    Date someTimeBetween(Date min, Date max);

    Date someTimeYesterday();

    Date someTimeToday();

    Date someTimeTomorrow();

    Date someTimeOn(WeekDay weekDay);

    Date someTimeLastWeek();

    Date someTimeThisWeek();

    Date someTimeNextWeek();
}
