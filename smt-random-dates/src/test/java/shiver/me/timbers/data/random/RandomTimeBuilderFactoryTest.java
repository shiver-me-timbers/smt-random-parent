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

    private TimeStamps timeStamps;
    private Numbers<Long> longs;
    private RandomTimeBuilderFactory creator;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        timeStamps = mock(TimeStamps.class);
        longs = mock(Numbers.class);
        creator = new RandomTimeBuilderFactory(timeStamps, longs);
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

        final Long expected = someLong();

        // Given
        given(timeStamps.now()).willReturn(expected);

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
    public void Can_create_a_random_time_builder_for_some_time_today() {

        final long todayMidnight = someLong();
        final long timeInADay = someLong();

        final Long expected = todayMidnight + timeInADay;

        // Given
        given(timeStamps.todayMidnight()).willReturn(todayMidnight);
        given(timeStamps.someTimeInADay()).willReturn(timeInADay);

        // When
        final RandomTimeBuilder actual = creator.today();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_this_week() {

        final long midnightMondayThisWeek = someLong();
        final long timeInAWeek = someLong();

        final Long expected = midnightMondayThisWeek + timeInAWeek;

        // Given
        given(timeStamps.midnightThisWeekOn(MONDAY)).willReturn(midnightMondayThisWeek);
        given(timeStamps.someTimeInAWeek()).willReturn(timeInAWeek);

        // When
        final RandomTimeBuilder actual = creator.thisWeek();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_in_a_specific_day_this_week() {

        final WeekDay weekDay = someEnum(WeekDay.class);

        final long midnightMondayThisWeek = someLong();
        final long timeInADay = someLong();

        final Long expected = midnightMondayThisWeek + timeInADay;

        // Given
        given(timeStamps.midnightThisWeekOn(weekDay)).willReturn(midnightMondayThisWeek);
        given(timeStamps.someTimeInADay()).willReturn(timeInADay);

        // When
        final RandomTimeBuilder actual = creator.thisWeekOn(weekDay);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_last_month() {

        final long midnightLastMonthOnThe1st = someLong();
        final long timeInAMonth = someLong();

        final Long expected = midnightLastMonthOnThe1st + timeInAMonth;

        // Given
        given(timeStamps.midnightLastMonthOnThe(1)).willReturn(midnightLastMonthOnThe1st);
        given(timeStamps.someTimeInAMonth()).willReturn(timeInAMonth);

        // When
        final RandomTimeBuilder actual = creator.lastMonth();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_this_month() {

        final long midnightThisMonthOnThe1st = someLong();
        final long timeInAMonth = someLong();

        final Long expected = midnightThisMonthOnThe1st + timeInAMonth;

        // Given
        given(timeStamps.midnightThisMonthOnThe(1)).willReturn(midnightThisMonthOnThe1st);
        given(timeStamps.someTimeInAMonth()).willReturn(timeInAMonth);

        // When
        final RandomTimeBuilder actual = creator.thisMonth();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_next_month() {

        final long midnightNextMonthOnThe1st = someLong();
        final long timeInAMonth = someLong();

        final Long expected = midnightNextMonthOnThe1st + timeInAMonth;

        // Given
        given(timeStamps.midnightNextMonthOnThe(1)).willReturn(midnightNextMonthOnThe1st);
        given(timeStamps.someTimeInAMonth()).willReturn(timeInAMonth);

        // When
        final RandomTimeBuilder actual = creator.nextMonth();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_in_a_specific_date_last_month() {

        final int date = someInteger();

        final long midnightLastMonthOnThe1st = someLong();
        final long timeInADay = someLong();

        final Long expected = midnightLastMonthOnThe1st + timeInADay;

        // Given
        given(timeStamps.midnightLastMonthOnThe(date)).willReturn(midnightLastMonthOnThe1st);
        given(timeStamps.someTimeInADay()).willReturn(timeInADay);

        // When
        final RandomTimeBuilder actual = creator.lastMonthOnThe(date);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_in_a_specific_date_this_month() {

        final int date = someInteger();

        final long midnightThisMonthOnThe1st = someLong();
        final long timeInADay = someLong();

        final Long expected = midnightThisMonthOnThe1st + timeInADay;

        // Given
        given(timeStamps.midnightThisMonthOnThe(date)).willReturn(midnightThisMonthOnThe1st);
        given(timeStamps.someTimeInADay()).willReturn(timeInADay);

        // When
        final RandomTimeBuilder actual = creator.thisMonthOnThe(date);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_in_a_specific_date_next_month() {

        final int date = someInteger();

        final long midnightNextMonthOnThe1st = someLong();
        final long timeInADay = someLong();

        final Long expected = midnightNextMonthOnThe1st + timeInADay;

        // Given
        given(timeStamps.midnightNextMonthOnThe(date)).willReturn(midnightNextMonthOnThe1st);
        given(timeStamps.someTimeInADay()).willReturn(timeInADay);

        // When
        final RandomTimeBuilder actual = creator.nextMonthOnThe(date);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_last_year() {

        final long midnightLastYearOnDay1 = someLong();
        final long timeInAYear = someLong();

        final Long expected = midnightLastYearOnDay1 + timeInAYear;

        // Given
        given(timeStamps.midnightLastYearOnDay(1)).willReturn(midnightLastYearOnDay1);
        given(timeStamps.someTimeInAYear()).willReturn(timeInAYear);

        // When
        final RandomTimeBuilder actual = creator.lastYear();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_this_year() {

        final long midnightThisYearOnDay1 = someLong();
        final long timeInAYear = someLong();

        final Long expected = midnightThisYearOnDay1 + timeInAYear;

        // Given
        given(timeStamps.midnightThisYearOnDay(1)).willReturn(midnightThisYearOnDay1);
        given(timeStamps.someTimeInAYear()).willReturn(timeInAYear);

        // When
        final RandomTimeBuilder actual = creator.thisYear();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_next_year() {

        final long midnightNextYearOnDay1 = someLong();
        final long timeInAYear = someLong();

        final Long expected = midnightNextYearOnDay1 + timeInAYear;

        // Given
        given(timeStamps.midnightNextYearOnDay(1)).willReturn(midnightNextYearOnDay1);
        given(timeStamps.someTimeInAYear()).willReturn(timeInAYear);

        // When
        final RandomTimeBuilder actual = creator.nextYear();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_in_a_specific_day_last_year() {

        final int day = someInteger();

        final long midnightLastYearOnASpecificDay = someLong();
        final long timeInADay = someLong();

        final Long expected = midnightLastYearOnASpecificDay + timeInADay;

        // Given
        given(timeStamps.midnightLastYearOnDay(day)).willReturn(midnightLastYearOnASpecificDay);
        given(timeStamps.someTimeInADay()).willReturn(timeInADay);

        // When
        final RandomTimeBuilder actual = creator.lastYearOnDay(day);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_in_a_specific_day_this_year() {

        final int day = someInteger();

        final long midnightThisYearOnASpecificDay = someLong();
        final long timeInADay = someLong();

        final Long expected = midnightThisYearOnASpecificDay + timeInADay;

        // Given
        given(timeStamps.midnightThisYearOnDay(day)).willReturn(midnightThisYearOnASpecificDay);
        given(timeStamps.someTimeInADay()).willReturn(timeInADay);

        // When
        final RandomTimeBuilder actual = creator.thisYearOnDay(day);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_in_a_specific_day_next_year() {

        final int day = someInteger();

        final long midnightNextYearOnASpecificDay = someLong();
        final long timeInADay = someLong();

        final Long expected = midnightNextYearOnASpecificDay + timeInADay;

        // Given
        given(timeStamps.midnightNextYearOnDay(day)).willReturn(midnightNextYearOnASpecificDay);
        given(timeStamps.someTimeInADay()).willReturn(timeInADay);

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