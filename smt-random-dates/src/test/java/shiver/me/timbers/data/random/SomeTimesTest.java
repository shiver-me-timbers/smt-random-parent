/*
 * Copyright 2015 Karl Bennett
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

    private RandomTimeFactory<RandomTimeBuilder> randomTimeFactory;

    private SomeTimes times;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        randomTimeFactory = mock(RandomTimeFactory.class);
        times = new SomeTimes(randomTimeFactory);
    }

    @Test
    public void Can_generate_a_random_time() {

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.random()).willReturn(expected);

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
        given(randomTimeFactory.now()).willReturn(nowBuilder);
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
        given(randomTimeFactory.now()).willReturn(nowBuilder);
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
        given(randomTimeFactory.create(date)).willReturn(dateBuilder);
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
        given(randomTimeFactory.create(date)).willReturn(dateBuilder);
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
        given(randomTimeFactory.between(min, max)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeBetween(min, max);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_last_second() {

        final RandomTimeBuilder todayBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.thisSecond()).willReturn(todayBuilder);
        given(todayBuilder.minusSecond(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeLastSecond();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_this_second() {

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.thisSecond()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeThisSecond();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_next_second() {

        final RandomTimeBuilder todayBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.thisSecond()).willReturn(todayBuilder);
        given(todayBuilder.addSecond(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeNextSecond();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_last_minute() {

        final RandomTimeBuilder todayBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.thisMinute()).willReturn(todayBuilder);
        given(todayBuilder.minusMinutes(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeLastMinute();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_this_minute() {

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.thisMinute()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeThisMinute();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_next_minute() {

        final RandomTimeBuilder todayBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.thisMinute()).willReturn(todayBuilder);
        given(todayBuilder.addMinutes(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeNextMinute();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_last_hour() {

        final RandomTimeBuilder todayBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.thisHour()).willReturn(todayBuilder);
        given(todayBuilder.minusHours(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeLastHour();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_this_hour() {

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.thisHour()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeThisHour();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_next_hour() {

        final RandomTimeBuilder todayBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.thisHour()).willReturn(todayBuilder);
        given(todayBuilder.addHours(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeNextHour();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_yesterday() {

        final RandomTimeBuilder todayBuilder = mock(RandomTimeBuilder.class);

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.today()).willReturn(todayBuilder);
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
        given(randomTimeFactory.today()).willReturn(expected);

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
        given(randomTimeFactory.today()).willReturn(todayBuilder);
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
        given(randomTimeFactory.thisWeek()).willReturn(thisWeekBuilder);
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
        given(randomTimeFactory.thisWeek()).willReturn(expected);

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
        given(randomTimeFactory.thisWeek()).willReturn(thisWeekBuilder);
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
        given(randomTimeFactory.thisWeekOn(weekDay)).willReturn(lastWeekBuilder);
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
        given(randomTimeFactory.thisWeekOn(weekDay)).willReturn(expected);

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
        given(randomTimeFactory.thisWeekOn(weekDay)).willReturn(nextWeekBuilder);
        given(nextWeekBuilder.addWeeks(1)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeNextWeekOn(weekDay);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_last_month() {

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.lastMonth()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeLastMonth();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_this_month() {

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.thisMonth()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeThisMonth();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_next_month() {

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.nextMonth()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeNextMonth();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_on_a_specific_day_last_month() {

        final int date = someInteger();

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.lastMonthOnThe(date)).willReturn(expected);

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
        given(randomTimeFactory.thisMonthOnThe(date)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeThisMonthOnThe(date);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_on_a_specific_day_next_month() {

        final int date = someInteger();

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.nextMonthOnThe(date)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeNextMonthOnThe(date);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_last_year() {

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.lastYear()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeLastYear();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_this_year() {

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.thisYear()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeThisYear();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_next_year() {

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.nextYear()).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeNextYear();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_on_a_specific_day_last_year() {

        final int day = someInteger();

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.lastYearOnDay(day)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeLastYearOnDay(day);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_on_a_specific_day_this_year() {

        final int day = someInteger();

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.thisYearOnDay(day)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeThisYearOnDay(day);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_on_a_specific_day_next_year() {

        final int day = someInteger();

        final RandomTimeBuilder expected = mock(RandomTimeBuilder.class);

        // Given
        given(randomTimeFactory.nextYearOnDay(day)).willReturn(expected);

        // When
        final RandomTimeBuilder actual = times.someTimeNextYearOnDay(day);

        // Then
        assertThat(actual, is(expected));
    }
}
