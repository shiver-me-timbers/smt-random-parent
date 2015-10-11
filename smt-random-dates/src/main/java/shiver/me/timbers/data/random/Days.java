package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
interface Days {

    Date yesterday();

    Date today();

    Date tomorrow();

    Date lastWeekOn(WeekDay weekDay);

    Date thisWeekOn(WeekDay weekDay);

    Date nextWeekOn(WeekDay weekDay);
}
