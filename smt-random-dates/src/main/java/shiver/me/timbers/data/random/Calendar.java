package shiver.me.timbers.data.random;

/**
 * @author Karl Bennett
 */
interface Calendar {

    Calendar minusSeconds(int seconds);

    Calendar addSeconds(int seconds);

    Calendar minusMinutes(int minutes);

    Calendar addMinutes(int minutes);

    Calendar minusHours(int hours);

    Calendar addHours(int hours);

    Calendar minusDays(int days);

    Calendar addDays(int days);

    Calendar withDayOfWeek(WeekDay weekDay);

    Calendar minusWeeks(int weeks);

    Calendar addWeeks(int weeks);

    Calendar withDateOfMonth(int date);

    Calendar minusMonths(int months);

    Calendar addMonths(int months);

    Calendar withDayOfYear(int day);

    Calendar minusYears(int years);

    Calendar addYears(int years);

    int daysInMonth();

    int daysInYear();

    long getTime();
}
