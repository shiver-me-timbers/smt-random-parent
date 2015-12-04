package shiver.me.timbers.data.random;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomIntegers.someInteger;
import static shiver.me.timbers.data.random.RandomLongs.someLong;

public class RandomTimeBuilderTest {

    private Calendars calendars;
    private RandomDurations randomDurations;
    private Numbers<Long> longs;
    private Long initialTime;

    private RandomTimeBuilder builder;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        calendars = mock(Calendars.class);
        randomDurations = mock(RandomDurations.class);
        longs = mock(Numbers.class);
        initialTime = someLong();

        builder = new RandomTimeBuilder(calendars, longs, initialTime);
    }

    @Test
    public void Can_set_the_random_time_builders_time_to_a_random_time_in_the_past() {

        final long randomLong = someLong();

        final long expected = initialTime + (randomLong - 1);

        // Given
        given(longs.someNegativeNumber()).willReturn(randomLong);

        // When
        final RandomTimeBuilder actual = builder.inThePast();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_set_the_random_time_builders_time_to_a_random_time_in_the_future() {

        final long randomLong = someLong();

        final long expected = initialTime + (randomLong + 1);

        // Given
        given(longs.somePositiveNumber()).willReturn(randomLong);

        // When
        final RandomTimeBuilder actual = builder.inTheFuture();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_minus_some_minutes_off_the_random_time_builders_time() {

        final int minutes = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar minusMinutesCalendar = mock(Calendar.class);

        final long expected = someLong();

        // Given
        given(calendars.create(initialTime)).willReturn(calendar);
        given(calendar.minusMinutes(minutes)).willReturn(minusMinutesCalendar);
        given(minusMinutesCalendar.getTime()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.minusMinutes(minutes);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_add_some_minutes_off_the_random_time_builders_time() {

        final int minutes = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar addMinutesCalendar = mock(Calendar.class);

        final long expected = someLong();

        // Given
        given(calendars.create(initialTime)).willReturn(calendar);
        given(calendar.addMinutes(minutes)).willReturn(addMinutesCalendar);
        given(addMinutesCalendar.getTime()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.addMinutes(minutes);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_minus_some_hours_off_the_random_time_builders_time() {

        final int hours = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar minusHoursCalendar = mock(Calendar.class);

        final long expected = someLong();

        // Given
        given(calendars.create(initialTime)).willReturn(calendar);
        given(calendar.minusHours(hours)).willReturn(minusHoursCalendar);
        given(minusHoursCalendar.getTime()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.minusHours(hours);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_add_some_hours_off_the_random_time_builders_time() {

        final int hours = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar addHoursCalendar = mock(Calendar.class);

        final long expected = someLong();

        // Given
        given(calendars.create(initialTime)).willReturn(calendar);
        given(calendar.addHours(hours)).willReturn(addHoursCalendar);
        given(addHoursCalendar.getTime()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.addHours(hours);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_minus_some_days_off_the_random_time_builders_time() {

        final int days = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar minusDaysCalendar = mock(Calendar.class);

        final long expected = someLong();

        // Given
        given(calendars.create(initialTime)).willReturn(calendar);
        given(calendar.minusDays(days)).willReturn(minusDaysCalendar);
        given(minusDaysCalendar.getTime()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.minusDays(days);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_add_some_days_off_the_random_time_builders_time() {

        final int days = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar addDaysCalendar = mock(Calendar.class);

        final long expected = someLong();

        // Given
        given(calendars.create(initialTime)).willReturn(calendar);
        given(calendar.addDays(days)).willReturn(addDaysCalendar);
        given(addDaysCalendar.getTime()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.addDays(days);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_minus_some_weeks_off_the_random_time_builders_time() {

        final int weeks = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar minusWeeksCalendar = mock(Calendar.class);

        final long expected = someLong();

        // Given
        given(calendars.create(initialTime)).willReturn(calendar);
        given(calendar.minusWeeks(weeks)).willReturn(minusWeeksCalendar);
        given(minusWeeksCalendar.getTime()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.minusWeeks(weeks);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_add_some_weeks_to_the_random_time_builders_time() {

        final int weeks = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar addWeeksCalendar = mock(Calendar.class);

        final long expected = someLong();

        // Given
        given(calendars.create(initialTime)).willReturn(calendar);
        given(calendar.addWeeks(weeks)).willReturn(addWeeksCalendar);
        given(addWeeksCalendar.getTime()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.addWeeks(weeks);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_minus_some_months_off_the_random_time_builders_time() {

        final int months = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar minusMonthsCalendar = mock(Calendar.class);

        final long expected = someLong();

        // Given
        given(calendars.create(initialTime)).willReturn(calendar);
        given(calendar.minusMonths(months)).willReturn(minusMonthsCalendar);
        given(minusMonthsCalendar.getTime()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.minusMonths(months);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_add_some_months_to_the_random_time_builders_time() {

        final int months = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar addMonthsCalendar = mock(Calendar.class);

        final long expected = someLong();

        // Given
        given(calendars.create(initialTime)).willReturn(calendar);
        given(calendar.addMonths(months)).willReturn(addMonthsCalendar);
        given(addMonthsCalendar.getTime()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.addMonths(months);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_minus_some_years_off_the_random_time_builders_time() {

        final int years = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar minusYearsCalendar = mock(Calendar.class);

        final long expected = someLong();

        // Given
        given(calendars.create(initialTime)).willReturn(calendar);
        given(calendar.minusYears(years)).willReturn(minusYearsCalendar);
        given(minusYearsCalendar.getTime()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.minusYears(years);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_add_some_years_to_the_random_time_builders_time() {

        final int years = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar addYearsCalendar = mock(Calendar.class);

        final long expected = someLong();

        // Given
        given(calendars.create(initialTime)).willReturn(calendar);
        given(calendar.addYears(years)).willReturn(addYearsCalendar);
        given(addYearsCalendar.getTime()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.addYears(years);

        // Then
        assertThat(actual.getTime(), is(expected));
    }
}