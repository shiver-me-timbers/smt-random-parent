package shiver.me.timbers.data.random;

/**
 * @author Karl Bennett
 */
interface Calendars {

    Calendar create(Long time);

    Calendar now();

    Calendar midnightToday();

    int daysThisMonth();

    int daysThisYear();
}
