package shiver.me.timbers.data.random;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.DAY_OF_YEAR;
import static java.util.Calendar.FRIDAY;
import static java.util.Calendar.MONDAY;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.SATURDAY;
import static java.util.Calendar.SUNDAY;
import static java.util.Calendar.THURSDAY;
import static java.util.Calendar.TUESDAY;
import static java.util.Calendar.WEDNESDAY;
import static java.util.Calendar.WEEK_OF_YEAR;
import static java.util.Calendar.YEAR;

/**
 * @author Karl Bennett
 */
class JavaCalendar implements Calendar {

    private static final Map<WeekDay, Integer> WEEK_DAY_MAP = new ConcurrentHashMap<WeekDay, Integer>() {{
        put(WeekDay.MONDAY, MONDAY);
        put(WeekDay.TUESDAY, TUESDAY);
        put(WeekDay.WEDNESDAY, WEDNESDAY);
        put(WeekDay.THURSDAY, THURSDAY);
        put(WeekDay.FRIDAY, FRIDAY);
        put(WeekDay.SATURDAY, SATURDAY);
        put(WeekDay.SUNDAY, SUNDAY);
    }};

    private final java.util.Calendar calendar;

    public JavaCalendar(java.util.Calendar calendar) {
        this.calendar = calendar;
        // The week should start with Monday: https://www.cl.cam.ac.uk/~mgk25/iso-time.html
        calendar.setFirstDayOfWeek(MONDAY);
    }

    @Override
    public Calendar minusDays(int days) {
        return addDays(-days);
    }

    @Override
    public Calendar addDays(int days) {
        calendar.add(DAY_OF_MONTH, days);
        return this;
    }

    @Override
    public Calendar withDayOfWeek(WeekDay weekDay) {
        calendar.set(DAY_OF_WEEK, WEEK_DAY_MAP.get(weekDay));
        return this;
    }

    @Override
    public Calendar minusWeeks(int weeks) {
        return addWeeks(-weeks);
    }

    @Override
    public Calendar addWeeks(int weeks) {
        calendar.add(WEEK_OF_YEAR, weeks);
        return this;
    }

    @Override
    public Calendar withDateOfMonth(int date) {
        calendar.set(DAY_OF_MONTH, date);
        return this;
    }

    @Override
    public Calendar minusMonths(int months) {
        return addMonths(-months);
    }

    @Override
    public Calendar addMonths(int months) {
        calendar.add(MONTH, months);
        return this;
    }

    @Override
    public Calendar withDayOfYear(int day) {
        calendar.set(DAY_OF_YEAR, day);
        return this;
    }

    @Override
    public Calendar minusYears(int years) {
        return addYears(-years);
    }

    @Override
    public Calendar addYears(int years) {
        calendar.add(YEAR, years);
        return this;
    }

    @Override
    public int daysInMonth() {
        return calendar.getActualMaximum(DAY_OF_MONTH);
    }

    @Override
    public int daysInYear() {
        return calendar.getActualMaximum(DAY_OF_YEAR);
    }

    @Override
    public long toTime() {
        return calendar.getTimeInMillis();
    }
}
