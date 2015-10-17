package shiver.me.timbers.data.random;

import org.junit.Test;
import shiver.me.timbers.data.random.test.MatcherWeekDay;

import java.util.Date;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static shiver.me.timbers.data.random.RandomEnums.someEnum;
import static shiver.me.timbers.data.random.RandomTimes.someTime;
import static shiver.me.timbers.data.random.RandomTimes.someTimeAfter;
import static shiver.me.timbers.data.random.RandomTimes.someTimeBefore;
import static shiver.me.timbers.data.random.RandomTimes.someTimeBetween;
import static shiver.me.timbers.data.random.RandomTimes.someTimeInTheFuture;
import static shiver.me.timbers.data.random.RandomTimes.someTimeInThePast;
import static shiver.me.timbers.data.random.RandomTimes.someTimeLastWeek;
import static shiver.me.timbers.data.random.RandomTimes.someTimeLastWeekOn;
import static shiver.me.timbers.data.random.RandomTimes.someTimeNextWeek;
import static shiver.me.timbers.data.random.RandomTimes.someTimeNextWeekOn;
import static shiver.me.timbers.data.random.RandomTimes.someTimeThisWeek;
import static shiver.me.timbers.data.random.RandomTimes.someTimeThisWeekOn;
import static shiver.me.timbers.data.random.RandomTimes.someTimeToday;
import static shiver.me.timbers.data.random.RandomTimes.someTimeTomorrow;
import static shiver.me.timbers.data.random.RandomTimes.someTimeYesterday;
import static shiver.me.timbers.data.random.test.DateMatchers.isBetween;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeLastWeek;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeLastWeekOn;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeNextWeek;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeNextWeekOn;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeThisWeek;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeThisWeekOn;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeToday;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeTomorrow;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeYesterday;

public class RandomTimesTest {

    @Test
    public void Instantiation_to_get_full_coverage() {

        new RandomTimes();
    }

    @Test
    public void Can_generate_a_random_time() {

        // When
        final Date actual = someTime();

        // Then
        assertNotNull(actual);
    }

    @Test
    public void Can_generate_a_random_time_before_another_date() {

        // Given
        final Date now = new Date();

        // When
        final Date actual = someTimeBefore(now);

        // Then
        assertThat(actual, lessThanOrEqualTo(now));
    }

    @Test
    public void Can_generate_a_random_time_after_another_date() {

        // Given
        final Date now = new Date();

        // When
        final Date actual = someTimeAfter(now);

        // Then
        assertThat(actual, greaterThanOrEqualTo(now));
    }

    @Test
    public void Can_generate_a_random_past_date() {

        // Given
        final Date now = new Date();

        // When
        final Date actual = someTimeInThePast();

        // Then
        assertThat(actual, lessThanOrEqualTo(now));
    }

    @Test
    public void Can_generate_a_random_future_date() {

        // Given
        final Date now = new Date();

        // When
        final Date actual = someTimeInTheFuture();

        // Then
        assertThat(actual, greaterThanOrEqualTo(now));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_between_two_dates() {

        // Given
        final long now = new Date().getTime();
        final Date min = new Date(now - 1000);
        final Date max = new Date(now + 1000);

        // When
        final Date actual = someTimeBetween(min, max);

        // Then
        assertThat(actual, isBetween(min, max));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_yesterday() {

        // When
        final Date actual = someTimeYesterday();

        // Then
        assertThat(actual, isSometimeYesterday());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_today() {

        // When
        final Date actual = someTimeToday();

        // Then
        assertThat(actual, isSometimeToday());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_tomorrow() {

        // When
        final Date actual = someTimeTomorrow();

        // Then
        assertThat(actual, isSometimeTomorrow());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_last_week() {

        // When
        final Date actual = someTimeLastWeek();

        // Then
        assertThat(actual, isSometimeLastWeek());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_this_week() {

        // When
        final Date actual = someTimeThisWeek();

        // Then
        assertThat(actual, isSometimeThisWeek());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_next_week() {

        // When
        final Date actual = someTimeNextWeek();

        // Then
        assertThat(actual, isSometimeNextWeek());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_last_week_on_a_specific_day() {

        // Given
        final WeekDay weekDay = someEnum(WeekDay.class);

        // When
        final Date actual = someTimeLastWeekOn(weekDay);

        // Then
        assertThat(actual, isSometimeLastWeekOn(MatcherWeekDay.valueOf(weekDay.name())));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_this_week_on_a_specific_day() {

        // Given
        final WeekDay weekDay = someEnum(WeekDay.class);

        // When
        final Date actual = someTimeThisWeekOn(weekDay);

        // Then
        assertThat(actual, isSometimeThisWeekOn(MatcherWeekDay.valueOf(weekDay.name())));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_next_week_on_a_specific_day() {

        // Given
        final WeekDay weekDay = someEnum(WeekDay.class);

        // When
        final Date actual = someTimeNextWeekOn(weekDay);

        // Then
        assertThat(actual, isSometimeNextWeekOn(MatcherWeekDay.valueOf(weekDay.name())));
    }
}
