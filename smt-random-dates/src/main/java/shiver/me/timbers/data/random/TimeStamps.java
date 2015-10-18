package shiver.me.timbers.data.random;

/**
 * @author Karl Bennett
 */
interface TimeStamps {

    long now();

    long todayMidnight();

    long someTimeInADay();

    long someTimeInAWeek();

    long midnightThisWeekOn(WeekDay weekDay);

    long minusDays(Long time, int days);

    long addDays(Long time, int days);

    long minusWeeks(Long time, int weeks);

    long addWeeks(Long time, int weeks);
}
