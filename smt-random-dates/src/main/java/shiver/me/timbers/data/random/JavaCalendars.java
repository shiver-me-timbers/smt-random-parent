package shiver.me.timbers.data.random;

import java.util.GregorianCalendar;

import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MILLISECOND;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;

/**
 * @author Karl Bennett
 */
class JavaCalendars implements Calendars {

    @Override
    public Calendar midnightToday() {
        java.util.Calendar midnight = new GregorianCalendar();
        midnight.set(HOUR_OF_DAY, 0);
        midnight.set(MINUTE, 0);
        midnight.set(SECOND, 0);
        midnight.set(MILLISECOND, 0);

        return new JavaCalendar(midnight);
    }
}