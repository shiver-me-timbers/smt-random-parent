package shiver.me.timbers.data.random;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.DAY_OF_YEAR;
import static java.util.Calendar.FRIDAY;
import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MONDAY;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.SATURDAY;
import static java.util.Calendar.SUNDAY;
import static java.util.Calendar.THURSDAY;
import static java.util.Calendar.TUESDAY;
import static java.util.Calendar.WEDNESDAY;
import static java.util.Calendar.WEEK_OF_YEAR;
import static java.util.Calendar.YEAR;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static shiver.me.timbers.data.random.RandomEnums.someEnum;
import static shiver.me.timbers.data.random.RandomIntegers.someInteger;
import static shiver.me.timbers.data.random.RandomIntegers.somePositiveInteger;
import static shiver.me.timbers.data.random.RandomLongs.someLong;

/**
 * @author Karl Bennett
 */
public class JavaCalendarTest {

    private java.util.Calendar calendar;
    private Calendar javaCalendar;

    @Before
    public void setUp() {
        calendar = mock(java.util.Calendar.class);
        javaCalendar = new JavaCalendar(calendar);
    }

    @Test
    public void Monday_is_always_the_first_day_of_the_week() {
        verify(calendar).setFirstDayOfWeek(MONDAY);
    }

    @Test
    public void Can_minus_hours() {

        // Given
        final int hours = somePositiveInteger();

        // When
        final Calendar actual = javaCalendar.minusHours(hours);

        // Then
        verify(calendar).add(HOUR_OF_DAY, -hours);
        assertThat(actual, is(javaCalendar));
    }

    @Test
    public void Can_add_hours() {

        // Given
        final int hours = somePositiveInteger();

        // When
        final Calendar actual = javaCalendar.addHours(hours);

        // Then
        verify(calendar).add(HOUR_OF_DAY, hours);
        assertThat(actual, is(javaCalendar));
    }

    @Test
    public void Can_minus_days() {

        // Given
        final int days = somePositiveInteger();

        // When
        final Calendar actual = javaCalendar.minusDays(days);

        // Then
        verify(calendar).add(DAY_OF_MONTH, -days);
        assertThat(actual, is(javaCalendar));
    }

    @Test
    public void Can_add_days() {

        // Given
        final int days = somePositiveInteger();

        // When
        final Calendar actual = javaCalendar.addDays(days);

        // Then
        verify(calendar).add(DAY_OF_MONTH, days);
        assertThat(actual, is(javaCalendar));
    }

    @Test
    public void Can_set_the_day_of_the_week() {

        // Given
        final WeekDay weekDay = someEnum(WeekDay.class);
        final Map<WeekDay, Integer> weekDayMap = new HashMap<WeekDay, Integer>() {{
            put(WeekDay.MONDAY, MONDAY);
            put(WeekDay.TUESDAY, TUESDAY);
            put(WeekDay.WEDNESDAY, WEDNESDAY);
            put(WeekDay.THURSDAY, THURSDAY);
            put(WeekDay.FRIDAY, FRIDAY);
            put(WeekDay.SATURDAY, SATURDAY);
            put(WeekDay.SUNDAY, SUNDAY);
        }};

        // When
        final Calendar actual = javaCalendar.withDayOfWeek(weekDay);

        // Then
        verify(calendar).set(DAY_OF_WEEK, weekDayMap.get(weekDay));
        assertThat(actual, is(javaCalendar));
    }

    @Test
    public void Can_minus_weeks() {

        // Given
        final int weeks = somePositiveInteger();

        // When
        final Calendar actual = javaCalendar.minusWeeks(weeks);

        // Then
        verify(calendar).add(WEEK_OF_YEAR, -weeks);
        assertThat(actual, is(javaCalendar));
    }

    @Test
    public void Can_add_weeks() {

        // Given
        final int weeks = somePositiveInteger();

        // When
        final Calendar actual = javaCalendar.addWeeks(weeks);

        // Then
        verify(calendar).add(WEEK_OF_YEAR, weeks);
        assertThat(actual, is(javaCalendar));
    }

    @Test
    public void Can_set_the_date_of_the_month() {

        // Given
        final int date = someInteger();

        // When
        final Calendar actual = javaCalendar.withDateOfMonth(date);

        // Then
        verify(calendar).set(DAY_OF_MONTH, date);
        assertThat(actual, is(javaCalendar));
    }

    @Test
    public void Can_set_the_day_of_the_year() {

        // Given
        final int day = someInteger();

        // When
        final Calendar actual = javaCalendar.withDayOfYear(day);

        // Then
        verify(calendar).set(DAY_OF_YEAR, day);
        assertThat(actual, is(javaCalendar));
    }

    @Test
    public void Can_minus_months() {

        // Given
        final int months = somePositiveInteger();

        // When
        final Calendar actual = javaCalendar.minusMonths(months);

        // Then
        verify(calendar).add(MONTH, -months);
        assertThat(actual, is(javaCalendar));
    }

    @Test
    public void Can_add_months() {

        // Given
        final int months = somePositiveInteger();

        // When
        final Calendar actual = javaCalendar.addMonths(months);

        // Then
        verify(calendar).add(MONTH, months);
        assertThat(actual, is(javaCalendar));
    }

    @Test
    public void Can_minus_years() {

        // Given
        final int years = somePositiveInteger();

        // When
        final Calendar actual = javaCalendar.minusYears(years);

        // Then
        verify(calendar).add(YEAR, -years);
        assertThat(actual, is(javaCalendar));
    }

    @Test
    public void Can_add_years() {

        // Given
        final int years = somePositiveInteger();

        // When
        final Calendar actual = javaCalendar.addYears(years);

        // Then
        verify(calendar).add(YEAR, years);
        assertThat(actual, is(javaCalendar));
    }

    @Test
    public void Can_get_the_number_of_days_in_the_current_month() {

        final Integer expected = someInteger();

        // Given
        given(calendar.getActualMaximum(DAY_OF_MONTH)).willReturn(expected);

        // When
        final int actual = javaCalendar.daysInMonth();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_get_the_number_of_days_in_the_current_year() {

        final Integer expected = someInteger();

        // Given
        given(calendar.getActualMaximum(DAY_OF_YEAR)).willReturn(expected);

        // When
        final int actual = javaCalendar.daysInYear();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_convert_the_calendar_into_time() {

        final Long expected = someLong();

        // Given
        given(calendar.getTimeInMillis()).willReturn(expected);

        // When
        final long actual = javaCalendar.getTime();

        // Then
        assertThat(actual, is(expected));
    }
}