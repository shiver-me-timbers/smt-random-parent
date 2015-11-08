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

public class RandomTimeBuilderCreatorTest {

    private TimeStamps timeStamps;
    private Numbers<Long> longs;
    private RandomTimeBuilderCreator creator;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        timeStamps = mock(TimeStamps.class);
        longs = mock(Numbers.class);
        creator = new RandomTimeBuilderCreator(timeStamps, longs);
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
    public void Can_create_a_random_time_builder() {

        final Long expected = someLong();

        // Given
        given(longs.someNumber()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = creator.random();

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
    public void Can_create_a_random_time_builder_for_some_time_this_month() {

        final long midnightTheMonthOnThe1st = someLong();
        final long timeInAMonth = someLong();

        final Long expected = midnightTheMonthOnThe1st + timeInAMonth;

        // Given
        given(timeStamps.midnightThisMonthOnThe(1)).willReturn(midnightTheMonthOnThe1st);
        given(timeStamps.someTimeInAMonth()).willReturn(timeInAMonth);

        // When
        final RandomTimeBuilder actual = creator.thisMonth();

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_random_time_builder_for_some_time_in_a_specific_date_this_month() {

        final int date = someInteger();

        final long midnightTheMonthOnThe1st = someLong();
        final long timeInADay = someLong();

        final Long expected = midnightTheMonthOnThe1st + timeInADay;

        // Given
        given(timeStamps.midnightThisMonthOnThe(date)).willReturn(midnightTheMonthOnThe1st);
        given(timeStamps.someTimeInADay()).willReturn(timeInADay);

        // When
        final RandomTimeBuilder actual = creator.thisMonthOnThe(date);

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
    public void Can_create_a_random_time_builder_for_now() {

        final Long expected = someLong();

        // Given
        given(timeStamps.now()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = creator.now();

        // Then
        assertThat(actual.getTime(), is(expected));
    }
}