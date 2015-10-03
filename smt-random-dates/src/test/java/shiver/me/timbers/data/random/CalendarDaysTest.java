package shiver.me.timbers.data.random;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertThat;
import static shiver.me.timbers.data.random.test.DateMatchers.isMidnightToday;
import static shiver.me.timbers.data.random.test.DateMatchers.isMidnightTomorrow;
import static shiver.me.timbers.data.random.test.DateMatchers.isMidnightYesterday;

public class CalendarDaysTest {

    private CalendarDays days;

    @Before
    public void setUp() {
        days = new CalendarDays();
    }

    @Test
    public void Can_get_a_date_for_midnight_yesterday() {

        // When
        final Date actual = days.yesterday();

        // Then
        assertThat(actual, isMidnightYesterday());
    }

    @Test
    public void Can_get_a_date_for_midnight_today() {

        // When
        final Date actual = days.today();

        // Then
        assertThat(actual, isMidnightToday());
    }

    @Test
    public void Can_get_a_date_for_midnight_tomorrow() {

        // When
        final Date actual = days.tomorrow();

        // Then
        assertThat(actual, isMidnightTomorrow());
    }
}