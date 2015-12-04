package shiver.me.timbers.data.random;

/**
 * @author Karl Bennett
 */
interface Calendars {

    Calendar create(Long time);

    Calendar now();

    Calendar startOfThisSecond();

    Calendar startOfThisMinute();

    Calendar startOfThisHour();

    Calendar midnightToday();
}
