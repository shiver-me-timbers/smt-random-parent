package shiver.me.timbers.data.random;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Karl Bennett
 */
class JavaCalendar implements Calendar {

    private static final Map<WeekDay, Integer> WEEK_DAY_MAP = new ConcurrentHashMap<WeekDay, Integer>() {{
        put(WeekDay.MONDAY, java.util.Calendar.MONDAY);
        put(WeekDay.TUESDAY, java.util.Calendar.TUESDAY);
        put(WeekDay.WEDNESDAY, java.util.Calendar.WEDNESDAY);
        put(WeekDay.THURSDAY, java.util.Calendar.THURSDAY);
        put(WeekDay.FRIDAY, java.util.Calendar.FRIDAY);
        put(WeekDay.SATURDAY, java.util.Calendar.SATURDAY);
        put(WeekDay.SUNDAY, java.util.Calendar.SUNDAY);
    }};

    private final java.util.Calendar calendar;

    public JavaCalendar(java.util.Calendar calendar) {
        this.calendar = calendar;
        // The week should start with Monday: https://www.cl.cam.ac.uk/~mgk25/iso-time.html
        calendar.setFirstDayOfWeek(java.util.Calendar.MONDAY);
    }

    @Override
    public Calendar minusDays(int days) {
        calendar.add(java.util.Calendar.DAY_OF_MONTH, -days);
        return this;
    }

    @Override
    public Calendar addDays(int days) {
        calendar.add(java.util.Calendar.DAY_OF_MONTH, days);
        return this;
    }

    @Override
    public Calendar withDayOfWeek(WeekDay weekDay) {
        calendar.set(java.util.Calendar.DAY_OF_WEEK, WEEK_DAY_MAP.get(weekDay));
        return this;
    }

    @Override
    public Calendar minusWeeks(int weeks) {
        calendar.add(java.util.Calendar.WEEK_OF_YEAR, -weeks);
        return this;
    }

    @Override
    public Calendar addWeeks(int weeks) {
        calendar.add(java.util.Calendar.WEEK_OF_YEAR, weeks);
        return this;
    }

    @Override
    public long toTime() {
        return calendar.getTimeInMillis();
    }
}
