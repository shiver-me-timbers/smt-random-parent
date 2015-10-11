package shiver.me.timbers.data.random;

import java.util.Date;

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
    public Date lastWeekOn(WeekDay weekDay) {
        return on(weekDay).minusWeeks(1).toDate();
    }

    @Override
    public Date thisWeekOn(WeekDay weekDay) {
        return on(weekDay).toDate();
    }

    @Override
    public Date nextWeekOn(WeekDay weekDay) {
        return on(weekDay).plusWeeks(1).toDate();
    }

    public Calendar on(WeekDay weekDay) {
        return calendars.midnightToday().withDayOfWeek(weekDay);
    }
}
