package shiver.me.timbers.data.random;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static shiver.me.timbers.data.random.RandomDates.someDate;
import static shiver.me.timbers.data.random.RandomDates.someDateAfter;
import static shiver.me.timbers.data.random.RandomDates.someDateBefore;
import static shiver.me.timbers.data.random.RandomDates.someDateBetween;
import static shiver.me.timbers.data.random.RandomDates.someDateToday;
import static shiver.me.timbers.data.random.RandomDates.someDateTomorrow;
import static shiver.me.timbers.data.random.RandomDates.someDateYesterday;
import static shiver.me.timbers.data.random.RandomDates.someFutureDate;
import static shiver.me.timbers.data.random.RandomDates.somePastDate;
import static shiver.me.timbers.data.random.test.DateMatchers.isBetween;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeToday;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeTomorrow;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeYesterday;

public class RandomDatesTest {

    @Test
    public void Instantiation_to_get_full_coverage() {

        new RandomDates();
    }

    @Test
    public void Can_generate_a_random_date() {

        // When
        final Date actual = someDate();

        // Then
        assertNotNull(actual);
    }

    @Test
    public void Can_generate_a_random_date_before_another_date() {

        // Given
        final Date now = new Date();

        // When
        final Date actual = someDateBefore(now);

        // Then
        assertThat(actual, lessThanOrEqualTo(now));
    }

    @Test
    public void Can_generate_a_random_date_after_another_date() {

        // Given
        final Date now = new Date();

        // When
        final Date actual = someDateAfter(now);

        // Then
        assertThat(actual, greaterThanOrEqualTo(now));
    }

    @Test
    public void Can_generate_a_random_past_date() {

        // Given
        final Date now = new Date();

        // When
        final Date actual = somePastDate();

        // Then
        assertThat(actual, lessThanOrEqualTo(now));
    }

    @Test
    public void Can_generate_a_random_future_date() {

        // Given
        final Date now = new Date();

        // When
        final Date actual = someFutureDate();

        // Then
        assertThat(actual, greaterThanOrEqualTo(now));
    }

    @Test
    public void Can_generate_a_random_date_that_falls_between_two_dates() {

        // Given
        final long now = new Date().getTime();
        final Date min = new Date(now - 1000);
        final Date max = new Date(now + 1000);

        // When
        final Date actual = someDateBetween(min, max);

        // Then
        assertThat(actual, isBetween(min, max));
    }

    @Test
    public void Can_generate_a_random_date_that_falls_yesterday() {

        // When
        final Date actual = someDateYesterday();

        // Then
        assertThat(actual, isSometimeYesterday());
    }

    @Test
    public void Can_generate_a_random_date_that_falls_today() {

        // When
        final Date actual = someDateToday();

        // Then
        assertThat(actual, isSometimeToday());
    }

    @Test
    public void Can_generate_a_random_date_that_falls_tomorrow() {

        // When
        final Date actual = someDateTomorrow();

        // Then
        assertThat(actual, isSometimeTomorrow());
    }
}
