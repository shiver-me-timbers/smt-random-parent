package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
interface Calendar {

    Calendar minusDays(int days);

    Calendar addDays(int days);

    Calendar withDayOfWeek(WeekDay weekDay);

    Calendar minusWeeks(int weeks);

    Calendar addWeeks(int weeks);

    Date toDate();

    long toTime();
}
