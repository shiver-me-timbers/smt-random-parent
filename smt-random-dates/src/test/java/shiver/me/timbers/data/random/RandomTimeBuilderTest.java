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

    private TimeStamps timeStamps;
    private Numbers<Long> longs;
    private Long initialTime;

    private RandomTimeBuilder builder;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        timeStamps = mock(TimeStamps.class);
        longs = mock(Numbers.class);
        initialTime = someLong();

        builder = new RandomTimeBuilder(timeStamps, longs, initialTime);
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
    public void Can_minus_some_days_off_the_random_time_builders_time() {

        final int days = someInteger();

        final long expected = someLong();

        // Given
        given(timeStamps.minusDays(initialTime, days)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.minusDays(days);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_add_some_days_off_the_random_time_builders_time() {

        final int days = someInteger();

        final long expected = someLong();

        // Given
        given(timeStamps.addDays(initialTime, days)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.addDays(days);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_minus_some_weeks_off_the_random_time_builders_time() {

        final int weeks = someInteger();

        final long expected = someLong();

        // Given
        given(timeStamps.minusWeeks(initialTime, weeks)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.minusWeeks(weeks);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_add_some_weeks_to_the_random_time_builders_time() {

        final int weeks = someInteger();

        final long expected = someLong();

        // Given
        given(timeStamps.addWeeks(initialTime, weeks)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.addWeeks(weeks);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_minus_some_months_off_the_random_time_builders_time() {

        final int months = someInteger();

        final long expected = someLong();

        // Given
        given(timeStamps.minusMonths(initialTime, months)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.minusMonths(months);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_add_some_months_to_the_random_time_builders_time() {

        final int months = someInteger();

        final long expected = someLong();

        // Given
        given(timeStamps.addMonths(initialTime, months)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.addMonths(months);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_minus_some_years_off_the_random_time_builders_time() {

        final int years = someInteger();

        final long expected = someLong();

        // Given
        given(timeStamps.minusYears(initialTime, years)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.minusYears(years);

        // Then
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_add_some_years_to_the_random_time_builders_time() {

        final int years = someInteger();

        final long expected = someLong();

        // Given
        given(timeStamps.addYears(initialTime, years)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = builder.addYears(years);

        // Then
        assertThat(actual.getTime(), is(expected));
    }
}