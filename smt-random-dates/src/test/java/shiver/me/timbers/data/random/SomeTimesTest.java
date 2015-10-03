package shiver.me.timbers.data.random;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;
import static shiver.me.timbers.data.random.RandomLongs.someLong;

public class SomeTimesTest {

    private TimeStamps timeStamps;
    private Numbers<Long> longs;

    private SomeTimes times;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {

        timeStamps = mock(TimeStamps.class);
        longs = mock(Numbers.class);

        times = new SomeTimes(timeStamps, longs);
    }

    @Test
    public void Can_generate_a_random_date() {

        final long randomLong = someLong();

        final Date expected = mock(Date.class);

        // Given
        given(longs.someNumber()).willReturn(randomLong);
        given(timeStamps.date(randomLong)).willReturn(expected);

        // When
        final Date actual = times.someTime();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_in_the_past() {

        final long randomLong = someLong();
        final long nowTime = someLong();

        final Date expected = mock(Date.class);

        // Given
        given(longs.someNegativeNumber()).willReturn(randomLong);
        given(timeStamps.now()).willReturn(nowTime);
        given(timeStamps.date(nowTime + (randomLong - 1))).willReturn(expected);

        // When
        final Date actual = times.someTimeInThePast();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_in_the_future() {

        final long randomLong = someLong();
        final long nowTime = someLong();

        final Date expected = mock(Date.class);

        // Given
        given(longs.somePositiveNumber()).willReturn(randomLong);
        given(timeStamps.now()).willReturn(nowTime);
        given(timeStamps.date(nowTime + (randomLong + 1))).willReturn(expected);

        // When
        final Date actual = times.someTimeInTheFuture();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_that_falls_before_a_specific_date() {

        final Date date = mock(Date.class);
        final long dateTime = someLong();
        final long randomLong = someLong();

        final Date expected = mock(Date.class);

        // Given
        given(date.getTime()).willReturn(dateTime);
        given(longs.someNegativeNumber()).willReturn(randomLong);
        given(timeStamps.date(dateTime + (randomLong - 1))).willReturn(expected);

        // When
        final Date actual = times.someTimeBefore(date);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_that_falls_after_a_specific_date() {

        final Date date = mock(Date.class);
        final long dateTime = someLong();
        final long randomLong = someLong();

        final Date expected = mock(Date.class);

        // Given
        given(date.getTime()).willReturn(dateTime);
        given(longs.somePositiveNumber()).willReturn(randomLong);
        given(timeStamps.date(dateTime + (randomLong + 1))).willReturn(expected);

        // When
        final Date actual = times.someTimeAfter(date);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_that_falls_between_two_dates() {

        final Date min = mock(Date.class);
        final Date max = mock(Date.class);
        final long minTime = someLong();
        final long maxTime = someLong();
        final Long randomTime = someLong();

        final Date expected = mock(Date.class);

        // Given
        given(min.getTime()).willReturn(minTime);
        given(max.getTime()).willReturn(maxTime);
        given(longs.someNumberBetween(minTime, maxTime)).willReturn(randomTime);
        given(timeStamps.date(randomTime - 1)).willReturn(expected);

        // When
        final Date actual = times.someTimeBetween(min, max);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_that_falls_yesterday() {

        final long timeInADay = someLong();
        final long yesterdayMidnightTime = someLong();

        final Date expected = mock(Date.class);

        // Given
        given(timeStamps.someTimeInADay()).willReturn(timeInADay);
        given(timeStamps.yesterdayMidnight()).willReturn(yesterdayMidnightTime);
        given(timeStamps.date(yesterdayMidnightTime + timeInADay)).willReturn(expected);

        // When
        final Date actual = times.someTimeYesterday();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_that_falls_today() {

        final long timeInADay = someLong();
        final long todayMidnight = someLong();

        final Date expected = mock(Date.class);

        // Given
        given(timeStamps.someTimeInADay()).willReturn(timeInADay);
        given(timeStamps.todayMidnight()).willReturn(todayMidnight);
        given(timeStamps.date(todayMidnight + timeInADay)).willReturn(expected);

        // When
        final Date actual = times.someTimeToday();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_that_falls_tomorrow() {

        final long timeInADay = someLong();
        final long tomorrowMidnight = 2;

        final Date expected = mock(Date.class);

        // Given
        given(timeStamps.someTimeInADay()).willReturn(timeInADay);
        given(timeStamps.tomorrowMidnight()).willReturn(tomorrowMidnight);
        given(timeStamps.date(tomorrowMidnight + timeInADay)).willReturn(expected);

        // When
        final Date actual = times.someTimeTomorrow();

        // Then
        assertEquals(expected, actual);
    }
}
