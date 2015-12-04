package shiver.me.timbers.data.random;

/**
 * @author Karl Bennett
 */
interface Calendars {

    Calendar create(Long time);

    Calendar now();

    Calendar startOfThisMinute();

    Calendar startOfThisHour();

    Calendar midnightToday();
}
