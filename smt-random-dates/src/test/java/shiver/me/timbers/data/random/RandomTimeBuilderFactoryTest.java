package shiver.me.timbers.data.random;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomEnums.someEnum;
import static shiver.me.timbers.data.random.RandomIntegers.someInteger;
import static shiver.me.timbers.data.random.RandomLongs.someLong;
import static shiver.me.timbers.data.random.WeekDay.MONDAY;

public class RandomTimeBuilderFactoryTest {

    private Calendars calendars;
    private RandomDurations randomDurations;
    private Numbers<Long> longs;
    private RandomTimeBuilderFactory creator;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        calendars = mock(Calendars.class);
        randomDurations = mock(RandomDurations.class);
        longs = mock(Numbers.class);
        creator = new RandomTimeBuilderFactory(calendars, randomDurations, longs);
    }

    @Test
    public void Can_create_a_random_date_builder() {

        final Date date = mock(Date.class);

        final Long expected = someLong();

        // Given
        given(date.getTime()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = creator.create(date);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_now() {

        final Calendar calendar = mock(Calendar.class);

        final Long expected = someLong();

        // Given
        given(calendars.now()).willReturn(calendar);
        given(calendar.getTime()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = creator.now();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_between_two_dates() {

        final Date min = mock(Date.class);
        final Date max = mock(Date.class);
        final long minTime = someLong();
        final long maxTime = someLong();

        final Long expected = someLong();

        // Given
        given(min.getTime()).willReturn(minTime);
        given(max.getTime()).willReturn(maxTime);
        given(longs.someNumberBetween(minTime, maxTime)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = creator.between(min, max);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_this_hour() {

        final Calendar calendar = mock(Calendar.class);
        final long midnightToday = someLong();
        final long timeInADay = someLong();

        final Long expected = midnightToday + timeInADay;

        // Given
        given(calendars.startOfThisHour()).willReturn(calendar);
        given(calendar.getTime()).willReturn(midnightToday);
        given(randomDurations.someTimeInAnHour()).willReturn(timeInADay);

        // When
        final RandomTimeBuilder actual = creator.thisHour();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_today() {

        final Calendar calendar = mock(Calendar.class);
        final long midnightToday = someLong();
        final long timeInADay = someLong();

        final Long expected = midnightToday + timeInADay;

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.getTime()).willReturn(midnightToday);
        given(randomDurations.someTimeInADay()).willReturn(timeInADay);

        // When
        final RandomTimeBuilder actual = creator.today();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_this_week() {

        final Calendar calendar = mock(Calendar.class);
        final Calendar mondayCalendar = mock(Calendar.class);
        final long midnightMondayThisWeek = someLong();
        final long timeInAWeek = someLong();

        final Long expected = midnightMondayThisWeek + timeInAWeek;

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.withDayOfWeek(MONDAY)).willReturn(mondayCalendar);
        given(mondayCalendar.getTime()).willReturn(midnightMondayThisWeek);
        given(randomDurations.someTimeInAWeek()).willReturn(timeInAWeek);

        // When
        final RandomTimeBuilder actual = creator.thisWeek();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_in_a_specific_day_this_week() {

        final WeekDay weekDay = someEnum(WeekDay.class);

        final Calendar calendar = mock(Calendar.class);
        final Calendar dayOfWeekCalendar = mock(Calendar.class);
        final long midnightMondayThisWeek = someLong();
        final long timeInADay = someLong();

        final Long expected = midnightMondayThisWeek + timeInADay;

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.withDayOfWeek(weekDay)).willReturn(dayOfWeekCalendar);
        given(dayOfWeekCalendar.getTime()).willReturn(midnightMondayThisWeek);
        given(randomDurations.someTimeInADay()).willReturn(timeInADay);

        // When
        final RandomTimeBuilder actual = creator.thisWeekOn(weekDay);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_last_month() {

        final Calendar calendar = mock(Calendar.class);
        final Calendar lastMonthCalendar = mock(Calendar.class);
        final Calendar dateOfMonthCalendar = mock(Calendar.class);
        final long midnightLastMonthOnThe1st = someLong();
        final int daysInMonth = someInteger();
        final long timeInAMonth = someLong();

        final Long expected = midnightLastMonthOnThe1st + timeInAMonth;

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.minusMonths(1)).willReturn(lastMonthCalendar);
        given(lastMonthCalendar.withDateOfMonth(1)).willReturn(dateOfMonthCalendar);
        given(dateOfMonthCalendar.getTime()).willReturn(midnightLastMonthOnThe1st);
        given(lastMonthCalendar.daysInMonth()).willReturn(daysInMonth);
        given(randomDurations.someTimeInDays(daysInMonth)).willReturn(timeInAMonth);

        // When
        final RandomTimeBuilder actual = creator.lastMonth();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_this_month() {

        final Calendar calendar = mock(Calendar.class);
        final Calendar dateOfMonthCalendar = mock(Calendar.class);
        final long midnightThisMonthOnThe1st = someLong();
        final int daysInMonth = someInteger();
        final long timeInAMonth = someLong();

        final Long expected = midnightThisMonthOnThe1st + timeInAMonth;

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.withDateOfMonth(1)).willReturn(dateOfMonthCalendar);
        given(dateOfMonthCalendar.getTime()).willReturn(midnightThisMonthOnThe1st);
        given(calendar.daysInMonth()).willReturn(daysInMonth);
        given(randomDurations.someTimeInDays(daysInMonth)).willReturn(timeInAMonth);

        // When
        final RandomTimeBuilder actual = creator.thisMonth();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_next_month() {

        final Calendar calendar = mock(Calendar.class);
        final Calendar nextMonthCalendar = mock(Calendar.class);
        final Calendar dateOfMonthCalendar = mock(Calendar.class);
        final long midnightNextMonthOnThe1st = someLong();
        final int daysInMonth = someInteger();
        final long timeInAMonth = someLong();

        final Long expected = midnightNextMonthOnThe1st + timeInAMonth;

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.addMonths(1)).willReturn(nextMonthCalendar);
        given(nextMonthCalendar.withDateOfMonth(1)).willReturn(dateOfMonthCalendar);
        given(dateOfMonthCalendar.getTime()).willReturn(midnightNextMonthOnThe1st);
        given(nextMonthCalendar.daysInMonth()).willReturn(daysInMonth);
        given(randomDurations.someTimeInDays(daysInMonth)).willReturn(timeInAMonth);

        // When
        final RandomTimeBuilder actual = creator.nextMonth();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_in_a_specific_date_last_month() {

        final int date = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar lastMonthCalendar = mock(Calendar.class);
        final Calendar dateOfMonthCalendar = mock(Calendar.class);
        final long midnightLastMonthOnThe1st = someLong();
        final long timeInADay = someLong();

        final Long expected = midnightLastMonthOnThe1st + timeInADay;

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.minusMonths(1)).willReturn(lastMonthCalendar);
        given(lastMonthCalendar.withDateOfMonth(date)).willReturn(dateOfMonthCalendar);
        given(dateOfMonthCalendar.getTime()).willReturn(midnightLastMonthOnThe1st);
        given(randomDurations.someTimeInADay()).willReturn(timeInADay);

        // When
        final RandomTimeBuilder actual = creator.lastMonthOnThe(date);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_in_a_specific_date_this_month() {

        final int date = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar dateOfMonthCalendar = mock(Calendar.class);
        final long midnightThisMonthOnDate = someLong();
        final long timeInADay = someLong();

        final Long expected = midnightThisMonthOnDate + timeInADay;

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.withDateOfMonth(date)).willReturn(dateOfMonthCalendar);
        given(dateOfMonthCalendar.getTime()).willReturn(midnightThisMonthOnDate);
        given(randomDurations.someTimeInADay()).willReturn(timeInADay);

        // When
        final RandomTimeBuilder actual = creator.thisMonthOnThe(date);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_in_a_specific_date_next_month() {

        final int date = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar nextMonthCalendar = mock(Calendar.class);
        final Calendar dateOfMonthCalendar = mock(Calendar.class);
        final long midnightNextMonthOnThe1st = someLong();
        final long timeInADay = someLong();

        final Long expected = midnightNextMonthOnThe1st + timeInADay;

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.addMonths(1)).willReturn(nextMonthCalendar);
        given(nextMonthCalendar.withDateOfMonth(date)).willReturn(dateOfMonthCalendar);
        given(dateOfMonthCalendar.getTime()).willReturn(midnightNextMonthOnThe1st);
        given(randomDurations.someTimeInADay()).willReturn(timeInADay);

        // When
        final RandomTimeBuilder actual = creator.nextMonthOnThe(date);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_last_year() {

        final Calendar calendar = mock(Calendar.class);
        final Calendar lastYearCalendar = mock(Calendar.class);
        final Calendar dayOfYearCalendar = mock(Calendar.class);
        final long midnightLastYearOnDay1 = someLong();
        final int daysInYear = someInteger();
        final long timeInAYear = someLong();

        final Long expected = midnightLastYearOnDay1 + timeInAYear;

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.minusYears(1)).willReturn(lastYearCalendar);
        given(lastYearCalendar.withDayOfYear(1)).willReturn(dayOfYearCalendar);
        given(dayOfYearCalendar.getTime()).willReturn(midnightLastYearOnDay1);
        given(lastYearCalendar.daysInYear()).willReturn(daysInYear);
        given(randomDurations.someTimeInDays(daysInYear)).willReturn(timeInAYear);

        // When
        final RandomTimeBuilder actual = creator.lastYear();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_this_year() {

        final Calendar calendar = mock(Calendar.class);
        final Calendar dayOfYearCalendar = mock(Calendar.class);
        final long midnightThisYearOnDay1 = someLong();
        final int daysInYear = someInteger();
        final long timeInAYear = someLong();

        final Long expected = midnightThisYearOnDay1 + timeInAYear;

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.withDayOfYear(1)).willReturn(dayOfYearCalendar);
        given(dayOfYearCalendar.getTime()).willReturn(midnightThisYearOnDay1);
        given(calendar.daysInYear()).willReturn(daysInYear);
        given(randomDurations.someTimeInDays(daysInYear)).willReturn(timeInAYear);

        // When
        final RandomTimeBuilder actual = creator.thisYear();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_next_year() {

        final Calendar calendar = mock(Calendar.class);
        final Calendar nextYearCalendar = mock(Calendar.class);
        final Calendar dayOfYearCalendar = mock(Calendar.class);
        final long midnightNextYearOnDay1 = someLong();
        final int daysInYear = someInteger();
        final long timeInAYear = someLong();

        final Long expected = midnightNextYearOnDay1 + timeInAYear;

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.addYears(1)).willReturn(nextYearCalendar);
        given(nextYearCalendar.withDayOfYear(1)).willReturn(dayOfYearCalendar);
        given(dayOfYearCalendar.getTime()).willReturn(midnightNextYearOnDay1);
        given(nextYearCalendar.daysInYear()).willReturn(daysInYear);
        given(randomDurations.someTimeInDays(daysInYear)).willReturn(timeInAYear);

        // When
        final RandomTimeBuilder actual = creator.nextYear();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_in_a_specific_day_last_year() {

        final int day = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar lastYearCalendar = mock(Calendar.class);
        final Calendar dayOfYearCalendar = mock(Calendar.class);
        final long midnightLastYearOnASpecificDay = someLong();
        final long timeInADay = someLong();

        final Long expected = midnightLastYearOnASpecificDay + timeInADay;

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.minusYears(1)).willReturn(lastYearCalendar);
        given(lastYearCalendar.withDayOfYear(day)).willReturn(dayOfYearCalendar);
        given(dayOfYearCalendar.getTime()).willReturn(midnightLastYearOnASpecificDay);
        given(randomDurations.someTimeInADay()).willReturn(timeInADay);

        // When
        final RandomTimeBuilder actual = creator.lastYearOnDay(day);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_in_a_specific_day_this_year() {

        final int day = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar dayOfYearCalendar = mock(Calendar.class);
        final long midnightThisYearOnASpecificDay = someLong();
        final long timeInADay = someLong();

        final Long expected = midnightThisYearOnASpecificDay + timeInADay;

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.withDayOfYear(day)).willReturn(dayOfYearCalendar);
        given(dayOfYearCalendar.getTime()).willReturn(midnightThisYearOnASpecificDay);
        given(randomDurations.someTimeInADay()).willReturn(timeInADay);

        // When
        final RandomTimeBuilder actual = creator.thisYearOnDay(day);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_in_a_specific_day_next_year() {

        final int day = someInteger();

        final Calendar calendar = mock(Calendar.class);
        final Calendar nextYearCalendar = mock(Calendar.class);
        final Calendar dayOfYearCalendar = mock(Calendar.class);
        final long midnightNextYearOnASpecificDay = someLong();
        final long timeInADay = someLong();

        final Long expected = midnightNextYearOnASpecificDay + timeInADay;

        // Given
        given(calendars.midnightToday()).willReturn(calendar);
        given(calendar.addYears(1)).willReturn(nextYearCalendar);
        given(nextYearCalendar.withDayOfYear(day)).willReturn(dayOfYearCalendar);
        given(dayOfYearCalendar.getTime()).willReturn(midnightNextYearOnASpecificDay);
        given(randomDurations.someTimeInADay()).willReturn(timeInADay);

        // When
        final RandomTimeBuilder actual = creator.nextYearOnDay(day);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder() {

        final Long expected = someLong();

        // Given
        given(longs.someNumber()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = creator.random();

        // Then
        assertThat(actual.getTime(), is(expected));
    }
}