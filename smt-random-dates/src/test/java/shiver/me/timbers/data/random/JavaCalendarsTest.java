package shiver.me.timbers.data.random;

import org.joda.time.LocalDate;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Karl Bennett
 */
public class JavaCalendarsTest {

    @Test
    public void Can_create_a_calendar_for_midnight_today() {

        // When
        final Calendar actual = new JavaCalendars().midnightToday();

        // Then
        assertThat(LocalDate.now().toDate(), equalTo(actual.toDate()));
    }
}