package shiver.me.timbers.data.random;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;
import static shiver.me.timbers.data.random.RandomEnums.someEnum;

public class SomeTimesTest {

    private TimeStamps timeStamps;
    private Numbers<Long> longs;
    private RandomTimeCreator<RandomTimeBuilder> randomTimeCreator;

    private SomeTimes times;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        timeStamps = mock(TimeStamps.class);
        longs = mock(Numbers.class);
        randomTimeCreator = mock(RandomTimeCreator.class);

        times = new SomeTimes(randomTimeCreator);
    }

    @Test
    public void Can_generate_a_random_time() {

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.random()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTime();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_in_the_past() {

        final RandomTimeBuilder nowBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.now()).willReturn(nowBuilder);
        given(nowBuilder.inThePast()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeInThePast();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_in_the_future() {

        final RandomTimeBuilder nowBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.now()).willReturn(nowBuilder);
        given(nowBuilder.inTheFuture()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeInTheFuture();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_before_a_specific_date() {

        final Date date = mock(Date.class);

        final RandomTimeBuilder dateBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.create(date)).willReturn(dateBuilder);
        given(dateBuilder.inThePast()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeBefore(date);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_after_a_specific_date() {

        final Date date = mock(Date.class);

        final RandomTimeBuilder dateBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.create(date)).willReturn(dateBuilder);
        given(dateBuilder.inTheFuture()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeAfter(date);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_between_two_dates() {

        final Date min = mock(Date.class);
        final Date max = mock(Date.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.between(min, max)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeBetween(min, max);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_yesterday() {

        final RandomTimeBuilder todayBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.today()).willReturn(todayBuilder);
        given(todayBuilder.minusDays(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeYesterday();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_today() {

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.today()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeToday();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_tomorrow() {

        final RandomTimeBuilder todayBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.today()).willReturn(todayBuilder);
        given(todayBuilder.addDays(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeTomorrow();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_last_week() {

        final RandomTimeBuilder thisWeekBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.thisWeek()).willReturn(thisWeekBuilder);
        given(thisWeekBuilder.minusWeeks(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeLastWeek();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_this_week() {

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.thisWeek()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeThisWeek();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_next_week() {

        final RandomTimeBuilder thisWeekBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.thisWeek()).willReturn(thisWeekBuilder);
        given(thisWeekBuilder.addWeeks(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeNextWeek();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_on_a_specific_day_last_week() {

        final WeekDay weekDay = someEnum(WeekDay.class);

        final RandomTimeBuilder lastWeekBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.thisWeekOn(weekDay)).willReturn(lastWeekBuilder);
        given(lastWeekBuilder.minusWeeks(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeLastWeekOn(weekDay);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_on_a_specific_day_this_week() {

        final WeekDay weekDay = someEnum(WeekDay.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.thisWeekOn(weekDay)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeThisWeekOn(weekDay);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_on_a_specific_day_next_week() {

        final WeekDay weekDay = someEnum(WeekDay.class);

        final RandomTimeBuilder nextWeekBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.thisWeekOn(weekDay)).willReturn(nextWeekBuilder);
        given(nextWeekBuilder.addWeeks(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeNextWeekOn(weekDay);

        // Then
        assertThat(actual, is(expected));
    }
}
