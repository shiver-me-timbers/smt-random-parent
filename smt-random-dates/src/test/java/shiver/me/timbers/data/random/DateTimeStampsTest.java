package shiver.me.timbers.data.random;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomEnums.someEnum;
import static shiver.me.timbers.data.random.RandomIntegers.someInteger;
import static shiver.me.timbers.data.random.RandomLongs.someLong;
import static shiver.me.timbers.data.random.test.DateMatchers.isOn;

/**
 * @author Karl Bennett
 */
public class DateTimeStampsTest {

    private static final int MILLISECONDS_IN_ONE_DAY = 86400000;
    private static final int MILLISECONDS_IN_ONE_WEEK = 604800000;

    private Random random;
    private Calendars calendars;

    private DateTimeStamps timeStamps;

    @Before
    public void setUp() {
        random = mock(Random.class);
        calendars = mock(Calendars.class);

        timeStamps = new DateTimeStamps(random, calendars);
    }

    @Test
    public void Can_get_the_time_for_now() {

        // When
        final Date actual = new Date(timeStamps.now());

        // Then
        assertThat(actual, isOn(new Date()).within(100, MILLISECONDS));
    }

    @Test
    public void Can_generate_some_random_time_stamp_that_falls_within_a_day() {

        final long expected = someInteger();

        // Given
        given(random.nextInt(MILLISECONDS_IN_ONE_DAY)).willReturn((int) expected);

        // When
        final long actual = timeStamps.someTimeInADay();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_get_the_time_for_today_at_midnight() {

        final Calendar calendar = mock(Calendar.class);

        final Long expected = someLong();

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.toTime()).willReturn(expected);

        // When
        final long actual = timeStamps.todayMidnight();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_minus_a_day_from_the_current_time() {

        final Long time = someLong();
        final Integer days = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar minusDaysCalendar = mock(Calendar.class);

        final Long expected = someLong();

        // Given
        given(calendars.create(time)).willReturn(calendar);
        given(calendar.minusDays(days)).willReturn(minusDaysCalendar);
        given(minusDaysCalendar.toTime()).willReturn(expected);

        // When
        final long actual = timeStamps.minusDays(time, days);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_add_a_day_to_the_current_time() {

        final Long time = someLong();
        final Integer days = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar minusDaysCalendar = mock(Calendar.class);

        final Long expected = someLong();

        // Given
        given(calendars.create(time)).willReturn(calendar);
        given(calendar.addDays(days)).willReturn(minusDaysCalendar);
        given(minusDaysCalendar.toTime()).willReturn(expected);

        // When
        final long actual = timeStamps.addDays(time, days);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_minus_a_week_from_the_current_time() {

        final Long time = someLong();
        final Integer weeks = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar minusWeeksCalendar = mock(Calendar.class);

        final Long expected = someLong();

        // Given
        given(calendars.create(time)).willReturn(calendar);
        given(calendar.minusWeeks(weeks)).willReturn(minusWeeksCalendar);
        given(minusWeeksCalendar.toTime()).willReturn(expected);

        // When
        final long actual = timeStamps.minusWeeks(time, weeks);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_add_a_week_to_the_current_time() {

        final Long time = someLong();
        final Integer weeks = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar addWeeksCalendar = mock(Calendar.class);

        final Long expected = someLong();

        // Given
        given(calendars.create(time)).willReturn(calendar);
        given(calendar.addWeeks(weeks)).willReturn(addWeeksCalendar);
        given(addWeeksCalendar.toTime()).willReturn(expected);

        // When
        final long actual = timeStamps.addWeeks(time, weeks);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_some_random_time_stamp_that_falls_within_a_week() {

        final long expected = someInteger();

        // Given
        given(random.nextInt(MILLISECONDS_IN_ONE_WEEK)).willReturn((int) expected);

        // When
        final long actual = timeStamps.someTimeInAWeek();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_get_the_time_for_a_specific_day_this_week_at_midnight() {

        final WeekDay weekDay = someEnum(WeekDay.class);

        final Calendar calendar = mock(Calendar.class);
        final Calendar dayOfWeekCalendar = mock(Calendar.class);

        final Long expected = someLong();

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.withDayOfWeek(weekDay)).willReturn(dayOfWeekCalendar);
        given(dayOfWeekCalendar.toTime()).willReturn(expected);

        // When
        final long actual = timeStamps.midnightThisWeekOn(weekDay);

        // Then
        assertThat(actual, equalTo(expected));
    }
}
