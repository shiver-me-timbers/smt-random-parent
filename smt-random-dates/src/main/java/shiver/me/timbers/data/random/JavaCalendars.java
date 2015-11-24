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
    public Calendar create(Long time) {
        java.util.Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(time);

        return new JavaCalendar(calendar);
    }

    @Override
    public Calendar now() {
        return new JavaCalendar(new GregorianCalendar());
    }

    @Override
    public Calendar startOfThisHour() {
        return new JavaCalendar(startOfThisHour(new GregorianCalendar()));
    }

    @Override
    public Calendar midnightToday() {
        java.util.Calendar midnight = startOfThisHour(new GregorianCalendar());
        midnight.set(HOUR_OF_DAY, 0);

        return new JavaCalendar(midnight);
    }

    private java.util.Calendar startOfThisHour(java.util.Calendar calendar) {
        calendar.set(MINUTE, 0);
        calendar.set(SECOND, 0);
        calendar.set(MILLISECOND, 0);

        return calendar;
    }
}
