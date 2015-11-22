package shiver.me.timbers.data.random;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;
import static shiver.me.timbers.data.random.RandomEnums.someEnum;
import static shiver.me.timbers.data.random.RandomIntegers.someInteger;

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

    @Test
    public void Can_generate_a_random_time_that_falls_last_month() {

        final RandomTimeBuilder thisMonthBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.thisMonth()).willReturn(thisMonthBuilder);
        given(thisMonthBuilder.minusMonths(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeLastMonth();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_this_month() {

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.thisMonth()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeThisMonth();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_next_month() {

        final RandomTimeBuilder thisMonthBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.thisMonth()).willReturn(thisMonthBuilder);
        given(thisMonthBuilder.addMonths(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeNextMonth();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_on_a_specific_day_last_month() {

        final int date = someInteger();

        final RandomTimeBuilder lastMonthBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.thisMonthOnThe(date)).willReturn(lastMonthBuilder);
        given(lastMonthBuilder.minusMonths(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeLastMonthOnThe(date);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_on_a_specific_day_this_month() {

        final int date = someInteger();

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.thisMonthOnThe(date)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeThisMonthOnThe(date);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_on_a_specific_day_next_month() {

        final int date = someInteger();

        final RandomTimeBuilder nextMonthBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.thisMonthOnThe(date)).willReturn(nextMonthBuilder);
        given(nextMonthBuilder.addMonths(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeNextMonthOnThe(date);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_last_year() {

        final RandomTimeBuilder thisYearBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.thisYear()).willReturn(thisYearBuilder);
        given(thisYearBuilder.minusYears(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeLastYear();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_this_year() {

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.thisYear()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeThisYear();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_next_year() {

        final RandomTimeBuilder thisYearBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.thisYear()).willReturn(thisYearBuilder);
        given(thisYearBuilder.addYears(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeNextYear();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_on_a_specific_day_last_year() {

        final int day = someInteger();

        final RandomTimeBuilder lastYearBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.thisYearOnDay(day)).willReturn(lastYearBuilder);
        given(lastYearBuilder.minusYears(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeLastYearOnThe(day);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_on_a_specific_day_this_year() {

        final int day = someInteger();

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.thisYearOnDay(day)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeThisYearOnThe(day);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_on_a_specific_day_next_year() {

        final int day = someInteger();

        final RandomTimeBuilder nextYearBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeCreator.thisYearOnDay(day)).willReturn(nextYearBuilder);
        given(nextYearBuilder.addYears(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeNextYearOnThe(day);

        // Then
        assertThat(actual, is(expected));
    }
}
