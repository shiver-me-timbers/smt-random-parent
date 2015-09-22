package shiver.me.timbers.data.random;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static shiver.me.timbers.data.random.test.DateMatchers.isWithinASecondOf;
import static shiver.me.timbers.data.random.test.DateMatchers.todayMidnight;
import static shiver.me.timbers.data.random.test.DateMatchers.tomorrowMidnight;
import static shiver.me.timbers.data.random.test.DateMatchers.yesterdayMidnight;

/**
 * @author Karl Bennett
 */
public class UtilDateFactoryTest {

    @Test
    public void Can_create_a_date() {

        // Given
        final long date = 1000L;
        final Date expected = new Date(date);

        // When
        final Date actual = new UtilDateFactory().date(date);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_get_the_time_for_now() {

        // When
        final Date actual = new Date(new UtilDateFactory().nowTime());

        // Then
        assertThat(actual, isWithinASecondOf(new Date()));
    }

    @Test
    public void Can_get_the_time_for_yesterday_at_midnight() {

        // When
        final Date actual = new Date(new UtilDateFactory().yesterdayMidnightTime());

        // Then
        assertThat(actual, equalTo(yesterdayMidnight()));
    }

    @Test
    public void Can_get_the_time_for_today_at_midnight() {

        // When
        final Date actual = new Date(new UtilDateFactory().todayMidnight());

        // Then
        assertThat(actual, equalTo(todayMidnight()));
    }

    @Test
    public void Can_get_the_time_for_tomorrow_at_midnight() {

        // When
        final Date actual = new Date(new UtilDateFactory().tomorrowMidnightTime());

        // Then
        assertThat(actual, equalTo(tomorrowMidnight()));
    }
}
