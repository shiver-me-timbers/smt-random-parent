package shiver.me.timbers.data.random;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;
import static shiver.me.timbers.data.random.RandomEnums.someEnum;
import static shiver.me.timbers.data.random.RandomLongs.someLong;
import static shiver.me.timbers.data.random.WeekDay.MONDAY;

public class SomeTimesTest {

    private TimeStamps timeStamps;
    private Numbers<Long> longs;
    private RandomDateBuilder randomDateBuilder;

    private SomeTimes times;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        timeStamps = mock(TimeStamps.class);
        longs = mock(Numbers.class);
        randomDateBuilder = mock(RandomDateBuilder.class);

        times = new SomeTimes(timeStamps, longs, randomDateBuilder);
    }

    @Test
    public void Can_generate_a_random_time() {

        final long randomLong = someLong();

        final Date date = mock(Date.class);

        final RandomDateBuilder expected = mock(RandomDateBuilder.class);

        // Given
        given(longs.someNumber()).willReturn(randomLong);
        given(timeStamps.date(randomLong)).willReturn(date);
        given(randomDateBuilder.create(date)).willReturn(expected);

        // When
        final RandomDateBuilder actual = times.someTime();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_in_the_past() {

        final long randomLong = someLong();
        final long nowTime = someLong();

        final Date date = mock(Date.class);

        final RandomDateBuilder expected = mock(RandomDateBuilder.class);

        // Given
        given(longs.someNegativeNumber()).willReturn(randomLong);
        given(timeStamps.now()).willReturn(nowTime);
        given(timeStamps.date(nowTime + (randomLong - 1))).willReturn(date);
        given(randomDateBuilder.create(date)).willReturn(expected);

        // When
        final RandomDateBuilder actual = times.someTimeInThePast();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_in_the_future() {

        final long randomLong = someLong();
        final long nowTime = someLong();

        final Date date = mock(Date.class);

        final RandomDateBuilder expected = mock(RandomDateBuilder.class);

        // Given
        given(longs.somePositiveNumber()).willReturn(randomLong);
        given(timeStamps.now()).willReturn(nowTime);
        given(timeStamps.date(nowTime + (randomLong + 1))).willReturn(date);
        given(randomDateBuilder.create(date)).willReturn(expected);

        // When
        final RandomDateBuilder actual = times.someTimeInTheFuture();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_before_a_specific_date() {

        final Date date = mock(Date.class);
        final long dateTime = someLong();
        final long randomLong = someLong();

        final Date beforeDate = mock(Date.class);

        final RandomDateBuilder expected = mock(RandomDateBuilder.class);

        // Given
        given(date.getTime()).willReturn(dateTime);
        given(longs.someNegativeNumber()).willReturn(randomLong);
        given(timeStamps.date(dateTime + (randomLong - 1))).willReturn(beforeDate);
        given(randomDateBuilder.create(beforeDate)).willReturn(expected);

        // When
        final RandomDateBuilder actual = times.someTimeBefore(date);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_after_a_specific_date() {

        final Date date = mock(Date.class);
        final long dateTime = someLong();
        final long randomLong = someLong();

        final Date afterDate = mock(Date.class);

        final RandomDateBuilder expected = mock(RandomDateBuilder.class);

        // Given
        given(date.getTime()).willReturn(dateTime);
        given(longs.somePositiveNumber()).willReturn(randomLong);
        given(timeStamps.date(dateTime + (randomLong + 1))).willReturn(afterDate);
        given(randomDateBuilder.create(afterDate)).willReturn(expected);

        // When
        final RandomDateBuilder actual = times.someTimeAfter(date);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_between_two_dates() {

        final Date min = mock(Date.class);
        final Date max = mock(Date.class);
        final long minTime = someLong();
        final long maxTime = someLong();
        final Long randomTime = someLong();

        final Date betweenDate = mock(Date.class);

        final RandomDateBuilder expected = mock(RandomDateBuilder.class);

        // Given
        given(min.getTime()).willReturn(minTime);
        given(max.getTime()).willReturn(maxTime);
        given(longs.someNumberBetween(minTime, maxTime)).willReturn(randomTime);
        given(timeStamps.date(randomTime - 1)).willReturn(betweenDate);
        given(randomDateBuilder.create(betweenDate)).willReturn(expected);

        // When
        final RandomDateBuilder actual = times.someTimeBetween(min, max);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_yesterday() {

        final long yesterdayMidnightTime = someLong();
        final long timeInADay = someLong();

        final Date yesterday = mock(Date.class);

        final RandomDateBuilder expected = mock(RandomDateBuilder.class);

        // Given
        given(timeStamps.yesterdayMidnight()).willReturn(yesterdayMidnightTime);
        given(timeStamps.someTimeInADay()).willReturn(timeInADay);
        given(timeStamps.date(yesterdayMidnightTime + timeInADay)).willReturn(yesterday);
        given(randomDateBuilder.create(yesterday)).willReturn(expected);

        // When
        final RandomDateBuilder actual = times.someTimeYesterday();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_today() {

        final long todayMidnight = someLong();
        final long timeInADay = someLong();

        final Date today = mock(Date.class);

        final RandomDateBuilder expected = mock(RandomDateBuilder.class);

        // Given
        given(timeStamps.todayMidnight()).willReturn(todayMidnight);
        given(timeStamps.someTimeInADay()).willReturn(timeInADay);
        given(timeStamps.date(todayMidnight + timeInADay)).willReturn(today);
        given(randomDateBuilder.create(today)).willReturn(expected);

        // When
        final RandomDateBuilder actual = times.someTimeToday();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_tomorrow() {

        final long tomorrowMidnight = someLong();
        final long timeInADay = someLong();

        final Date tomorrow = mock(Date.class);

        final RandomDateBuilder expected = mock(RandomDateBuilder.class);

        // Given
        given(timeStamps.tomorrowMidnight()).willReturn(tomorrowMidnight);
        given(timeStamps.someTimeInADay()).willReturn(timeInADay);
        given(timeStamps.date(tomorrowMidnight + timeInADay)).willReturn(tomorrow);
        given(randomDateBuilder.create(tomorrow)).willReturn(expected);

        // When
        final RandomDateBuilder actual = times.someTimeTomorrow();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_last_week() {

        final long midnightMondayLastWeek = someLong();
        final long timeInAWeek = someLong();

        final Date lastWeek = mock(Date.class);

        final RandomDateBuilder expected = mock(RandomDateBuilder.class);

        // Given
        given(timeStamps.midnightLastWeekOn(MONDAY)).willReturn(midnightMondayLastWeek);
        given(timeStamps.someTimeInAWeek()).willReturn(timeInAWeek);
        given(timeStamps.date(midnightMondayLastWeek + timeInAWeek)).willReturn(lastWeek);
        given(randomDateBuilder.create(lastWeek)).willReturn(expected);

        // When
        final RandomDateBuilder actual = times.someTimeLastWeek();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_this_week() {

        final long midnightMondayThisWeek = someLong();
        final long timeInAWeek = someLong();

        final Date thisWeek = mock(Date.class);

        final RandomDateBuilder expected = mock(RandomDateBuilder.class);

        // Given
        given(timeStamps.midnightThisWeekOn(MONDAY)).willReturn(midnightMondayThisWeek);
        given(timeStamps.someTimeInAWeek()).willReturn(timeInAWeek);
        given(timeStamps.date(midnightMondayThisWeek + timeInAWeek)).willReturn(thisWeek);
        given(randomDateBuilder.create(thisWeek)).willReturn(expected);

        // When
        final RandomDateBuilder actual = times.someTimeThisWeek();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_next_week() {

        final long midnightMondayNextWeek = someLong();
        final long timeInAWeek = someLong();

        final Date nextWeek = mock(Date.class);

        final RandomDateBuilder expected = mock(RandomDateBuilder.class);

        // Given
        given(timeStamps.midnightNextWeekOn(MONDAY)).willReturn(midnightMondayNextWeek);
        given(timeStamps.someTimeInAWeek()).willReturn(timeInAWeek);
        given(timeStamps.date(midnightMondayNextWeek + timeInAWeek)).willReturn(nextWeek);
        given(randomDateBuilder.create(nextWeek)).willReturn(expected);

        // When
        final RandomDateBuilder actual = times.someTimeNextWeek();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_on_a_specific_day_last_week() {

        final WeekDay weekDay = someEnum(WeekDay.class);
        final long weekDayMidnight = someLong();
        final long timeInADay = someLong();

        final Date lastWeek = mock(Date.class);

        final RandomDateBuilder expected = mock(RandomDateBuilder.class);

        // Given
        given(timeStamps.midnightLastWeekOn(weekDay)).willReturn(weekDayMidnight);
        given(timeStamps.someTimeInADay()).willReturn(timeInADay);
        given(timeStamps.date(weekDayMidnight + timeInADay)).willReturn(lastWeek);
        given(randomDateBuilder.create(lastWeek)).willReturn(expected);

        // When
        final RandomDateBuilder actual = times.someTimeLastWeekOn(weekDay);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_on_a_specific_day_this_week() {

        final WeekDay weekDay = someEnum(WeekDay.class);
        final long weekDayMidnight = someLong();
        final long timeInADay = someLong();

        final Date thisWeek = mock(Date.class);

        final RandomDateBuilder expected = mock(RandomDateBuilder.class);

        // Given
        given(timeStamps.midnightThisWeekOn(weekDay)).willReturn(weekDayMidnight);
        given(timeStamps.someTimeInADay()).willReturn(timeInADay);
        given(timeStamps.date(weekDayMidnight + timeInADay)).willReturn(thisWeek);
        given(randomDateBuilder.create(thisWeek)).willReturn(expected);

        // When
        final RandomDateBuilder actual = times.someTimeThisWeekOn(weekDay);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_on_a_specific_day_next_week() {

        final WeekDay weekDay = someEnum(WeekDay.class);
        final long weekDayMidnight = someLong();
        final long timeInADay = someLong();

        final Date nextWeek = mock(Date.class);

        final RandomDateBuilder expected = mock(RandomDateBuilder.class);

        // Given
        given(timeStamps.midnightNextWeekOn(weekDay)).willReturn(weekDayMidnight);
        given(timeStamps.someTimeInADay()).willReturn(timeInADay);
        given(timeStamps.date(weekDayMidnight + timeInADay)).willReturn(nextWeek);
        given(randomDateBuilder.create(nextWeek)).willReturn(expected);

        // When
        final RandomDateBuilder actual = times.someTimeNextWeekOn(weekDay);

        // Then
        assertThat(actual, is(expected));
    }
}
