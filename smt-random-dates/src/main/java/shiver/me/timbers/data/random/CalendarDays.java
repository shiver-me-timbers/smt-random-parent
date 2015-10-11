package shiver.me.timbers.data.random;

import java.util.Date;

import static shiver.me.timbers.data.random.WeekDay.MONDAY;

/**
 * @author Karl Bennett
 */
class CalendarDays implements Days {

    private final Calendars calendars;

    public CalendarDays(Calendars calendars) {
        this.calendars = calendars;
    }

    @Override
    public Date yesterday() {
        return calendars.midnightToday().minusDays(1).toDate();
    }

    @Override
    public Date today() {
        return calendars.midnightToday().toDate();
    }

    @Override
    public Date tomorrow() {
        return calendars.midnightToday().plusDays(1).toDate();
    }

    @Override
    public Date mondayLastWeek() {
        return monday().minusWeeks(1).toDate();
    }

    @Override
    public Date mondayThisWeek() {
        return monday().toDate();
    }

    @Override
    public Date mondayNextWeek() {
        return monday().plusWeeks(1).toDate();
    }

    public Calendar monday() {
        return calendars.midnightToday().withDayOfWeek(MONDAY);
    }

//    private Calendar midnight() {
//
//        Calendar midnight = new GregorianCalendar();
//        midnight.set(Calendar.HOUR_OF_DAY, 0);
//        midnight.set(Calendar.MINUTE, 0);
//        midnight.set(Calendar.SECOND, 0);
//        midnight.set(Calendar.MILLISECOND, 0);
//
//        return midnight;
//    }
}
