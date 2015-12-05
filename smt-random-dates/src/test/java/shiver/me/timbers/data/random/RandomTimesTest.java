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

import org.junit.Test;
import shiver.me.timbers.data.random.test.DateMatchers;
import shiver.me.timbers.data.random.test.MatcherWeekDay;

import java.util.Date;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static shiver.me.timbers.data.random.RandomEnums.someEnum;
import static shiver.me.timbers.data.random.RandomIntegers.someIntegerBetween;
import static shiver.me.timbers.data.random.RandomTimes.someTime;
import static shiver.me.timbers.data.random.RandomTimes.someTimeAfter;
import static shiver.me.timbers.data.random.RandomTimes.someTimeBefore;
import static shiver.me.timbers.data.random.RandomTimes.someTimeBetween;
import static shiver.me.timbers.data.random.RandomTimes.someTimeInTheFuture;
import static shiver.me.timbers.data.random.RandomTimes.someTimeInThePast;
import static shiver.me.timbers.data.random.RandomTimes.someTimeLastHour;
import static shiver.me.timbers.data.random.RandomTimes.someTimeLastMinute;
import static shiver.me.timbers.data.random.RandomTimes.someTimeLastMonth;
import static shiver.me.timbers.data.random.RandomTimes.someTimeLastMonthOnThe;
import static shiver.me.timbers.data.random.RandomTimes.someTimeLastSecond;
import static shiver.me.timbers.data.random.RandomTimes.someTimeLastWeek;
import static shiver.me.timbers.data.random.RandomTimes.someTimeLastWeekOn;
import static shiver.me.timbers.data.random.RandomTimes.someTimeLastYear;
import static shiver.me.timbers.data.random.RandomTimes.someTimeLastYearOnDay;
import static shiver.me.timbers.data.random.RandomTimes.someTimeNextHour;
import static shiver.me.timbers.data.random.RandomTimes.someTimeNextMinute;
import static shiver.me.timbers.data.random.RandomTimes.someTimeNextMonth;
import static shiver.me.timbers.data.random.RandomTimes.someTimeNextMonthOnThe;
import static shiver.me.timbers.data.random.RandomTimes.someTimeNextSecond;
import static shiver.me.timbers.data.random.RandomTimes.someTimeNextWeek;
import static shiver.me.timbers.data.random.RandomTimes.someTimeNextWeekOn;
import static shiver.me.timbers.data.random.RandomTimes.someTimeNextYear;
import static shiver.me.timbers.data.random.RandomTimes.someTimeNextYearOnDay;
import static shiver.me.timbers.data.random.RandomTimes.someTimeThisHour;
import static shiver.me.timbers.data.random.RandomTimes.someTimeThisMinute;
import static shiver.me.timbers.data.random.RandomTimes.someTimeThisMonth;
import static shiver.me.timbers.data.random.RandomTimes.someTimeThisMonthOnThe;
import static shiver.me.timbers.data.random.RandomTimes.someTimeThisSecond;
import static shiver.me.timbers.data.random.RandomTimes.someTimeThisWeek;
import static shiver.me.timbers.data.random.RandomTimes.someTimeThisWeekOn;
import static shiver.me.timbers.data.random.RandomTimes.someTimeThisYear;
import static shiver.me.timbers.data.random.RandomTimes.someTimeThisYearOnDay;
import static shiver.me.timbers.data.random.RandomTimes.someTimeToday;
import static shiver.me.timbers.data.random.RandomTimes.someTimeTomorrow;
import static shiver.me.timbers.data.random.RandomTimes.someTimeYesterday;
import static shiver.me.timbers.data.random.test.DateMatchers.isBetween;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeLastHour;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeLastMinute;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeLastMonth;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeLastMonthOnThe;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeLastWeek;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeLastWeekOn;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeLastYear;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeLastYearOnDay;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeNextHour;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeNextMinute;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeNextMonth;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeNextMonthOnThe;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeNextWeek;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeNextWeekOn;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeNextYear;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeNextYearOnDay;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeThisHour;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeThisMinute;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeThisMonth;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeThisMonthOnThe;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeThisWeek;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeThisWeekOn;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeThisYear;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeThisYearOnDay;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeToday;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeTomorrow;
import static shiver.me.timbers.data.random.test.DateMatchers.isSometimeYesterday;
import static shiver.me.timbers.data.random.test.DateMatchers.maxDaysLastMoneth;
import static shiver.me.timbers.data.random.test.DateMatchers.maxDaysNextMoneth;
import static shiver.me.timbers.data.random.test.DateMatchers.maxDaysThisMoneth;

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
    public void Can_generate_a_random_time_that_falls_last_second() {

        // When
        final Date actual = someTimeLastSecond();

        // Then
        assertThat(actual, DateMatchers.isSometimeLastSecond());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_this_second() {

        // When
        final Date actual = someTimeThisSecond();

        // Then
        assertThat(actual, DateMatchers.isSometimeThisSecond());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_next_second() {

        // When
        final Date actual = someTimeNextSecond();

        // Then
        assertThat(actual, DateMatchers.isSometimeNextSecond());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_last_minute() {

        // When
        final Date actual = someTimeLastMinute();

        // Then
        assertThat(actual, isSometimeLastMinute());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_this_minute() {

        // When
        final Date actual = someTimeThisMinute();

        // Then
        assertThat(actual, isSometimeThisMinute());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_next_minute() {

        // When
        final Date actual = someTimeNextMinute();

        // Then
        assertThat(actual, isSometimeNextMinute());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_last_hour() {

        // When
        final Date actual = someTimeLastHour();

        // Then
        assertThat(actual, isSometimeLastHour());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_this_hour() {

        // When
        final Date actual = someTimeThisHour();

        // Then
        assertThat(actual, isSometimeThisHour());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_next_hour() {

        // When
        final Date actual = someTimeNextHour();

        // Then
        assertThat(actual, isSometimeNextHour());
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


    @Test
    public void Can_generate_a_random_time_that_falls_last_month() {

        // When
        final Date actual = someTimeLastMonth();

        // Then
        assertThat(actual, isSometimeLastMonth());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_this_month() {

        // When
        final Date actual = someTimeThisMonth();

        // Then
        assertThat(actual, isSometimeThisMonth());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_next_month() {

        // When
        final Date actual = someTimeNextMonth();

        // Then
        assertThat(actual, isSometimeNextMonth());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_last_month_on_a_specific_day() {

        // Given
        final Integer date = someIntegerBetween(1, maxDaysLastMoneth() + 1);

        // When
        final Date actual = someTimeLastMonthOnThe(date);

        // Then
        assertThat(actual, isSometimeLastMonthOnThe(date));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_this_month_on_a_specific_day() {

        // Given
        final Integer date = someIntegerBetween(1, maxDaysThisMoneth() + 1);

        // When
        final Date actual = someTimeThisMonthOnThe(date);

        // Then
        assertThat(actual, isSometimeThisMonthOnThe(date));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_next_month_on_a_specific_day() {

        // Given
        final Integer date = someIntegerBetween(1, maxDaysNextMoneth() + 1);

        // When
        final Date actual = someTimeNextMonthOnThe(date);

        // Then
        assertThat(actual, isSometimeNextMonthOnThe(date));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_last_year() {

        // When
        final Date actual = someTimeLastYear();

        // Then
        assertThat(actual, isSometimeLastYear());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_this_year() {

        // When
        final Date actual = someTimeThisYear();

        // Then
        assertThat(actual, isSometimeThisYear());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_next_year() {

        // When
        final Date actual = someTimeNextYear();

        // Then
        assertThat(actual, isSometimeNextYear());
    }

    @Test
    public void Can_generate_a_random_time_that_falls_last_year_on_a_specific_day() {

        // Given
        final Integer day = someIntegerBetween(1, 366);

        // When
        final Date actual = someTimeLastYearOnDay(day);

        // Then
        assertThat(actual, isSometimeLastYearOnDay(day));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_this_year_on_a_specific_day() {

        // Given
        final Integer day = someIntegerBetween(1, 366);

        // When
        final Date actual = someTimeThisYearOnDay(day);

        // Then
        assertThat(actual, isSometimeThisYearOnDay(day));
    }

    @Test
    public void Can_generate_a_random_time_that_falls_next_year_on_a_specific_day() {

        // Given
        final Integer day = someIntegerBetween(1, 366);

        // When
        final Date actual = someTimeNextYearOnDay(day);

        // Then
        assertThat(actual, isSometimeNextYearOnDay(day));
    }
}
