package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
interface Calendar {

    Calendar minusDays(int days);

    Calendar plusDays(int days);

    Calendar withDayOfWeek(DayOfWeek dayOfWeek);

    Calendar minusWeeks(int weeks);

    Calendar plusWeeks(int weeks);

    Date toDate();
}
