package shiver.me.timbers.data.random;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static shiver.me.timbers.data.random.RandomEnums.someEnum;
import static shiver.me.timbers.data.random.RandomIntegers.somePositiveInteger;
import static shiver.me.timbers.data.random.test.DateMatchers.isOn;

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
        verify(calendar).setFirstDayOfWeek(java.util.Calendar.MONDAY);
    }

    @Test
    public void Can_minus_days() {

        // Given
        final Integer days = somePositiveInteger();

        // When
        final Calendar actual = javaCalendar.minusDays(days);

        // Then
        verify(calendar).add(java.util.Calendar.DAY_OF_MONTH, -days);
        assertThat(actual, is(javaCalendar));
    }

    @Test
    public void Can_add_days() {

        // Given
        final Integer days = somePositiveInteger();

        // When
        final Calendar actual = javaCalendar.plusDays(days);

        // Then
        verify(calendar).add(java.util.Calendar.DAY_OF_MONTH, days);
        assertThat(actual, is(javaCalendar));
    }

    @Test
    public void Can_set_the_day_of_the_week() {

        // Given
        final WeekDay weekDay = someEnum(WeekDay.class);
        final Map<WeekDay, Integer> weekDayMap = new HashMap<WeekDay, Integer>() {{
            put(WeekDay.MONDAY, java.util.Calendar.MONDAY);
            put(WeekDay.TUESDAY, java.util.Calendar.TUESDAY);
            put(WeekDay.WEDNESDAY, java.util.Calendar.WEDNESDAY);
            put(WeekDay.THURSDAY, java.util.Calendar.THURSDAY);
            put(WeekDay.FRIDAY, java.util.Calendar.FRIDAY);
            put(WeekDay.SATURDAY, java.util.Calendar.SATURDAY);
            put(WeekDay.SUNDAY, java.util.Calendar.SUNDAY);
        }};

        // When
        final Calendar actual = javaCalendar.withDayOfWeek(weekDay);

        // Then
        verify(calendar).set(java.util.Calendar.DAY_OF_WEEK, weekDayMap.get(weekDay));
        assertThat(actual, is(javaCalendar));
    }

    @Test
    public void Can_minus_weeks() {

        // Given
        final Integer weeks = somePositiveInteger();

        // When
        final Calendar actual = javaCalendar.minusWeeks(weeks);

        // Then
        verify(calendar).add(java.util.Calendar.WEEK_OF_YEAR, -weeks);
        assertThat(actual, is(javaCalendar));
    }

    @Test
    public void Can_add_weeks() {

        // Given
        final Integer weeks = somePositiveInteger();

        // When
        final Calendar actual = javaCalendar.plusWeeks(weeks);

        // Then
        verify(calendar).add(java.util.Calendar.WEEK_OF_YEAR, weeks);
        assertThat(actual, is(javaCalendar));
    }

    @Test
    public void Can_convert_the_calendar_into_a_date() {

        // When
        final Date actual = javaCalendar.toDate();

        // Then
        assertThat(actual, isOn(calendar.getTime()).within(1, SECONDS));
    }
}