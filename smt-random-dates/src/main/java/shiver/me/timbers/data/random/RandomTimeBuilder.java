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

import java.util.Date;

/**
 * @author Karl Bennett
 */
public class RandomTimeBuilder extends Date {

    private final Calendars calendars;
    private final Numbers<Long> longs;

    RandomTimeBuilder(Calendars calendars, Numbers<Long> longs, long time) {
        super(time);
        this.calendars = calendars;
        this.longs = longs;
    }

    RandomTimeBuilder inThePast() {
        // longs.someNegativeNumber() may produce 0 so subtract 1 to make sure the time is in the past.
        setTime(getTime() + (longs.someNegativeNumber() - 1));
        return this;
    }

    RandomTimeBuilder inTheFuture() {
        // longs.somePositiveNumber() may produce 0 so add 1 to make sure the time is in the future.
        setTime(getTime() + (longs.somePositiveNumber() + 1));
        return this;
    }

    public RandomTimeBuilder minusSecond(int seconds) {
        setTime(calendars.create(getTime()).minusSeconds(seconds).getTime());
        return this;
    }

    public RandomTimeBuilder addSecond(int seconds) {
        setTime(calendars.create(getTime()).addSeconds(seconds).getTime());
        return this;
    }

    public RandomTimeBuilder minusMinutes(int minutes) {
        setTime(calendars.create(getTime()).minusMinutes(minutes).getTime());
        return this;
    }

    public RandomTimeBuilder addMinutes(int minutes) {
        setTime(calendars.create(getTime()).addMinutes(minutes).getTime());
        return this;
    }

    public RandomTimeBuilder minusHours(int hours) {
        setTime(calendars.create(getTime()).minusHours(hours).getTime());
        return this;
    }

    public RandomTimeBuilder addHours(int hours) {
        setTime(calendars.create(getTime()).addHours(hours).getTime());
        return this;
    }

    public RandomTimeBuilder minusDays(int days) {
        setTime(calendars.create(getTime()).minusDays(days).getTime());
        return this;
    }

    public RandomTimeBuilder addDays(int days) {
        setTime(calendars.create(getTime()).addDays(days).getTime());
        return this;
    }

    public RandomTimeBuilder minusWeeks(int weeks) {
        setTime(calendars.create(getTime()).minusWeeks(weeks).getTime());
        return this;
    }

    public RandomTimeBuilder addWeeks(int weeks) {
        setTime(calendars.create(getTime()).addWeeks(weeks).getTime());
        return this;
    }

    public RandomTimeBuilder minusMonths(int months) {
        setTime(calendars.create(getTime()).minusMonths(months).getTime());
        return this;
    }

    public RandomTimeBuilder addMonths(int months) {
        setTime(calendars.create(getTime()).addMonths(months).getTime());
        return this;
    }

    public RandomTimeBuilder minusYears(int years) {
        setTime(calendars.create(getTime()).minusYears(years).getTime());
        return this;
    }

    public RandomTimeBuilder addYears(int years) {
        setTime(calendars.create(getTime()).addYears(years).getTime());
        return this;
    }
}
