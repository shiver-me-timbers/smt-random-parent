package shiver.me.timbers.data.random;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.DayOfWeek.MONDAY;

public class CalendarDaysTest {

    private CalendarDays days;
    private Calendars calendars;

    @Before
    public void setUp() {
        calendars = mock(Calendars.class);
        days = new CalendarDays(calendars);
    }

    @Test
    public void Can_get_a_date_for_yesterday() {

        final Calendar calendar = mock(Calendar.class);
        final Calendar yesterdayCalendar = mock(Calendar.class);

        final Date expected = mock(Date.class);

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.minusDays(1)).willReturn(yesterdayCalendar);
        given(yesterdayCalendar.toDate()).willReturn(expected);

        // When
        final Date actual = days.yesterday();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_get_a_date_for_today() {

        final Calendar calendar = mock(Calendar.class);

        final Date expected = mock(Date.class);

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.toDate()).willReturn(expected);

        // When
        final Date actual = days.today();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_get_a_date_for_tomorrow() {

        final Calendar calendar = mock(Calendar.class);
        final Calendar tomorrowCalendar = mock(Calendar.class);

        final Date expected = mock(Date.class);

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.plusDays(1)).willReturn(tomorrowCalendar);
        given(tomorrowCalendar.toDate()).willReturn(expected);

        // When
        final Date actual = days.tomorrow();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_get_a_date_for_monday_last_week() {

        final Calendar calendar = mock(Calendar.class);
        final Calendar mondayCalendar = mock(Calendar.class);
        final Calendar lastWeekCalendar = mock(Calendar.class);

        final Date expected = mock(Date.class);

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.withDayOfWeek(MONDAY)).willReturn(mondayCalendar);
        given(mondayCalendar.minusWeeks(1)).willReturn(lastWeekCalendar);
        given(lastWeekCalendar.toDate()).willReturn(expected);

        // When
        final Date actual = days.mondayLastWeek();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_get_a_date_for_monday_this_week() {

        final Calendar calendar = mock(Calendar.class);
        final Calendar mondayCalendar = mock(Calendar.class);

        final Date expected = mock(Date.class);

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.withDayOfWeek(MONDAY)).willReturn(mondayCalendar);
        given(mondayCalendar.toDate()).willReturn(expected);

        // When
        final Date actual = days.mondayThisWeek();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_get_a_date_for_monday_next_week() {

        final Calendar calendar = mock(Calendar.class);
        final Calendar mondayCalendar = mock(Calendar.class);
        final Calendar nextWeekCalendar = mock(Calendar.class);

        final Date expected = mock(Date.class);

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.withDayOfWeek(MONDAY)).willReturn(mondayCalendar);
        given(mondayCalendar.plusWeeks(1)).willReturn(nextWeekCalendar);
        given(nextWeekCalendar.toDate()).willReturn(expected);

        // When
        final Date actual = days.mondayNextWeek();

        // Then
        assertThat(actual, is(expected));
    }
}