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

/**
 * @author Karl Bennett
 */
interface Calendar {

    Calendar minusSeconds(int seconds);

    Calendar addSeconds(int seconds);

    Calendar minusMinutes(int minutes);

    Calendar addMinutes(int minutes);

    Calendar minusHours(int hours);

    Calendar addHours(int hours);

    Calendar minusDays(int days);

    Calendar addDays(int days);

    Calendar withDayOfWeek(WeekDay weekDay);

    Calendar minusWeeks(int weeks);

    Calendar addWeeks(int weeks);

    Calendar withDateOfMonth(int date);

    Calendar minusMonths(int months);

    Calendar addMonths(int months);

    Calendar withDayOfYear(int day);

    Calendar minusYears(int years);

    Calendar addYears(int years);

    int daysInMonth();

    int daysInYear();

    long getTime();
}
