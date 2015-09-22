package shiver.me.timbers.data.random;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;
import static shiver.me.timbers.data.random.test.DateMatchers.isBetween;

public class SomeDatesTest {

    private static final int MILLISECOND_IN_ONE_DAY = 86400000;

    private DateFactory dateFactory;
    private Random random;
    private SomeDates dates;
    private Date expected;

    @Before
    public void setUp() {

        dateFactory = mock(DateFactory.class);
        random = mock(Random.class);

        dates = new SomeDates(random, dateFactory);

        expected = mock(Date.class);
    }

    @Test
    public void Can_generate_a_random_date() {

        final long randomLong = 1;

        // Given
        given(random.nextLong()).willReturn(randomLong);
        given(dateFactory.date(randomLong)).willReturn(expected);

        // When
        final Date actual = dates.someDate();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_in_the_past() {

        final long randomLong = 1;
        final long nowTime = 2;

        // Given
        given(random.nextLong()).willReturn(randomLong);
        given(dateFactory.nowTime()).willReturn(nowTime);
        given(dateFactory.date(nowTime - randomLong)).willReturn(expected);

        // When
        final Date actual = dates.somePastDate();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_in_the_past_from_a_negative_random_long() {

        final long randomLong = -1;
        final long nowTime = 2;

        // Given
        given(random.nextLong()).willReturn(randomLong);
        given(dateFactory.nowTime()).willReturn(nowTime);
        given(dateFactory.date(nowTime - (-1 * randomLong))).willReturn(expected);

        // When
        final Date actual = dates.somePastDate();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_in_the_future() {

        final long randomLong = 1;
        final long nowTime = 2;

        // Given
        given(random.nextLong()).willReturn(randomLong);
        given(dateFactory.nowTime()).willReturn(nowTime);
        given(dateFactory.date(nowTime + randomLong)).willReturn(expected);

        // When
        final Date actual = dates.someFutureDate();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_in_the_future_from_a_negative_random_long() {

        final long randomLong = -1;
        final long nowTime = 2;

        // Given
        given(random.nextLong()).willReturn(randomLong);
        given(dateFactory.nowTime()).willReturn(nowTime);
        given(dateFactory.date(nowTime + (-1 * randomLong))).willReturn(expected);

        // When
        final Date actual = dates.someFutureDate();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_that_falls_before_a_specific_date() {

        final Date date = mock(Date.class);
        final long dateTime = 1;
        final long randomLong = 2;

        // Given
        given(date.getTime()).willReturn(dateTime);
        given(random.nextLong()).willReturn(randomLong);
        given(dateFactory.date(dateTime - randomLong)).willReturn(expected);

        // When
        final Date actual = dates.someDateBefore(date);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_that_falls_before_a_specific_date_even_if_the_max_range_is_randomly_produced() {

        final Date date = mock(Date.class);
        final long dateTime = 1;
        final long randomLong = -2;

        // Given
        given(date.getTime()).willReturn(dateTime);
        given(random.nextLong()).willReturn(randomLong);
        given(dateFactory.date(dateTime - (-1 * randomLong))).willReturn(expected);

        // When
        final Date actual = dates.someDateBefore(date);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_that_falls_after_a_specific_date() {

        final Date date = mock(Date.class);
        final long dateTime = 1;
        final long randomLong = 2;

        // Given
        given(date.getTime()).willReturn(dateTime);
        given(random.nextLong()).willReturn(randomLong);
        given(dateFactory.date(dateTime + randomLong)).willReturn(expected);

        // When
        final Date actual = dates.someDateAfter(date);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_that_falls_after_a_specific_date_even_if_the_max_range_is_randomly_produced() {

        final Date date = mock(Date.class);
        final long dateTime = 1;
        final long randomLong = -2;

        // Given
        given(date.getTime()).willReturn(dateTime);
        given(random.nextLong()).willReturn(randomLong);
        given(dateFactory.date(dateTime + (-1 * randomLong))).willReturn(expected);

        // When
        final Date actual = dates.someDateAfter(date);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_that_falls_between_two_dates() {

        final Date min = mock(Date.class);
        final Date max = mock(Date.class);
        final long minTime = -1;
        final long maxTime = 2;
        final double randomDouble = 0.5;
        final long range = (maxTime - minTime) - 1;

        // Given
        given(min.getTime()).willReturn(minTime);
        given(max.getTime()).willReturn(maxTime);
        given(random.nextDouble()).willReturn(randomDouble);
        given(dateFactory.date(minTime + (long) (range * randomDouble))).willReturn(expected);

        // When
        final Date actual = dates.someDateBetween(min, max);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_that_falls_between_two_dates_even_if_the_max_range_is_randomly_produced() {

        final Date min = new Date(-1000);
        final Date max = new Date(1000);
        final double randomDouble = 1;

        // Given
        given(random.nextDouble()).willReturn(randomDouble);

        // When
        final Date actual = new SomeDates(random, new UtilDateFactory()).someDateBetween(min, max);

        // Then
        assertThat(actual, isBetween(min, max));
    }

    @Test
    public void Can_generate_a_random_date_that_falls_yesterday() {

        final int randomInt = 1;
        final long yesterdayMidnightTime = 2;

        // Given
        given(random.nextInt(MILLISECOND_IN_ONE_DAY)).willReturn(randomInt);
        given(dateFactory.yesterdayMidnightTime()).willReturn(yesterdayMidnightTime);
        given(dateFactory.date(yesterdayMidnightTime + randomInt)).willReturn(expected);

        // When
        final Date actual = dates.someDateYesterday();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_that_falls_yesterday_from_a_negative_random_int() {

        final int randomInt = -1;
        final long yesterdayMidnightTime = 2;

        // Given
        given(random.nextInt(MILLISECOND_IN_ONE_DAY)).willReturn(randomInt);
        given(dateFactory.yesterdayMidnightTime()).willReturn(yesterdayMidnightTime);
        given(dateFactory.date(yesterdayMidnightTime + (-1 * randomInt))).willReturn(expected);

        // When
        final Date actual = dates.someDateYesterday();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_that_falls_today() {

        final int randomInt = 1;
        final long todayMidnight = 2;

        // Given
        given(random.nextInt(MILLISECOND_IN_ONE_DAY)).willReturn(randomInt);
        given(dateFactory.todayMidnight()).willReturn(todayMidnight);
        given(dateFactory.date(todayMidnight + randomInt)).willReturn(expected);

        // When
        final Date actual = dates.someDateToday();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_that_falls_today_from_a_negative_random_int() {

        final int randomInt = -1;
        final long todayMidnight = 2;

        // Given
        given(random.nextInt(MILLISECOND_IN_ONE_DAY)).willReturn(randomInt);
        given(dateFactory.todayMidnight()).willReturn(todayMidnight);
        given(dateFactory.date(todayMidnight + (-1 * randomInt))).willReturn(expected);

        // When
        final Date actual = dates.someDateToday();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_that_falls_tomorrow() {

        final int randomInt = 1;
        final long tomorrowMidnight = 2;

        // Given
        given(random.nextInt(MILLISECOND_IN_ONE_DAY)).willReturn(randomInt);
        given(dateFactory.tomorrowMidnightTime()).willReturn(tomorrowMidnight);
        given(dateFactory.date(tomorrowMidnight + randomInt)).willReturn(expected);

        // When
        final Date actual = dates.someDateTomorrow();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_generate_a_random_date_that_falls_tomorrow_from_a_negative_random_int() {

        final int randomInt = -1;
        final long tomorrowMidnight = 2;

        // Given
        given(random.nextInt(MILLISECOND_IN_ONE_DAY)).willReturn(randomInt);
        given(dateFactory.tomorrowMidnightTime()).willReturn(tomorrowMidnight);
        given(dateFactory.date(tomorrowMidnight + (-1 * randomInt))).willReturn(expected);

        // When
        final Date actual = dates.someDateTomorrow();

        // Then
        assertEquals(expected, actual);
    }
}
