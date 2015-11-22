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

    long someTimeInAYear();

    long midnightThisWeekOn(WeekDay weekDay);

    long midnightThisMonthOnThe(int date);

    long midnightThisYearOnDay(int day);

    long minusDays(long time, int days);

    long addDays(long time, int days);

    long minusWeeks(long time, int weeks);

    long addWeeks(long time, int weeks);

    long minusMonths(long time, int months);

    long addMonths(long time, int months);

    long minusYears(long time, int years);

    long addYears(long time, int years);
}
