package shiver.me.timbers.data.random;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomIntegers.someInteger;

/**
 * @author Karl Bennett
 */
public class NumbersRandomDurationsTest {

    private static final int MILLISECONDS_IN_ONE_SECOND = 1000;
    private static final int MILLISECONDS_IN_ONE_MINUTE = MILLISECONDS_IN_ONE_SECOND * 60;
    private static final int MILLISECONDS_IN_ONE_HOUR = MILLISECONDS_IN_ONE_MINUTE * 60;
    private static final int MILLISECONDS_IN_ONE_DAY = MILLISECONDS_IN_ONE_HOUR * 24;
    private static final int MILLISECONDS_IN_ONE_WEEK = MILLISECONDS_IN_ONE_DAY * 7;

    private Numbers<Integer> integers;

    private NumbersRandomDurations timeStamps;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        integers = mock(Numbers.class);

        timeStamps = new NumbersRandomDurations(integers);
    }

    @Test
    public void Can_generate_some_random_time_stamp_that_falls_within_a_second() {

        final long expected = someInteger();

        // Given
        given(integers.someNumberBetween(0, MILLISECONDS_IN_ONE_SECOND)).willReturn((int) expected);

        // When
        final long actual = timeStamps.someTimeInASecond();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_some_random_time_stamp_that_falls_within_a_minute() {

        final long expected = someInteger();

        // Given
        given(integers.someNumberBetween(0, MILLISECONDS_IN_ONE_MINUTE)).willReturn((int) expected);

        // When
        final long actual = timeStamps.someTimeInAMinute();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_some_random_time_stamp_that_falls_within_an_hour() {

        final long expected = someInteger();

        // Given
        given(integers.someNumberBetween(0, MILLISECONDS_IN_ONE_HOUR)).willReturn((int) expected);

        // When
        final long actual = timeStamps.someTimeInAnHour();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_some_random_time_stamp_that_falls_within_a_day() {

        final long expected = someInteger();

        // Given
        given(integers.someNumberBetween(0, MILLISECONDS_IN_ONE_DAY)).willReturn((int) expected);

        // When
        final long actual = timeStamps.someTimeInADay();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_some_random_time_stamp_that_falls_within_a_week() {

        final long expected = someInteger();

        // Given
        given(integers.someNumberBetween(0, MILLISECONDS_IN_ONE_WEEK)).willReturn((int) expected);

        // When
        final long actual = timeStamps.someTimeInAWeek();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_some_random_time_stamp_that_falls_within_a_given_number_of_days() {

        final int days = someInteger();
        final int randomDays = someInteger();

        final long expected = (long) randomDays * MILLISECONDS_IN_ONE_DAY;

        // Given
        given(integers.someNumberBetween(0, days)).willReturn(randomDays);

        // When
        final long actual = timeStamps.someTimeInDays(days);

        // Then
        assertThat(actual, is(expected));
    }
}
