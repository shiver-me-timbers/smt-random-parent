package shiver.me.timbers.data.random;

/**
 * @author Karl Bennett
 */
interface TimeStamps {

    long now();

    long todayMidnight();

    long someTimeInADay();

    long someTimeInAWeek();

    long someTimeInAMonth();

    long midnightThisWeekOn(WeekDay weekDay);

    long midnightThisMonthOnThe(int date);

    long minusDays(long time, int days);

    long addDays(long time, int days);

    long minusWeeks(long time, int weeks);

    long addWeeks(long time, int weeks);

    long minusMonths(long time, int months);

    long addMonths(long time, int months);
}
