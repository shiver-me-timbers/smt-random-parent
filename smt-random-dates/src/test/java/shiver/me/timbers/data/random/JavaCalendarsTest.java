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

import org.joda.time.DateTime;
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
        assertThat(actual.getTime(), is(expected));
    }

    @Test
    public void Can_create_a_calendar_for_now() {

        // When
        final Calendar actual = calendars.now();

        // Then
        assertThat(new Date(actual.getTime()), isOn(new Date()).within(10, MILLISECONDS));
    }

    @Test
    public void Can_create_a_calendar_for_the_start_of_this_second() {

        // When
        final Calendar actual = calendars.startOfThisSecond();

        // Then
        assertThat(
            actual.getTime(),
            equalTo(DateTime.now().withMillisOfSecond(0).toDate().getTime())
        );
    }

    @Test
    public void Can_create_a_calendar_for_the_start_of_this_minute() {

        // When
        final Calendar actual = calendars.startOfThisMinute();

        // Then
        assertThat(
            actual.getTime(),
            equalTo(DateTime.now().withSecondOfMinute(0).withMillisOfSecond(0).toDate().getTime())
        );
    }

    @Test
    public void Can_create_a_calendar_for_the_start_of_this_hour() {

        // When
        final Calendar actual = calendars.startOfThisHour();

        // Then
        assertThat(
            actual.getTime(),
            equalTo(DateTime.now().withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0).toDate().getTime())
        );
    }

    @Test
    public void Can_create_a_calendar_for_midnight_today() {

        // When
        final Calendar actual = calendars.midnightToday();

        // Then
        assertThat(actual.getTime(), equalTo(LocalDate.now().toDate().getTime()));
    }
}