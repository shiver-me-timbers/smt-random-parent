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

import java.util.GregorianCalendar;

import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MILLISECOND;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;

/**
 * @author Karl Bennett
 */
class JavaCalendars implements Calendars {

    @Override
    public Calendar create(Long time) {
        java.util.Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(time);

        return new JavaCalendar(calendar);
    }

    @Override
    public Calendar now() {
        return new JavaCalendar(new GregorianCalendar());
    }

    @Override
    public Calendar startOfThisSecond() {
        return new JavaCalendar(startOfThisSecond(new GregorianCalendar()));
    }

    @Override
    public Calendar startOfThisMinute() {
        return new JavaCalendar(startOfThisMinute(new GregorianCalendar()));
    }

    @Override
    public Calendar startOfThisHour() {
        return new JavaCalendar(startOfThisHour(new GregorianCalendar()));
    }

    @Override
    public Calendar midnightToday() {
        java.util.Calendar midnight = startOfThisHour(new GregorianCalendar());
        midnight.set(HOUR_OF_DAY, 0);
        return new JavaCalendar(midnight);
    }

    private java.util.Calendar startOfThisHour(java.util.Calendar calendar) {
        final java.util.Calendar startOfThisHour = startOfThisMinute(calendar);
        startOfThisHour.set(MINUTE, 0);
        return startOfThisHour;
    }

    private java.util.Calendar startOfThisMinute(java.util.Calendar calendar) {
        final java.util.Calendar startOfThisMinute = startOfThisSecond(calendar);
        calendar.set(SECOND, 0);
        return startOfThisMinute;
    }

    private java.util.Calendar startOfThisSecond(java.util.Calendar calendar) {
        calendar.set(MILLISECOND, 0);
        return calendar;
    }
}
