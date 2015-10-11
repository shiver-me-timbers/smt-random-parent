package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
class JavaCalendar implements Calendar {

    private final java.util.Calendar calendar;

    public JavaCalendar(java.util.Calendar calendar) {
        this.calendar = calendar;
        calendar.setFirstDayOfWeek(java.util.Calendar.MONDAY);
    }

    @Override
    public Calendar minusDays(int days) {
        calendar.add(java.util.Calendar.DAY_OF_MONTH, -days);
        return this;
    }

    @Override
    public Calendar plusDays(int days) {
        calendar.add(java.util.Calendar.DAY_OF_MONTH, days);
        return this;
    }

    @Override
    public Calendar withDayOfWeek(DayOfWeek dayOfWeek) {
        calendar.set(java.util.Calendar.DAY_OF_WEEK, dayOfWeek.ordinal() + 1);
        return this;
    }

    @Override
    public Calendar minusWeeks(int weeks) {
        calendar.add(java.util.Calendar.WEEK_OF_YEAR, -weeks);
        return this;
    }

    @Override
    public Calendar plusWeeks(int weeks) {
        calendar.add(java.util.Calendar.WEEK_OF_YEAR, weeks);
        return this;
    }

    @Override
    public Date toDate() {
        return calendar.getTime();
    }
}
