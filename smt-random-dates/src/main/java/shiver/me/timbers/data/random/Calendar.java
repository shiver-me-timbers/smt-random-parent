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

    Calendar withDateOfMonth(int date);

    Calendar withDayOfYear(int day);

    Calendar minusMonths(int months);

    Calendar addMonths(int months);

    Calendar minusYears(int years);

    Calendar addYears(int years);

    long toTime();
}
