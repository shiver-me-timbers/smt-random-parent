package shiver.me.timbers.data.random;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static shiver.me.timbers.data.random.RandomLongs.someLong;
import static shiver.me.timbers.data.random.test.DateMatchers.isOn;

/**
 * @author Karl Bennett
 */
public class JavaCalendarsTest {

    private JavaCalendars calendars;

    @Before
    public void setUp() {
        calendars = new JavaCalendars();
    }

    @Test
    public void Can_create_a_calendar_for_a_specific_time() {

        // Given
        final Long expected = someLong();

        // When
        final Calendar actual = calendars.create(expected);

        // Then
        assertThat(actual.toTime(), is(expected));
    }

    @Test
    public void Can_create_a_calendar_for_now() {

        // When
        final Calendar actual = calendars.now();

        // Then
        assertThat(new Date(actual.toTime()), isOn(new Date()).within(10, MILLISECONDS));
    }

    @Test
    public void Can_create_a_calendar_for_midnight_today() {

        // When
        final Calendar actual = calendars.midnightToday();

        // Then
        assertThat(actual.toTime(), equalTo(LocalDate.now().toDate().getTime()));
    }
}