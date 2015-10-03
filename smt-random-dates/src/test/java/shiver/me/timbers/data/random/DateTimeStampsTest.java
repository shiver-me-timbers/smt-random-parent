package shiver.me.timbers.data.random;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomIntegers.someInteger;
import static shiver.me.timbers.data.random.RandomLongs.someLong;
import static shiver.me.timbers.data.random.test.DateMatchers.isOn;

/**
 * @author Karl Bennett
 */
public class DateTimeStampsTest {

    private static final int MILLISECOND_IN_ONE_DAY = 86400000;

    private Random random;
    private Days days;

    private DateTimeStamps timeStamps;

    @Before
    public void setUp() {
        random = mock(Random.class);
        days = mock(Days.class);

        timeStamps = new DateTimeStamps(random, days);
    }

    @Test
    public void Can_create_a_date() {

        // Given
        final long date = 1000L;
        final Date expected = new Date(date);

        // When
        final Date actual = timeStamps.date(date);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_get_the_time_for_now() {

        // When
        final Date actual = new Date(timeStamps.now());

        // Then
        assertThat(actual, isOn(new Date()).within(100, MILLISECONDS));
    }

    @Test
    public void Can_generate_some_random_time_stamp_in_a_day() {

        final long expected = someInteger();

        // Given
        given(random.nextInt(MILLISECOND_IN_ONE_DAY)).willReturn((int) expected);

        // When
        final long actual = timeStamps.someTimeInADay();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_get_the_time_for_yesterday_at_midnight() {

        final Date yesterday = mock(Date.class);

        final Long expected = someLong();

        // Given
        given(days.yesterday()).willReturn(yesterday);
        given(yesterday.getTime()).willReturn(expected);

        // When
        final long actual = timeStamps.yesterdayMidnight();

        // Then
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void Can_get_the_time_for_today_at_midnight() {

        final Date today = mock(Date.class);

        final Long expected = someLong();

        // Given
        given(days.today()).willReturn(today);
        given(today.getTime()).willReturn(expected);

        // When
        final long actual = timeStamps.todayMidnight();

        // Then
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void Can_get_the_time_for_tomorrow_at_midnight() {

        final Date tomorrow = mock(Date.class);

        final Long expected = someLong();

        // Given
        given(days.tomorrow()).willReturn(tomorrow);
        given(tomorrow.getTime()).willReturn(expected);

        // When
        final long actual = timeStamps.tomorrowMidnight();

        // Then
        assertThat(actual, equalTo(expected));
    }
}
