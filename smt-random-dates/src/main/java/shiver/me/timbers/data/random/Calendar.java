package shiver.me.timbers.data.random;

/**
 * @author Karl Bennett
 */
interface Calendar {

    Calendar minusDays(int days);

    Calendar addDays(int days);

    Calendar withDayOfWeek(WeekDay weekDay);

    Calendar minusWeeks(int weeks);

    Calendar addWeeks(int weeks);

    long toTime();
}
